package com.cms.validations;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;

public class CMSValidations {
//add public static method to parse and validate plan it's reg amount
	public static ServicePlan parsePlan(String plan) throws IllegalArgumentException {
		// 1. parsing (string -> enum, valueOf)
		return ServicePlan.valueOf(plan.toUpperCase());

	}

	public static void validatePlan(ServicePlan myPlan, double amount) throws CMSException {
		// To check plan n reg amount
		if (myPlan.getPlanCost() != amount)
			throw new CMSException("Reg amount doesn't match " + "with the chosen plan !!!!");

	}

	// add validation rule for email
	public static void validateEmail(String email, Map<String, Customer> customers) throws CMSException {
		// check for well formed email
		String regEx = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if (!email.matches(regEx))
			throw new CMSException("Invalid email format !!!!!!!!!!!!");
		// => well formed email , chk for dup (Note the simplification compared 

		if (customers.containsKey(email))
			throw new CMSException("Dup email id !!!!!!!!");
	}

	// add a method for parsing the date (string -> localdate)
	public static LocalDate parseDob(String date) {
		return LocalDate.parse(date);
	}
}
