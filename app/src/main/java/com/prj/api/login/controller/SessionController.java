package com.prj.api.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.prj.api.login.vo.SessionVO;

/**
 * - @SessionAttributes을 이용해서 각 화면 간 모델 데이터를 공유하는 방법
 * 1) 클래스에 @SessionAttributes를 적용하고, 세션으로 공유할 객체의 모델 이름을 지정한다.
 * 2) 컨트롤러 메소드에서 객체를 모델에 추가한다.
 * 3) 공유한 모델의 사용이 끝나면 SessionStatus를 사용해서 세션에서 객체를 제거한다.
 * 
 * - 스프링은 임시 용도로 사용될 데이터를 세션에 보관할 때 사용할 수 있는 @SessionAttribute 애노테이션을 제공
 * 세션을 이용해서 특정 객체를 공유하려면, 객체를 세션에 보관할 때 사용할 속성 이름이 필요한데, @SessionAttribute
 * 애노테이션을 사용해서 이 이름을 지정하게 된다.
 */

@Controller
@SessionAttributes("authCheck")
public class SessionController {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
	
	private static final String LOGIN = "login/login";
	private static final String LOGIN_CHECK = "login/loginCheck";
	private static final String LOGIN_OUT = "login/loginOut";
	
	@RequestMapping(value = "/login/login.do", method = RequestMethod.GET)
	public ModelAndView loginMove(ModelAndView mav) {
		mav.addObject("authCheck", new SessionVO());
		mav.setViewName(LOGIN);
		return mav;
	}

	@RequestMapping("/login/loginCheck.do")
	public ModelAndView login_post(ModelAndView mav ,@ModelAttribute("authCheck") SessionVO sessionVO) {		
		logger.info("sessionVO_loginCheck="+sessionVO);
		
		// 회원 아이디로 DB조회 존재 결과 로직
		
		// 새션이 존재한 경우
		if(sessionVO != null){
			logger.info("세션존재");
			mav.addObject("authCheck", sessionVO);
			mav.setViewName(LOGIN_CHECK);
		// 세션이 존재하지 않는 경우
		} else {
			logger.info("세션없음");
			mav.setViewName(LOGIN);
		}		
		return mav;
	}

	/** 
	 * @param SessionData
	 * @param sessionStatus
	 * @return
	 * sessionStatus.setComplete() 메소드를 실행하면 세션에서 객체를 제거한다.
	 * 위 코드의 경우 세션의 "authCheck" 속성을 제거한다. 단, sessionStatus.setComplete()는 세션에서 객체를
	 * 제거할 뿐 모델에서 제거하지는 않는다. 따라서, 뷰 코드에서는 모델의 값을 사용할 수 있다.
	 * JSP 코드에서 ${authCheck.abc}의 값은 데이터 살아있음
	 * session.getAttribute("authCheck")의 값은 null임
	 */
	@RequestMapping(value = "/login/loginOut.do")
	public ModelAndView done(ModelAndView mav ,@ModelAttribute("authCheck") SessionVO SessionVO ,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		mav.setViewName(LOGIN_OUT);
		return mav;
	}
	
	/**
	 * @ModelAttributes 없이 만드는 방법
	 */
	/*@RequestMapping("/login/login_post.do")
	public String login_post(@ModelAttribute("authCheck") SessionVO sessionVO ,Model model) {
		logger.info("SessionVO="+sessionVO);
		logger.info("sessionVO.toString()="+sessionVO.toString());
		model.addAttribute("SessionVO", sessionVO);
		return "login/login_post";
	}*/
}
