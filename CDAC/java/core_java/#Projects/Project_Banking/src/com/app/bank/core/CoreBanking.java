package com.app.bank.core;

import java.time.LocalDate;

import com.app.bank.AccountType;
import com.app.bank.BankAccount;

public interface CoreBanking {
	
	void openBankAccount(int accountNo, String firstName, String lastName, LocalDate dob, AccountType accountType);
	void openBankAccount(int accountNo, String firstName, String lastName, LocalDate dob, AccountType accountType, int defaultBalance);
	
	void displayAllAccount(int choice);
	void searchAccount(int accountNo);
	
	void depositFund(int accountNo, int fundToBeAdded);
	int withdrawFund(int accountNo, int fundToBeWithdrawn);
	void transferAmount(int fromAccount, int toAccount, int transferAmount);
	void getAccountStatement(int accountNo);
	
	void closeAccount(int accountNo);
}
