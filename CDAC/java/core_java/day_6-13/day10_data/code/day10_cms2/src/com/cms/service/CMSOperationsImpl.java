package com.cms.service;

import static com.cms.validations.CMSValidations.parseAndValidatePlan;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;

public class CMSOperationsImpl implements CMSOperations {
	// state
	private ArrayList<Customer> customers;

	// add a ctor
	public CMSOperationsImpl() {
		this.customers = new ArrayList<>();
	}

	@Override
	public String registerCustomer(String firstName, String lastName, String email, String password, double regAmount,
			String dob, String plan) throws CMSException, IllegalArgumentException {
		// 1. invoke validation rule
		ServicePlan myPlan = parseAndValidatePlan(plan, regAmount);
		// 2. => success
		// parse DoB
		LocalDate date = LocalDate.parse(dob);
		Customer c = new Customer(firstName, lastName, email, password, regAmount, date, myPlan);
		customers.add(c);
		return "Customer reg successful , Your ID " + c.getCustomerId();
	}

	@Override
	public String authenticate(String email, String password) throws CMSException {
		// 1. find the customer by its email , based on equals
		// In case of success - Customer ref n o.w - throw CMSExc
		Customer customer = findByEmail(email);
		// => email is valid , 2. chk for pwd
		if (customer.getPassword().equals(password))
			return "Login Successful ! Hello " + customer.getFirstName() + " " + customer.getLastName();
		throw new CMSException("Auth Failure , Invalid Password!!!!!!!!");

	}

	public Customer findByEmail(String email) throws CMSException {
		Customer cust = new Customer(email);
		// indexOf
		int index = customers.indexOf(cust);
		if (index == -1)
			throw new CMSException("Auth Failure , Invalid Email!!!!!!!!");
		return customers.get(index);
	}

}
