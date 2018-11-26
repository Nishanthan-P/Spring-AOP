package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public void addAccount(){
		System.out.println(getClass() +"\n Adding membership account");
	}
}
