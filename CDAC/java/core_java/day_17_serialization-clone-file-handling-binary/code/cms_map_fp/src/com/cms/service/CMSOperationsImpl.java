package com.cms.service;

import static com.cms.validations.CMSValidations.parseDob;
import static com.cms.validations.CMSValidations.parsePlan;
import static com.cms.validations.CMSValidations.validateEmail;
import static com.cms.validations.CMSValidations.validatePlan;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;
import com.cms.io.IOUtils;

public class CMSOperationsImpl implements CMSOperations {
	//
	public static int idGenerator;
	
	// state
	private Map<String, Customer> customers;

	// add a ctor
	public CMSOperationsImpl(String fileName) throws CMSException {
//		this.customers = new HashMap<>();
//		registerCustomer("a2", "b2", "a2@gmail.com", "16345", 1000, "1994-10-20", "silver");
//		registerCustomer("a3", "b3", "a3@gmail.com", "11345", 5000, "1994-10-20", "diamond");
//		registerCustomer("a5", "b5", "a5@gmail.com", "92345", 2000, "1996-02-23", "gold");
//		registerCustomer("a1", "b1", "a1@gmail.com", "12345", 2000, "1994-10-20", "gold");
//		registerCustomer("a4", "b4", "a4@gmail.com", "62345", 2000, "1994-10-20", "gold");
//		registerCustomer("a6", "b6", "a6@gmail.com", "65345", 1000, "1995-10-20", "silver");
//		registerCustomer("a7", "b7", "a7@gmail.com", "35345", 10000, "1991-10-20", "platinum");
		
		/**
		 * a2 b2 a2@gmail.com 16345 1000 1994-10-20 silver
		 * a3 b3 a3@gmail.com 11345 5000 1994-10-20 diamond 
		 * a5 b5 a5@gmail.com 92345 2000 1996-02-23 gold 
		 * a1 b1 a1@gmail.com 12345 2000 1994-10-20 gold 
		 * a4 b4 a4@gmail.com 62345 2000 1994-10-20 gold 
		 * a6 b6 a6@gmail.com 65345 1000 1995-10-20 silver 
		 * a7 b7 a7@gmail.com 35345 10000 1991-10-20 platinum
		 */

		customers = IOUtils.restoreCustomer(fileName);
		idGenerator = customers.size();
	}
	
	public void storeAllCustomer(String fileName) throws IOException {
		IOUtils.storeCustomers(customers, fileName);
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
		Customer c = new Customer(++idGenerator, firstName, lastName, email, password, regAmount, date, myPlan);
		customers.put(c.getEmail(), c);
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
		Customer customer = customers.get(email);
		if (customer == null)
			throw new CMSException("Auth Failure , Invalid Email!!!!!!!!");
		return customer;
	}

	@Override
	public void displayAllCustomers() {
		customers.forEach((em, cust) -> System.out.println(cust));

	}

	@Override
	public void displayCustomersByDob(String dob) {
		System.out.println("Customers born after - " + dob);
		// 1. parse date
		LocalDate date = parseDob(dob);
		// since search criteria - dob - not a PK - iterate
		customers.values()
			.stream()
			.filter(c -> c.getDob().isAfter(date))
			.forEach(c -> System.out.println(c));

	}

	@Override
	public void upgradeSeniorCustomers() {
		System.out.println("Names of upgraded senior customers - ");
		customers.values()
			.stream()
			.filter(c -> isSenior(c.getDob()))
			.filter(c -> c.getPlan() == ServicePlan.SILVER)
//			.peek() // similar to forEach but intermediate operation
			.forEach(c -> {
				c.setPlan(ServicePlan.GOLD);
				System.out.println(c.getFirstName() + " " + c.getLastName());
			});

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
		Customer customer = customers.remove(email);
		if (customer != null)
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

//		Iterator<Customer> customerItr = customers.iterator();
//		// cursor - before the 1st element
//		while (customerItr.hasNext()) {
//			Customer c = customerItr.next();
//			if (c.getPlan() == myPlan) {
//				customerItr.remove();
//				System.out.println(c.getLastName());
//			}
//		}
		customers.values().removeIf(c -> {
			if (c.getPlan() == myPlan) {
				System.out.println(c.getFirstName());
				return true;
			}
			return false;
		});

	}

	@Override
	public void sortCustomersByEmail() {
		TreeMap<String, Customer> sortedCustomers = new TreeMap<>(customers);
		System.out.println("Sorted customers details by email - ");
		sortedCustomers.forEach((k, v) -> System.out.println(v));

	}

	@Override
	public void sortCustomersByDoB() {
		System.out.println("Sorted customers details by DoB");
		customers.values().stream()
		.sorted((c1, c2) -> c1.getDob().compareTo(c2.getDob()))
				.forEach(c -> System.out.println(c));

	}

	@Override
	public void sortCustomersByDoBAndRegAmount() {
		System.out.println("Sorted customers details by DoB n reg amount ");
		Comparator<Customer> comp=(c1,c2) -> { 
			int ret=c1.getDob().compareTo(c2.getDob());
			if(ret == 0)
			{
				return ((Double)c1.getRegAmount()).compareTo(c2.getRegAmount());
			}
			return ret;
		};
		customers.values()
		.stream()
		.sorted(comp)
		.forEach(c -> System.out.println(c));
	}

	@Override
	public void sortCustomersByLastNames() {
		System.out.println("Sorted customers details by last name");
		customers.values().stream()
		.sorted((c1, c2) -> c1.getLastName().compareTo(c2.getLastName()))
				.forEach(c -> System.out.println(c));

	}

	private boolean isSenior(LocalDate dob) {
		if (Period.between(dob, LocalDate.now()).getYears() > 60)
			return true;
		return false;

	}

}
