package com.sms.core;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
	private String prnId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Course course;
	// private boolean admissionConfirmation;
	private String email;
	private String password;
	
	private static int autoId = 1;
	public static String generatePRNId(Course course) {
		return course.toString() + "_" + autoId++;
	}
	
	public Student(String prnId, String firstName, String lastName, LocalDate dob, String email, Course course) {
		this.prnId = prnId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.course = course;
	}
	
	public Student(String prnId, String firstName, String lastName, LocalDate dob, Course course, String email, String password) {
		this.prnId = prnId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.course = course;
		this.email = email;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "\n\tPRN Id :: " + prnId + 
				"\n\tName :: " + firstName + " " + lastName + 
				"\n\tDate-of-Birth :: " + dob + 
				"\n\tCourse opted :: " + course + 
				"\n\tContact Email :: " + email;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student) {
			return this.prnId.equals(((Student)o).prnId);
		}
		return false;
	}
	
	@Override
	public int compareTo(Student aStud) {
		return this.email.compareTo(aStud.email);
	}
	
	public String getPrnId() {
		return prnId;
	}

	public void setPrnId(String prnId) {
		this.prnId = prnId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}