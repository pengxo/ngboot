package com.pengxo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAOPAspect {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeAOPAspect.class);

	@Before("executeTaskWithAOP()") // point-cut expression
	public void before(final JoinPoint joinPoint) {
		logger.debug("The name of the join point before is: {}", joinPoint.getSignature().getName());
	}

	@After("executeTaskWithAOP()") // point-cut expression
	public void after(final JoinPoint joinPoint) {
		logger.debug("The name of the join point after is: {}", joinPoint.getSignature().getName());
	}

	@Pointcut("execution(* com.pengxo.controller.EmployeeController.sayHello(..))")
	public void executeTaskWithAOP() {
		// Nothing to do.
	}

}
