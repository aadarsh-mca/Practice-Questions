package com.app.validator.exception;

import java.lang.Exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}

}
