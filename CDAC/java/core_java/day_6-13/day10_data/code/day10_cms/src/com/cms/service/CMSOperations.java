package com.cms.service;

import com.cms.custom_exceptions.CMSException;

public interface CMSOperations {
//add a method declaration for customer sign up
	String registerCustomer(String firstName, String lastName, 
			String email, String password, double regAmount,
			String dob, String plan) throws CMSException,IllegalArgumentException;

	String authenticate(String email, String password) throws CMSException;
}
