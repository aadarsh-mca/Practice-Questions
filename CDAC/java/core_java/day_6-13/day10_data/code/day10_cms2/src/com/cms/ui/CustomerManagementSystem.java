package com.cms.ui;

import java.util.Scanner;

import com.cms.service.CMSOperations;
import com.cms.service.CMSOperationsImpl;

public class CustomerManagementSystem {
	/*
	 * Sample Data 
	 * a1 b1 a1@gmail.com 12345 2000 1990-10-20 gold
		a2 b2 a2@gmail.com 22345 1000 1999-05-22 silver
		a3 b3 a3@gmail.com 13345 5000 1993-11-2 diamond
		a4 b4 a4@gmail.com 15345 2000 1994-01-20 gold
	 */

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			// 1 create service layer - service imple class instance
			CMSOperations ops = new CMSOperationsImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1 . Sign Up Customer \n" + "2. Sign In \n 0. Exit");
				System.out.println("Enter option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter customer details - firstName, lastName,\r\n"
								+ "						email, password, regAmount, date, plan");
						System.out.println(ops.registerCustomer(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next()));
						break;
					case 2: System.out.println("Enter email n password");
					    System.out.println(ops.authenticate(sc.next(),sc.next()));
						break;

					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Pls retry ...");
					 sc.nextLine();
					 /* In case of invalid i/p - Scanner throws - InputMismatchException
					  * BUT doesn't remove the token from its buffer
					  * -causing the same exception --> indefinite loop !
					  * Soln - remove the scanner buffer contents  - till end of line
					  * - sc.nextLine() - clrs the buffer till new line
					  * 
					  * 
					  */
				}
			}

		} // JVM - sc.close()

	}

}
