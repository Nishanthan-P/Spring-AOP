package com.example.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
//	@Before("execution(public void  com.example.aopdemo.dao.AccountDaoaddAccount())")
//	@Before("execution(public void  add*())")
//	@Before("execution(void  add*())")
//	@Before("forDaoPackage()")
	
//	@Before("forDaoPackage()")
	
	@Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable{
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("Executing  @Around ===>"+method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		try{
			result = joinPoint.proceed();
		}catch(Exception e){
		//	e.printStackTrace();
			myLogger.warning(e.getMessage());
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("\n===> Duration : "+ duration / 1000.0 + "seconds");
		return result;
	}
	
	
	
	@After("execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccounts(JoinPoint joinPoint){
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("Executing After @After(Finally) ===>"+method);
		
		
	}
	
	@AfterThrowing(pointcut="execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",throwing = "theExc")
	public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable theExc){
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("Executing After returning ===>"+method);
		
		myLogger.info("\n The exception is : "+theExc);
	}
	
	@AfterReturning(pointcut="execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturnFindAccounts(JoinPoint joinPoint, List<Account> result){
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("Executing After returning ===>"+method);
		
		myLogger.info("Executing After returning ===>"+result);
		
		convertAccountNameToUppercase(result);
		
		myLogger.info("\n ======> " +result);
	}
	
	
	private void convertAccountNameToUppercase(List<Account> result) {
			
			for(Account tempAcc : result){
				String accName = tempAcc.getName().toUpperCase();
				tempAcc.setName(accName);
			}
			
		}
	@Before("com.example.aopdemo.aspect.AopExpressions.excludeGetSet()")
	public void logToCloud(JoinPoint joinPoint){
		myLogger.info("\n=====> Executing logToCloud");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method : "+methodSignature);
		
		//display method arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object methodArgs : args){
			myLogger.info(methodArgs.toString());
		}
	}
	
	
}
