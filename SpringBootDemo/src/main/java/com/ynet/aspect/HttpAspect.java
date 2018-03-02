package com.ynet.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author hansz
 * @version 2018年2月28日 上午11:26:50
 * @Description TODO AOP输出日志
 */
@Component
@Aspect
public class HttpAspect {
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(* com.ynet.controller.*.*(..)) or execution(* com.ynet.service.*.*(..))")
	public void log() {
	}


	@Around("log()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		// url
		logger.info("url = {}", request.getRequestURL());
		// method
		logger.info("method = {}", request.getMethod());
		// ip
		logger.info("ip = {}", request.getRemoteAddr());
		// 类方法
		logger.info("class_method = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName() + "·" + proceedingJoinPoint.getSignature().getName());
		// 参数
		logger.info("args = {}", proceedingJoinPoint.getArgs());
		
		Object ret = proceedingJoinPoint.proceed();
		logger.info("response = {}",null != ret ? ret.toString() : null);
		return ret;
	}
}
