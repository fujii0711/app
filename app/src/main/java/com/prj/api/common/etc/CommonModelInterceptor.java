package com.prj.api.common.etc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// HandlerInterceptorAdapter 클래스는 HandlerInterceptor 인터페이스를 구현하고 있는데
// 각 메소드는 아무 기능도 수행하지 않는다. 따라서, HandlerInterceptor 인터페이스의 메소드를 모두 구현할 필요가 없다면,
// HandlerInterceptorAdapter 클래스를 상속받은 뒤 필요한 메소드만 재정의하면 된다.
public class CommonModelInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonModelInterceptor.class);
	
	// preHandle() 메소드를 컨트롤러/핸들러 객체를 실행가지 전에 필요한 기능을 구현할 때 사용된다.
	// handler 파라미터는 웹 요청을 처리할 컨트롤러/핸들러 객체이다.
	// 이 메소드를 사용하면 접근 권한이 없는 경우 컨트롤러를 실행하지 않는다거나, 컨트롤러를 실행하기 전에 
	// 컨트롤러에서 필요로 하는 정보를 생성하는 등의 작업이 가능하다.
	@Override
	public boolean preHandle(HttpServletRequest request
							,HttpServletResponse response
							,Object handler) throws Exception {
		//logger.info("VM: preHandle()");
		request.setAttribute("mi.beginTime", System.currentTimeMillis());
		// preHandle() 메소드의 리턴 타입은 boolean인데, preHandle() 메소드가 false를 리턴하면 컨트롤러를
		// 실행하지 않는다.
		return true;
	}

	// postHandle() 메소드는 컨트롤러/핸들러가 정상적으로 실행된 이후에 추가 기능을 구현할 때 사용된다.
	// 만약 컨트롤러가 익셉션을 발생하면 postHandle()메소드는 실행되지 않는다.
	/*@Override
	public void postHandle(HttpServletRequest request
						  ,HttpServletResponse response
						  ,Object handler
						  ,ModelAndView modelAndView) throws Exception {
		logger.info("VM: postHandle()");
	}*/
		
	// afterCompletion() 메소드는 클라이언트에 뷰를 전송한 뒤에 실행된다.
	// 만약 컨트롤러를 실행하는 과정에서 익셉션이 발생하면, 이 메소드의 네번째 파라미터로 전달된다.
	// 익셉션이 발생하지 않았다면 네 번째 파라미터는 null이 된다. 따라서, 컨트롤러 실행 이후에 예기치 않게 발생한
	// 익셉션을 로그로 남긴다거나 실행 시간을 기록하는 등의 후처리를 하기에 적합한 메소드이다.
	@Override
	public void afterCompletion(HttpServletRequest request
							   ,HttpServletResponse response
							   ,Object handler
							   ,Exception ex) throws Exception {
		//logger.info("VM: afterCompletion()");
		Long beginTime = (Long) request.getAttribute("mi.beginTime");
		long endTime = System.currentTimeMillis();
		logger.info(request.getRequestURI() + " 실행 시간: " + (endTime - beginTime));
	}
}
