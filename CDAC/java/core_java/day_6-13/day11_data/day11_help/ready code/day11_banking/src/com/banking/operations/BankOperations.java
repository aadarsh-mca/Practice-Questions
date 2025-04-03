package com.banking.operations;

import java.util.ArrayList;

import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;

public interface BankOperations {
//add a method for creating bank account
	String createAccount(int acctNo, String customerName, int openingBalnce, String openingDate, String acctType)
			throws BankingException;

	// add a method to get a/c summary
	BankAccount getAccountSummary(int acctNo) throws BankingException;

	// add a method to deposit funds
	String depositFunds(int acctNo, int amount) throws BankingException;

	// add a method to close the a/c
	String closeAccount(int acctNo) throws BankingException;

}
