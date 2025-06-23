//package com.sms.database.service;
//
//import java.util.HashMap;
//import com.sms.core.Student;
//
//public class StudentDataServiceImpl implements StudentDataService {
//	private static final HashMap<String, Student> studentMap = new HashMap<>();
//	
//	/**
//	 *
//	 */
//	public boolean addNewStudent(Student newStudent) {
//		Student previousStudent = studentMap.putIfAbsent(newStudent.getPrnId(), newStudent);
//		if(previousStudent == null) {
//			return true;
//		}
//		return false;
//	}
//}