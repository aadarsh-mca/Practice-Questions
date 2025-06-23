package com.cms.run;

import java.time.LocalDate;
import java.util.Scanner;
import com.cms.customer.Customer;
import com.cms.plans.ServicePlan;
import com.cms.validator.Validate;

public class RunApp {
	public static void main(String[] args) {
		boolean toExit = false;
		
		try (Scanner sc = new Scanner(System.in)) {
			while(toExit == false) {
				printOptions();
				
				switch(sc.next()) {
				case "1":
					registerNewCustomer();
					break;
				case "2":
					login();
					break;
				case "3":
					changePassword();
					break;
				case "4":
					unsubscribeCustomer();
					break;
				case "5":
					displayAllCustomer();
					break;
					
				case "#": 
					toExit = true;
					break;
				default:
					System.out.println("Invalid option selected !!!");
				}
			}
		}

//		Validate.email("aadarshyadav95@gmail.com");
	}
	
	private static void printOptions() {
		System.out.println("\nPress   '1' : Register New Customer");
		System.out.println("Press   '2' : Login");
		System.out.println("Press   '3' : Change Password");
		System.out.println("Press   '4' : Unsubscribe Customer");
		System.out.println("Press   '5' : Display All Customer");
		System.out.println("Press   '#' : Exit");
	}

	private static void registerNewCustomer() {
		String firstName;
		String lastName;
		LocalDate dob;
		String email;
		String password;
		double registrationAmt;
		ServicePlan plan;
		
		System.out.println("\n\tEnter First Name : ");
		
		
		
//		Customer newCustomer = new Customer(firstName, lastName, dob, email, password, registrationAmt, plan);
	}
	private static void login() {
		System.out.println("Login called >>>>>>");
	}
	private static void changePassword() {
		System.out.println("Change Password called >>>>>>");
		
	}
	private static void unsubscribeCustomer() {
		System.out.println("Unsubscribe Customer called >>>>>>");
		
	}
	private static void displayAllCustomer() {
		System.out.println("Display All Customer called >>>>>>");		
	}

}