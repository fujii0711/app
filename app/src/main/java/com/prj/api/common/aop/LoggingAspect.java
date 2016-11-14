package com.prj.api.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	public void logBefore(JoinPoint joinPoint) {
		logger.info("################################################################ LOGGING START ############################################################################");
		Signature signature = joinPoint.getSignature();
		Object target = joinPoint.getTarget();
		Object[] args = joinPoint.getArgs();
	  
		logger.info("[1.Signature] : " + signature.toString());
		logger.info("[2.Class]: " + target.getClass().getName());
		logger.info("[3.Method] : " + signature.getName());
	  
		for(int i=0; i < args.length; i++){
			logger.info("[4.Input Parameter]_" + i + ": " + args[i].toString());
		}
		logger.info("################################################################# LOGGING END #############################################################################");
	}
}