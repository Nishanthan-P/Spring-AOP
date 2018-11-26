package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

	private String name;
	
	private String email;
	
	public String addAccount(){
		System.out.println(getClass() +" Doing my Db work : adding an account");
		return "aop";
	}
	
	public String updAccount(){
		System.out.println(getClass() +" Doing my Db work : updating an account");
		return "aop";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		System.out.println(getClass() +" getName");
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println(getClass() +"set Name");
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		System.out.println(getClass() +" getEmail");
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		System.out.println(getClass() +" setEmail");
		this.email = email;
	}

	
}
