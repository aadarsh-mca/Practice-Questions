package com.app.bank.core;

import com.app.bank.BankAccount;

public interface CoreBanking {
	
	public abstract void openBankAccount(String firstName, String lastName, AccountType accountType, int defaultBalance);
	public void displayAllAccount();
	public void depositFund(int accountNo, int fundToBeAdded);
	public void withdrawFund(int accountNo, int fundToBeWithdrawn);
	public void deleteAccount(int accountNo);
	
}
