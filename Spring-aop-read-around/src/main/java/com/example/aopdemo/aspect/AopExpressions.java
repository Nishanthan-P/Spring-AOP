package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {

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
		public void excludeGetSet(){}
}
