package com.cms.ui;

import java.util.Scanner;

import com.cms.core.Customer;
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
				System.out.println("Options 1 . Sign Up Customer \n" 
			+ "2. Sign In \n "
			+ "3. Display all customers \n "
			+ "4. Display all customers born after specified date \n "
			+ "5. Upgrade all senior customers of Silver Plan  to Gold \n "
			+ "6. Change password \n "
			+ "7. Un subscribe Customer by email \n "
			+ "8. Delete all the customers by specified plan  \n "
			+ "9. Sort customers as per email  \n "
			+ "10. Sort customers as per dob  \n "
			+ "11. Sort customers as per dob(Asc) n reg amount(desc)  \n "
			+ "12. Sort customers as per last names using ano inner class  \n "
			
			+ "0. Exit");
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
					    Customer authenticatedCust = ops.authenticate(sc.next(),sc.next());
					    System.out.println("Login Successful , Hello "+authenticatedCust.getFirstName()
					    +" "+authenticatedCust.getLastName());
						break;
					case 3 :
						ops.displayAllCustomers();
						break;
					case 4 :
						System.out.println("Enter Date - yr-mon-day");
						ops.displayCustomersByDob(sc.next());
						break;
					case 5 :
						ops.upgradeSeniorCustomers();
						break;
					case 6 :
						System.out.println("Enter email , password , new password");
						ops.changePassword(sc.next(),sc.next(),sc.next());
						break;
						
					case 7 :
						System.out.println("Enter email to un subscribe");
						System.out.println(ops.unsubscribeCustomer(sc.next()));
						break;
						
					case 8 :
						System.out.println("Enter plan , to delete its customers");
						ops.deleteCustomersByPlan(sc.next());
						break;
					case 9 :
						ops.sortCustomersByEmail();
						break;
					case 10 :
						ops.sortCustomersByDoB();
						break;
					case 11 :
						ops.sortCustomersByDoBAndRegAmount();
						break;
					case 12 :
						ops.sortCustomersByLastNames();
						break;
				
				
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
				//	System.out.println(e);
					e.printStackTrace();
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
		catch (Exception e) {
			System.out.println("end of app -"+e);
		}

	}

}
