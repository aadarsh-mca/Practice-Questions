package com.cms.service;

import static com.cms.validations.CMSValidations.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;

public class CMSOperationsImpl implements CMSOperations {
	// state
	private ArrayList<Customer> customers;

	/*
	 * Sample Data a1 b1 a1@gmail.com 12345 2000 1990-10-20 gold a2 b2 a2@gmail.com
	 * 22345 1000 1999-05-22 silver a3 b3 a3@gmail.com 13345 5000 1993-11-2 diamond
	 * a4 b4 a4@gmail.com 15345 2000 1994-01-20 gold
	 */
	// add a ctor
	public CMSOperationsImpl() throws CMSException {
		this.customers = new ArrayList<>();
		registerCustomer("a1", "b1", "a1@gmail.com", "12345", 2000, "1990-10-20", "gold");
		System.out.println("--------------------");
		registerCustomer("a2", "b2", "a2@gmail.com", "16345", 1000, "1994-10-20", "silver");
		System.out.println("--------------------");
		registerCustomer("a3", "b3", "a3@gmail.com", "11345", 5000, "1993-10-20", "diamond");
		System.out.println("--------------------");
		registerCustomer("a4", "b4", "a4@gmail.com", "62345", 2000, "1991-02-10", "gold");
		System.out.println("--------------------");
		registerCustomer("a5", "b5", "a5@gmail.com", "92345", 2000, "1996-02-23", "gold");
		System.out.println("--------------------");
	}

	@Override
	public String registerCustomer(String firstName, String lastName, String email, String password, double regAmount,
			String dob, String plan) throws CMSException, IllegalArgumentException {
		// 1. parse n then validate the plan
		ServicePlan myPlan = parsePlan(plan);
		validatePlan(myPlan, regAmount);
		// 2. => success
//		// parse DoB
//		LocalDate date = LocalDate.parse(dob);
		LocalDate date = parseDob(dob);
		// 3. validate email
		validateEmail(email, customers);
		// => all valid inputs....
		Customer c = new Customer(firstName, lastName, email, password, regAmount, date, myPlan);
		customers.add(c);
		return "Customer reg successful , Your ID " + c.getCustomerId();
	}

	@Override
	public Customer authenticate(String email, String password) throws CMSException {
		// 1. find the customer by its email , based on equals
		// In case of success - Customer ref n o.w - throw CMSExc
		Customer customer = findByEmail(email);
		// => email is valid , 2. chk for pwd
		if (customer.getPassword().equals(password))
			return customer;
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

	@Override
	public void displayAllCustomers() {
		for (Customer c : customers)
			System.out.println(c);

	}

	@Override
	public void displayCustomersByDob(String dob) {
		System.out.println("Customers borh after - " + dob);
		// 1. parse date
		LocalDate date = parseDob(dob);
		// since search criteria - dob - not a PK - iterate
		for (Customer c : customers) {
			if (c.getDob().isAfter(date)) {
				System.out.println(c);
			}
		}

	}

	@Override
	public void upgradeSeniorCustomers() {
		System.out.println("Names of upgraded senior customers - ");
		for (Customer c : customers) {
			if (isSenior(c.getDob()) && c.getPlan() == ServicePlan.SILVER) {
				c.setPlan(ServicePlan.GOLD);
				System.out.println(c.getFirstName() + " " + c.getLastName());
			}
		}

	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) throws CMSException {
		// authenticate
		Customer customer = authenticate(email, oldPwd);
		// valid auth -> change pwd
		customer.setPassword(newPwd);
		return "Password updated";
	}

	@Override
	public String unsubscribeCustomer(String email) throws CMSException {
		Customer customer = new Customer(email);
		/*
		 * //findByEmail(email); //=> customer with email - exists
		 */
		if (customers.remove(customer))
			return "Removed customer details !!!!";
		throw new CMSException("Customer can't be un subscribed , Invalid Email !!!!");
	}

	@Override
	public void deleteCustomersByPlan(String plan) {
		// After deleting , display last names of the deleted
		// customers here.
		// 1. parse plan
		ServicePlan myPlan = parsePlan(plan);
		// 2. in case of valid plan - for -each n remove(o)
		System.out.println("Last names of the customers , deleted by plan " + plan);
//		for (Customer c : customers) {
//			if (c.getPlan() == myPlan) {
//				customers.remove(c);
//				System.out.println(c.getLastName());
//			}
//		}
		// 3. Attach Iterator
		Iterator<Customer> customerItr = customers.iterator();
		// cursor - before the 1st element
		while (customerItr.hasNext()) {
			Customer c = customerItr.next();
			if (c.getPlan() == myPlan) {
				customerItr.remove();
				System.out.println(c.getLastName());
			}
		}

	}

	private boolean isSenior(LocalDate dob) {
		if (Period.between(dob, LocalDate.now()).getYears() > 60)
			return true;
		return false;

	}

}
