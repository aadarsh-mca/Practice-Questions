package com.cms.service;

import com.cms.core.Customer;
import com.cms.custom_exceptions.CMSException;

public interface CMSOperations {
//add a method declaration for customer sign up
	String registerCustomer(String firstName, String lastName, 
			String email, String password, double regAmount,
			String dob, String plan) throws CMSException,IllegalArgumentException;

	Customer authenticate(String email, String password) throws CMSException;

	void displayAllCustomers();

	void displayCustomersByDob(String dob);

	void upgradeSeniorCustomers();

	String changePassword(String email, String oldPwd, String newPwd) throws CMSException;

	String unsubscribeCustomer(String email) throws CMSException;

	void deleteCustomersByPlan(String plan);

	void sortCustomersByEmail();

	void sortCustomersByDoB();

	void sortCustomersByDoBAndRegAmount();

	void sortCustomersByLastNames();
}
