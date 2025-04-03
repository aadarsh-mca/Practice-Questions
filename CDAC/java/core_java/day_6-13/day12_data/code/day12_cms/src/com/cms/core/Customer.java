package com.cms.core;
/*
 * 1.Customer should be assigned system generated 
 * (auto increment) customer id : int
Store - first name, last name email(string),
password(string),registrationAmount(double),
dob(LocalDate),plan(ServicePlan : enum)
Unique ID - email

 */

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	// customer id generator
	public static int idGenerator;

	// parameterized ctor to init state of the Customer
	public Customer(String firstName, String lastName, 
			String email, String password, double regAmount,
			LocalDate dob,
			ServicePlan plan) {
		//generating customer id - in auto increment manner
		this.customerId=++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}
	//add overloaded ctor to init Customer with PK (UID) - email
	public Customer(String email) {
		this.email=email;
	}

	// override toString - to return customer details
	@Override
	public String toString() {
		return "Customer customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan;
	}

	// override equals for customer equality testing
	// UID - email
	@Override
	public boolean equals(Object o) {
		System.out.println("in customer equals");
		if (o instanceof Customer) {
			Customer customer = (Customer) o;
			return this.email.equals(customer.email);
		}
		return false;
	}
	@Override
	public int compareTo(Customer anotherCust)
	{
		System.out.println("in compareTo");
		//sorting criteria - email , 
		/*
		 * rets <0 if this.email < anotherCust.email , 0 if equal , o.w > 0
		 */
		return this.email.compareTo(anotherCust.email);
	//	return this.dob.compareTo(anotherCust.dob);
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}
	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
