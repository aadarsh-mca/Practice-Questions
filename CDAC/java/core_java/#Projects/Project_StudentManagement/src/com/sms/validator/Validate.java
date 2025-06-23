package com.sms.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.sms.core.Course;
import com.sms.validator.exception.InvalidDobException;
import com.sms.validator.exception.InvalidEmailException;
import com.sms.validator.exception.InvalidPasswordException;
import com.sms.validator.exception.NoCourseAvailableException;

public class Validate {
	
	public static LocalDate dob(String dobAsString) throws InvalidDobException {
		LocalDate dob = null;
		
		try {
			dob = LocalDate.parse(dobAsString);	
		} catch (DateTimeParseException e) {
			throw new InvalidDobException(Constant.INVALID_DOB);
		}
		
		return dob;
	}
	
	public static boolean student(LocalDate dob, int courseChoice) throws InvalidDobException, NoCourseAvailableException {
		if(dob.isBefore(LocalDate.parse("1985-01-01"))) {
			throw new InvalidDobException(Constant.AGE_BEFORE_1985);
		}
		
//		if(courseChoice < 1 || courseChoice > Course.getSize()) {
//			throw new NoCourseAvailableException(ErrorConstant.NO_COURSE_AVAILABLE);
//		}
		Course.of(courseChoice);
		
		return true;
	}
	
	public static boolean email(String email) throws InvalidEmailException {
		String validEmailPattern = "^[a-z]+[a-z0-9\\._]*@(gmail|yahoo|microsoft)\\.(com|in|co.in|org)";
		
		if(email.toLowerCase().matches(validEmailPattern)) {
			return true;			
		}
		throw new InvalidEmailException(Constant.INVALID_EMAIL);
	}
	
	public static boolean password(String password) throws InvalidPasswordException {
		String validPasswordPattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\._!@#$])[a-zA-Z0-9\\._!@#$]{8,16}$";
		
		if(password.matches(validPasswordPattern)) {
			return true;			
		}
		throw new InvalidPasswordException(Constant.INVALID_PASSWORD);
	}
	
}