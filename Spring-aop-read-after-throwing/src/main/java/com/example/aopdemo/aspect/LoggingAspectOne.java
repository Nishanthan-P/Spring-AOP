package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspectOne {

	@Before("com.example.aopdemo.aspect.AopExpressions.excludeGetSet()")
	public void beforeAddAccountAdvice(){
		System.out.println("\n=====> Executing beforeAddAccountAdvice");
	}
}
