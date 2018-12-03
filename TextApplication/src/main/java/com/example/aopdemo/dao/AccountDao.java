package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

	public String addAccount(){
		System.out.println(getClass() +" Doing my Db work : adding an account");
		return "aop";
	}
}
