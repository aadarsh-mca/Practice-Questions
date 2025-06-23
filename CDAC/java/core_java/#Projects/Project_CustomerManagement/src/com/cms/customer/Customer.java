package com.cms.customer;

import com.cms.plans.ServicePlan;
import java.time.LocalDate;


/**
 * Customer Class Model
 * for storing customer data
 * 
 * @author Aadarsh
 */
public class Customer {
	
	private static int autoId = 1;
	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	private String password;
	private double registrationAmt;
	private ServicePlan plan;
	
	public Customer(String firstName, String lastName, LocalDate dob, 
			String email, String password, 
			double registrationAmt, ServicePlan plan
	) {
		this.id = autoId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.registrationAmt = registrationAmt;
		this.plan = plan;
	}
	
	@Override
	public String toString() {
		return "\n\tId : " + id + 
				"\n\tName : " + firstName + " " + lastName + 
				"\n\tDOB : " + dob + 
				"\n\tEmail : " + email + 
				"\n\tPlan : " + plan;
	}
	
	@Override
	public boolean equals(Object anotherCustomer) {
		if(anotherCustomer instanceof Customer) {
			return (((Customer)anotherCustomer).email.equals(this.email));
		}
		return false;
	}

}
