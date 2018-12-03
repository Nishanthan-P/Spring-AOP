package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void  com.example.aopdemo.dao.AccountDaoaddAccount())")
//	@Before("execution(public void  add*())")
//	@Before("execution(void  add*())")
	@Before("execution(String  add*())")
	public void beforeAddAccountAdvice(){
		System.out.println("\n=====> Executing before advice on addAccount");
	}

}
