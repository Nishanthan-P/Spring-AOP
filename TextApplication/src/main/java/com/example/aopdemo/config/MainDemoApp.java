package com.example.aopdemo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAopConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		accountDao.addAccount();
		
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
		
		membershipDao.addAccount();
		
		context.close();
	}

}
