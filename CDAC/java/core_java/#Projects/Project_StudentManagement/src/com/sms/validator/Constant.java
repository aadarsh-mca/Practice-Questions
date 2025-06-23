package com.sms.validator;

public class Constant {
	public static final String NO_COURSE_AVAILABLE = "\nInvalid course opted... No Such Course Available !!!\n";
	public static final String INVALID_DOB = "\nInvalid DOB format... Please enter a valid Date-of-Birth !!!\n";
	public static final String AGE_BEFORE_1985 = "\nYour Date-of-Birth must be after '1 January 1985' to take admission in any course !!!\n";
	
	public static final String DUPLICATE_STUDENT = "\nStudent already exists with the given PRN / Email ID !!!" + 
													"\n\tYou must have unique email ID...\n";
	public static final String NO_STUDENT = "\nNo Student found with the given PRN details !!!\n";
	
	public static final String INVALID_EMAIL = "\nInvalid email... Only (gmail | yahoo | microsoft) & (com | in | co.in | org) extension is Valid !!!\n";
	public static final String INVALID_PASSWORD = "\nInvalid password !!!" + 
													"\nPassword must contain :: " + 
													"\n\t1 Uppercase Character" + 
													"\n\t1 Lowercase Character" + 
													"\n\t1 Number and" + 
													"\n\t1 Special symbol (! @ # $ _ .)\n";
	
	public static final String REGISTER_FAILED = "\nRegistration failed due to Email ID mismatch !!!\n";
	
	public static final String LOGIN_FAILED = "\nLogin failed !!! No student with given email/password matched...\n";
	public static final String LOGIN_SUCCESS = "\n========== [ Login Successfull ] ==========\n";
	
	public static final String CHANGE_PASSWORD_SUCCESS = "\n========== [ Password Changed Successfully ] ==========\n";
	public static final String CHANGE_PASSWORD_FAILED = "\nEmail ID / Password not matched...\n";
}