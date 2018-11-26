package com.example.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aopdemo.config.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
//	@Before("execution(public void  com.example.aopdemo.dao.AccountDaoaddAccount())")
//	@Before("execution(public void  add*())")
//	@Before("execution(void  add*())")
//	@Before("forDaoPackage()")
	
	
//	@Before("forDaoPackage()")
	
	@AfterThrowing(pointcut="execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",throwing = "theExc")
	public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable theExc){
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing After returning ===>"+method);
		
		System.out.println("\n The exception is : "+theExc);
	}
	
	@AfterReturning(pointcut="execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturnFindAccounts(JoinPoint joinPoint, List<Account> result){
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing After returning ===>"+method);
		
		System.out.println("Executing After returning ===>"+result);
		
		convertAccountNameToUppercase(result);
		
		System.out.println("\n ======> " +result);
	}
	
	
	private void convertAccountNameToUppercase(List<Account> result) {
			
			for(Account tempAcc : result){
				String accName = tempAcc.getName().toUpperCase();
				tempAcc.setName(accName);
			}
			
		}
	@Before("com.example.aopdemo.aspect.AopExpressions.excludeGetSet()")
	public void logToCloud(JoinPoint joinPoint){
		System.out.println("\n=====> Executing logToCloud");
		
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method : "+methodSignature);
		
		//display method arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object methodArgs : args){
			System.out.println(methodArgs);
		}
	}
	
	
}
