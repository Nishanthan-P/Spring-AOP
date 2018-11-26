package com.example.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.aopdemo.config.Account;

@Component
public class AccountDao {

	private String name;
	
	private String email;
	
	//add a new method: findAccouts
	public List<Account> findAccounts(){
		List<Account> accounts = new ArrayList<>();
		
		//sample accounts
		Account temp1 = new Account("John","silver");
		Account temp2 = new Account("mike","gold");
		Account temp3 = new Account("Richard","Bronze");
		
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);
		return accounts;
	}
	
	public String addAccount(Boolean boo){
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
