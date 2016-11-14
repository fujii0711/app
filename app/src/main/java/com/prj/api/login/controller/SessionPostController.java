package com.prj.api.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prj.api.login.vo.SessionVO;

@Controller
public class SessionPostController {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionPostController.class);
	
	@RequestMapping(value = "/login/loginPost.do", method = RequestMethod.GET)
	public ModelAndView loginMove(ModelAndView mav ,HttpServletRequest request) {
		SessionVO sessionVO = (SessionVO)request.getSession().getAttribute("authCheck");	
		if(sessionVO != null){
			logger.info("세션존재");
			logger.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			logger.info("sessionVOPost="+sessionVO.toString());
			logger.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");			
			mav.addObject("postData", sessionVO);
			mav.setViewName("login/loginPost");
		} else {
			logger.info("세션없음");
			mav.setViewName("login/login");
		}
		return mav;
	}
}
