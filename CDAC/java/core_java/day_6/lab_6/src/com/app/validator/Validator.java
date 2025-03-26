package com.app.validator;

import com.app.validator.exception.MinBalanceException;

public class Validator {
	private static final int MIN_BALANCE = 5000;
	
	public static void minBalanceValidator(int defaultBalance) throws MinBalanceException {
		if(defaultBalance < MIN_BALANCE) {
			throw new MinBalanceException("Initial balance to open an account is less minimum balance !!!");
		}
	}
	
}