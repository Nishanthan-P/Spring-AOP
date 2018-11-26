package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspectTwo {

	@Before("com.example.aopdemo.aspect.AopExpressions.excludeGetSet()")
	public void performBeforeAdvice(){
		System.out.println("\n=====> Executing performBeforeAdvice ");
	}
}
