package com.example.aopdemo.config;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDao;
import com.example.aopdemo.service.TrafficFortuneService;

public class AroundMainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAopConfig.class);
		
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("Executing ===> Around");
		System.out.println("calling getFortune");
		
		String data  = fortuneService.getFortune();
		
		System.out.println("\n My Fortue is : " +data);
		System.out.println("Finished");
		context.close();
	}

}
