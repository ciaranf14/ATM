package com.intreview.assessment.ATM.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class BankDataBase {
	
	private ArrayList<Account> registeredAccounts = new ArrayList<Account>();
	
	public BankDataBase(){   
		registeredAccounts.add(new Account(123456789, 1234, 800, 200));  
		registeredAccounts.add(new Account(987654321, 4321, 1230, 150));  
	   }

	public ArrayList<Account> getRegisteredAccounts() {
		return registeredAccounts;
	}						 
	
}
