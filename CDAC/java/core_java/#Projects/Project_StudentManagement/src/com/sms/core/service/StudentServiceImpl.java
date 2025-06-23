package com.sms.core.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.sms.core.Course;
import com.sms.core.Student;
import com.sms.database.service.StudentDataService;
import com.sms.validator.Constant;
import com.sms.validator.Validate;
import com.sms.validator.exception.DuplicateStudentException;
import com.sms.validator.exception.InvalidEmailException;
import com.sms.validator.exception.InvalidPasswordException;
import com.sms.validator.exception.LoginFailedException;
import com.sms.validator.exception.NoStudentDataFound;

public class StudentServiceImpl implements StudentService {
	
	private StudentDataService studentDataService;
	
	public StudentServiceImpl() {
		studentDataService = StudentDataService.getInstance();
	}
	
	
	/**
	 * 
	 * @param prn
	 * @return
	 */
	public boolean checkIfStudentIsValid(String prn) {
		return studentDataService.isStudentEnrolled(prn) != null;
	}
	
	
	/**
	 * 
	 * @param String PRN
	 * @return Student
	 * @throws NoStudentDataFound
	 */
	public Student getStudentByPRN(String prn) throws NoStudentDataFound {
		return studentDataService.getStudentDetail(prn);
	}
	
	
	/**
	 * 
	 * @param String firstName, String lastName, LocalDate dob, int courseChoice
	 * @return boolean
	 */
	public boolean newAdmission(String firstName, String lastName, LocalDate dob, String email, int courseChoice) {
		boolean admissionConfirmation = false;
		Course course = null;
		
		try {
			Validate.student(dob, courseChoice);
			Validate.email(email);
			course = Course.of(courseChoice);
			
			String prnId = Student.generatePRNId(course);
			Student newStudent = new Student(prnId, firstName, lastName, dob, email, course);
			
			admissionConfirmation = studentDataService.addNewStudent(newStudent);
		} catch(DuplicateStudentException e) {
			System.out.println(e.getMessage());
			
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return admissionConfirmation;
	}
	
	/**
	 * 
	 * @param Student student, String email, String password
	 * @return boolean, True if user email/password get registered, else False
	 */
	public boolean registerStudentEmailPassword(Student student, String email, String password) {
		try {
			Validate.email(email);
			Validate.password(password);
			
			if(student.getEmail().equals(email)) {
				student.setPassword(password);				
				return true;
			}

			System.out.println(Constant.REGISTER_FAILED);
		} catch(InvalidEmailException e) {
			System.out.println(e.getMessage());
		} catch(InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param String email, String password
	 * @return boolean, True if login is successful, else False
	 */
	public Student loginStudent(String email, String password) {
		try {
			return studentDataService.loginStudent(email, password);
		} catch(LoginFailedException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param String email, String password
	 * @return boolean, True if login is successful, else False
	 */
	public boolean changePassword(String email, String currentPassword, String newPassword) {
		try {
			return studentDataService.changePassword(email, currentPassword, newPassword);
		} catch(InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public void displayAllStudents() {
		if(studentDataService.studentsSize() == 0) {
			System.out.println("\t===== [ No Student Found ] =====");
			return;
		}
		
		studentDataService.getAllStudentDetail()
			.forEach(student -> System.out.println(student));		
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public void displayAllStudentsSortedByEmail() {
		if(studentDataService.studentsSize() == 0) {
			System.out.println("\t===== [ No Student Found ] =====");
			return;
		}
		
		List<Student> allStudents = studentDataService.getAllStudentDetail()
				.collect(Collectors.toList());
		
		Collections.sort(allStudents);
		
		allStudents.stream()
			.forEach(student -> System.out.println(student));
	}

	/**
	 * 
	 * @param 
	 * @return 
	 */
	public void displayAllStudentsSortedByDob() {
		if(studentDataService.studentsSize() == 0) {
			System.out.println("\t===== [ No Student Found ] =====");
			return;
		}
		
		studentDataService.getAllStudentDetail()
			.sorted((s1, s2) -> s1.getDob().compareTo(s2.getDob()))
			.forEach(System.out::println);
	}
	
	
	
	
	
}