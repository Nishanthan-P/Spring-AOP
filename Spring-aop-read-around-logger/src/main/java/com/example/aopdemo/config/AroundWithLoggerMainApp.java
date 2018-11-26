package com.example.aopdemo.config;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDao;
import com.example.aopdemo.dao.MembershipDao;
import com.example.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerMainApp {
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerMainApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAopConfig.class);
		
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("Executing ===> Around");
		myLogger.info("calling getFortune");
		
		boolean tripWire = true;
		
		String data  =null;
		data = fortuneService.getFortune(tripWire);
		
		myLogger.info("\n My Fortue is : " +data);
		myLogger.info("Finished");
		context.close();
	}

}
