package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void  com.example.aopdemo.dao.AccountDaoaddAccount())")
//	@Before("execution(public void  add*())")
//	@Before("execution(void  add*())")
//	@Before("forDaoPackage()")
	
	
//	@Before("forDaoPackage()")
	
	
	@Before("com.example.aopdemo.aspect.AopExpressions.excludeGetSet()")
	public void logToCloud(){
		System.out.println("\n=====> Executing logToCloud");
	}
	
	
}
