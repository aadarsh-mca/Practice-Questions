package com.banking.validations;

import com.banking.core.AccountType;
import com.banking.custom_exceptions.BankingException;

public class BankingValidations {
	public static final int MIN_BALANCE;
	static {
		MIN_BALANCE = 5000;
	}

//add a static method to validation balance
	public static void validateBalance(int balance) throws BankingException {
		if (balance < MIN_BALANCE)
			throw new BankingException("Insufficient Balance !!!!!");
	}

	// add a static method to validate account type
	public static AccountType validateAccountType(String acctType) throws IllegalArgumentException {
		return AccountType.valueOf(acctType.toUpperCase());
	}

}
