package xo.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAOPAspect {

	@Before("executeTaskWithAOP()") // point-cut expression
	public void before(final JoinPoint joinPoint) {
		System.out.println("The name of the join point before is: " + joinPoint.getSignature().getName());
	}

	@After("executeTaskWithAOP()") // point-cut expression
	public void after(final JoinPoint joinPoint) {
		System.out.println("The name of the join point after is: " + joinPoint.getSignature().getName());
	}

//	@Around("executeTaskWithAOP()") // point-cut expression
//	public void around(final JoinPoint joinPoint) {
//		System.out.println("The name of the join point around is: " + joinPoint.getSignature().getName());
//	}

	@Pointcut("execution(* xo.example.controller.EmployeeController.sayHello(..))")
	public void executeTaskWithAOP() {
		// Nothing to do.
	}

}
