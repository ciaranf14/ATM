package com.intreview.assessment.ATM.model;

public class Account {
	private int accountId;
	private int pin;
	private int balance;
	private int overDraft;
	private int totalWithdrawal = balance + overDraft;
	
	public Account(int accountId, int pin, int balance, int overDraft) {
		super();
		this.accountId = accountId;
		this.pin = pin;
		this.balance = balance;
		this.overDraft = overDraft;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getOverDraft() {
		return overDraft;
	}
	public void setOverDraft(int overDraft) {
		this.overDraft = overDraft;
	}

	public int getTotalWithdrawal() {
		return totalWithdrawal;
	}

	public void setTotalWithdrawal(int totalWithdrawal) {
		this.totalWithdrawal = totalWithdrawal;
	}
	
	
}
