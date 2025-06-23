package com.sms.core.service;

import java.time.LocalDate;

import com.sms.core.Student;
import com.sms.validator.exception.NoStudentDataFound;

public interface StudentService {
	boolean checkIfStudentIsValid(String prn);
	Student getStudentByPRN(String prn) throws NoStudentDataFound;
	public abstract boolean newAdmission(String firstName, String lastName, LocalDate dob, String email, int courseChoice);
	boolean registerStudentEmailPassword(Student student, String email, String password);
	Student loginStudent(String email, String password);
	boolean changePassword(String email, String currentPassword, String newPassword);
}