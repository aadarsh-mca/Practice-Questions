package com.cdac.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	/*
	 * Add logging advice here -
	 *  to intercept any incoming request
	 */
	@Before("execution (* com.cdac.controller.*.*(..))")
	public void logMessage(JoinPoint joinPoint) {
		log.warn("Before Aspect "+joinPoint);
	}

}
