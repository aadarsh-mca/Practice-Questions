package com.sms.runApp;

import java.util.Scanner;
import java.time.LocalDate;
import com.sms.core.*;
import com.sms.core.service.StudentServiceImpl;
import com.sms.validator.Constant;
import com.sms.validator.Validate;
import com.sms.validator.exception.InvalidDobException;
import com.sms.validator.exception.InvalidPasswordException;

public class RunApp {
	private static Scanner scan = new Scanner(System.in);
	private static StudentServiceImpl studentService = new StudentServiceImpl();
	
	public static void main(String[] args) throws InvalidPasswordException {
		boolean toExit = false;
		
		while(toExit == false) {
			printOption();
			int optionSelected = scan.nextInt();
			
			switch(optionSelected) {
			case 1:
				newAdmission();
				break;
			case 2:
				registerStudent();
				break;
			case 3:
				loginStudent();
				break;
			case 4:
				changePassword();
				break;
			case 5:
				displayStudentUserAction();
				break;
			case 100 :
				toExit = true;
				System.out.println("========== [ Application terminated ] ==========");
				break;
			default:
				System.out.println("\n\t====== [ Invalid option selected !!! ] ======");
			}
			
		}
		
		scan.close();
	}

	private static void printOption() {
		System.out.println("\n\n========== [ Select from the following options ] ==========");
		System.out.println("Press '1' to New Admission");
		System.out.println("Press '2' to Register as Student");
		System.out.println("Press '3' to Login as Student");
		System.out.println("Press '4' to Change Password");
		System.out.println("Press '5' to Display All Student Data");
		System.out.println("Press '100' to Exit");
	}
	
	private static void displayStudentUserAction() {
		System.out.println("\n========== [ Select display option from the following ] ==========");
		System.out.println("\tPress '1' to Without Sorting");
		System.out.println("\tPress '2' to Sorted by Email");
		System.out.println("\tPress '3' to Sorted by Date-of-Birth");
		
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1:
			displayAllStudents();
			break;
		case 2:
			displayAllStudentsSortedByEmail();
			break;
		case 3:
			displayAllStudentsSortedByDob();
			break;
		default:
			System.out.println("\n========== [ Invalid option selected !!! ] ==========");
		}
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private static void newAdmission() {
		System.out.println("\n========== [ New Admission Portal ] ==========");
		
		String firstName;
		String lastName;
		LocalDate dob = null;
		
		System.out.println("\nEnter Student details as follows :: ");
		System.out.print("\tStudent First Name : ");
		firstName = scan.next();
		System.out.print("\tStudent Last Name : ");
		lastName = scan.next();
		
		while(dob == null) {
			System.out.print("\tStudent Date-of-Birth (yyyy-mm-dd) : ");
			try {
				dob = Validate.dob(scan.next());
			} catch (InvalidDobException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.print("\tEnter email id :: ");
		String email = scan.next().toLowerCase();
		
		System.out.println("\tSelect Course you want to opt :: ");
		System.out.println("\tPress '1' for DAC\t\tPress '2' for DBDA");
		System.out.println("\tPress '3' for DITISS");
		int courseChoice = scan.nextInt();
		
		if(studentService.newAdmission(firstName, lastName, dob, email, courseChoice)) {
			System.out.println("========== [ Successfully Enrolled !!! ] ==========");
		}
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private static void registerStudent() {
		System.out.println("\n========== [ Registration portal for enrolled student only ] ==========");
		
		System.out.print("\tPlease Enter your PRN to create Login/Password :: ");
		String prn = scan.next().toUpperCase();
		
		if(studentService.checkIfStudentIsValid(prn)) {
			Student student = studentService.getStudentByPRN(prn);
			
			System.out.print("\tEnter your email :: ");
			String email = scan.next().toLowerCase();
			System.out.print("\tCreate a password :: ");
			String password = scan.next();
			
			if(studentService.registerStudentEmailPassword(student, email, password)) {
				System.out.println("\n\t===== [ Registration Successful ] =====");
			}
		} else {
			System.out.println("\n\tYou are not enrolled in any course, so you cannot create Login !!!");
		}
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private static void loginStudent() {
		System.out.println("\n========== [ Login portal for enrolled student only ] ==========");	
		
		System.out.print("\tEnter your Login Email ID :: ");
		String email = scan.next().toLowerCase();
		System.out.print("\tEnter you Login Password :: ");
		String password = scan.next();
		
		if(studentService.loginStudent(email, password) != null) {
			System.out.println(Constant.LOGIN_SUCCESS);
		}
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private static void changePassword() {
		System.out.println("\n========== [ Change Password Request ] ==========");	
	
		System.out.print("\tEnter your Email ID :: ");
		String email = scan.next();
		System.out.print("\tEnter your Current Password :: ");
		String currentPassword = scan.next();
		System.out.print("\tEnter your New Password :: ");
		String newPassword = scan.next();
		
		if(studentService.changePassword(email, currentPassword, newPassword)) {
			System.out.println(Constant.CHANGE_PASSWORD_SUCCESS);
		}
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private static void displayAllStudents() {
		System.out.println("\n========== [ Data of all Students ] ==========");	
		
		studentService.displayAllStudents();
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private static void displayAllStudentsSortedByEmail() {
		System.out.println("\n========== [ All Students Data Sorted by Email ] ==========");	
		
		studentService.displayAllStudentsSortedByEmail();
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private static void displayAllStudentsSortedByDob() {
		System.out.println("\n========== [ All Students Data Sorted by Date-of-Birth ] ==========");
		
		studentService.displayAllStudentsSortedByDob();
	}
}