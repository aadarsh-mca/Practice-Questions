package com.app.validator;

import java.time.LocalDate;
import java.time.Period;

import com.app.bank.AccountType;
import com.app.bank.BankAccount;
import com.app.bank.data.Database;
import com.app.validator.exception.AgeException;
import com.app.validator.exception.InsufficientBalanceException;
import com.app.validator.exception.MinBalanceException;

public class Validate {
	private static final int MIN_AGE = 18;
	private static final int MIN_BALANCE = 5000;
	
	public static void minAge(LocalDate dob) throws AgeException {
		if(Period.between(dob, LocalDate.now()).getYears() < 18) {
			throw new AgeException("\n\tYou must be 18 year old to open a bank account !!!");
		}
	}
	
//	public static void minInitialBalance(int defaultBalance) throws MinBalanceException {
//		if(defaultBalance < MIN_BALANCE) {
//			throw new MinBalanceException("\n\tInitial balance to open an account is less than " + MIN_BALANCE + " !!!");
//		}
//	}
	
	public static void minInitialBalance(AccountType accType, int defaultBalance) throws MinBalanceException {
		switch(accType) {
		case SAVING :
			if(defaultBalance < accType.getMinBalance()) {
				throw new MinBalanceException("\n\tMinimum initial balance to open " + accType.name() + " account is " + accType.getMinBalance() + " !!!");
			}
			break;
		case CURRENT :
			if(defaultBalance < accType.getMinBalance()) {
				throw new MinBalanceException("\n\tMinimum initial balance to open " + accType.name() + " account is " + accType.getMinBalance() + " !!!");
			}
			break;
		}
	}
	
	public static void balance(BankAccount account, int requiredBalance) throws InsufficientBalanceException {
		if(account.getBalance() < requiredBalance) {
			throw new InsufficientBalanceException(Constants.INSUFFICIENT_BALANCE);
		}
	}
	
}