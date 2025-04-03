package com.app.bank;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.app.bank.TransactionHistory;
import com.app.validator.Constants;
import com.app.validator.exception.InsufficientBalanceException;
import com.app.validator.exception.MinBalanceException;
import com.app.validator.exception.NoTransactionException;

public class BankAccount implements Comparable<BankAccount> {
//	private static int accountCounter = 1;
	
	private int accountNo;
	private String firstName;
	private String lastName;
	private AccountType accountType;
	private int balance;
	private LocalDate dob;
	private List<TransactionHistory> transactionList;
	
	public BankAccount(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public BankAccount(int accountNo, String firstName, String lastName, LocalDate dob, AccountType accountType, int defaultBalance) {
		this.accountNo = accountNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.accountType = accountType;
		this.balance = defaultBalance;
		this.transactionList = new ArrayList<TransactionHistory>();
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
	
	public LocalDate getDob() {
		return dob;
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
	
	public List<TransactionHistory> getTransactionHistory() throws NoTransactionException {
		if(this.transactionList.size() <= 0) {
			throw new NoTransactionException(Constants.NO_TRANSACTION_MSG);
		}
		return transactionList;
	}

	public void addTransaction(TransactionHistory history) {
		this.transactionList.add(history);
	}
	

	//
	@Override
	public String toString() {
		return "\n\tAccount No. : " + accountNo + 
				"\n\tName : " + firstName + " " + lastName +
				"\n\tDate of Birth : " + dob + 
				"\n\tAccount Type : " + accountType + 
				"\n\tAccount Balance : " + balance;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BankAccount) {
			return this.accountNo == ((BankAccount)obj).accountNo;
		}
		return false;
	}
	
	@Override
	public int compareTo(BankAccount aObj) {
		return Integer.compare(this.accountNo, aObj.accountNo);
		
//		if(this.accountNo < aObj.accountNo) {
//			return -1;
//		} else if (this.accountNo == aObj.accountNo) {
//			return 0;
//		} else {
//			return 1;
//		}
	}
	
}
