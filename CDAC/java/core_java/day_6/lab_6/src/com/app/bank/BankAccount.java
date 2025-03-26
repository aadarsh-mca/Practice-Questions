package com.app.bank;

import com.app.bank.core.AccountType;
import com.app.validator.exception.InsufficientBalanceException;
import com.app.validator.exception.MinBalanceException;

public class BankAccount {
	private static int accountCounter = 1;
	
	private int accountNo;
	private String firstName;
	private String lastName;
	private AccountType accountType;
	int balance;
	
	public BankAccount(String firstName, String lastName, AccountType accountType, int defaultBalance) {
		this.accountNo = accountCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountType = accountType;
		this.balance = defaultBalance;
	}
	
	@Override
	public String toString() {
		return "\n\tAccount No. : " + accountNo + "\n\tName : " + firstName + " " + lastName + "\n\tAccount Type : " + accountType + "\n\tAccount Balance : " + balance;
	}
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int acountNo) {
		this.accountNo = acountNo;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
