package com.example.aopdemo.config;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDao;

public class AfterFinallyMainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAopConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		List<Account> accounts = null;
		Boolean tripWire= false;
		try{
			accounts = accountDao.findAccounts(tripWire);
		}
		catch(Exception e){
			System.out.println("\n Main Program.... caught Exception : "+e);
		}
		
		System.out.println("\n\n After Throwing : ");
		System.out.println("--------");
		System.out.println("\n"+accounts);
		
		context.close();
	}

}
