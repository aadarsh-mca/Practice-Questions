package com.app.validator.exception;

import java.lang.Exception;

public class AccountDoesNotExistException extends Exception {

	public AccountDoesNotExistException(String msg) {
		super(msg);
	}

}
