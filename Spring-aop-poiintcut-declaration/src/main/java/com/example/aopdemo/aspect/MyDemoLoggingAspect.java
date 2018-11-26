package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void  com.example.aopdemo.dao.AccountDaoaddAccount())")
//	@Before("execution(public void  add*())")
//	@Before("execution(void  add*())")
//	@Before("forDaoPackage()")
	@Before("excludeGetSet()")
	public void beforeAddAccountAdvice(){
		System.out.println("\n=====> Executing before advice on addAccount");
	}
	
//	@Before("forDaoPackage()")
	@Before("excludeGetSet()")
	public void performBeforeAdvice(){
		System.out.println("\n=====> Executing before advice ");
	}
	
	//pointcut declaration
	@Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
	public void forDaoPackage(){
		
	}
	
	//pointcut for getter methods
	@Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
	private void getter(){
		
	}
	
	//pointcut for setter methods
	@Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
	private void setter(){}
	
	//pointcut for exclude get/set methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void excludeGetSet(){}
}
