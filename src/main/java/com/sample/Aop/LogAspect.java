package com.sample.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Component
@Aspect
public class LogAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
	
	@Before("execution(* com.sample.service.Service1.method1(..))")
	public void log1(JoinPoint jp) {
		LOGGER.info("Method called: "+jp.getSignature().getName() + " Before");
	}
	
	@After("execution(* com.sample.service.Service1.method1(..))")
	public void log2(JoinPoint jp) {
		LOGGER.info("Method called: "+jp.getSignature().getName() + " After");
	}
	
	@AfterThrowing("execution(* com.sample.service.Service1.method2(..))")
	public void log3(JoinPoint jp) {
		LOGGER.info("Method called: "+jp.getSignature().getName() + " After Throwing");
	}
	
	@Around("execution(* com.sample.service.Service1.method3(..)) && args(id)")
	public Object log4(ProceedingJoinPoint jp, int id) throws Throwable {
		id = 3;
		Object obj  = jp.proceed(new Object[] {id});
		
		LOGGER.info("Method called: "+jp.getSignature().getName() + " Around" +" id: " + id);
		return obj;
	}

}
