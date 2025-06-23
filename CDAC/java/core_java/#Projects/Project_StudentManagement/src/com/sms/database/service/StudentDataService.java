package com.sms.database.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sms.core.Course;
import com.sms.core.Student;
import com.sms.core.UniqueStudentKey;
import com.sms.validator.Constant;
import com.sms.validator.exception.DuplicateStudentException;
import com.sms.validator.exception.InvalidPasswordException;
import com.sms.validator.exception.LoginFailedException;
import com.sms.validator.exception.NoStudentDataFound;

/**
 * This is a Singleton Class
 */
public class StudentDataService {
	private static final HashMap<UniqueStudentKey, Student> studentMap = new HashMap<>();
	private static final Set<String> uniqueEmailSet = new HashSet<>();

	/**
	 * Singleton behavior of this class
	 */
	private static StudentDataService instance;

	private StudentDataService() {
	}

	public static StudentDataService getInstance() {
		if (instance == null) {
			instance = new StudentDataService();
		}
		
		instance.dummyData();
		
		return instance;
	}

	//
	private void dummyData() {
		studentMap.put(new UniqueStudentKey("DAC-001", "aadarsh95@yahoo.co.in"), new Student("DAC-001", "Aadarsh", "Yadav", LocalDate.parse("1999-09-01"), "aadarsh95@yahoo.co.in", Course.DAC));
		studentMap.put(new UniqueStudentKey("DBDA-002", "anu333@gmail.com"), new Student("DBDA-002", "Anu", "Yadav", LocalDate.parse("1993-11-03"), "anu333@gmail.com", Course.DBDA));
		studentMap.put(new UniqueStudentKey("DITISS-003", "aatest@gmail.com"), new Student("DITISS-003", "Test", "Surname", LocalDate.parse("2000-06-26"), "aatest@gmail.com", Course.DITISS));
	}
	//

	/**
	 * 
	 * @param 
	 * @return int, No. of student took admission
	 */
	public int studentsSize(){
		return studentMap.size();
	}
	
	/**
	 * 
	 * @param prn
	 * @return
	 * @throws NoStudentDataFound
	 */
	public Stream<Student> getAllStudentDetail() {
//		Iterator<Student> itr = studentMap.values().iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		return studentMap.values().stream();
	}
	
	/**
	 * 
	 * @param prn
	 * @return
	 */
	public Student isStudentEnrolled(String prn) {
		List<Student> matchedStudent = studentMap.entrySet()
			.stream()
			.filter(keys -> keys.getKey().getPrnId().equals(prn))
			.map(entry -> entry.getValue())
			.collect(Collectors.toList());
		
		if(matchedStudent.isEmpty()) {
			return null;
		}
		return matchedStudent.get(0);
	}

	/**
	 * 
	 * @param prn
	 * @return
	 * @throws NoStudentDataFound
	 */
	public Student getStudentDetail(String prn) throws NoStudentDataFound {
		Student student = isStudentEnrolled(prn);
		
		if (student == null) {
			throw new NoStudentDataFound(Constant.NO_STUDENT);
		}
		return student;
	}

	/**
	 * 
	 * @param newStudent
	 * @return True if student is registered with unique PRN else False
	 */
	public boolean addNewStudent(Student newStudent) throws DuplicateStudentException {
		if(uniqueEmailSet.contains(newStudent.getEmail())) {
			throw new DuplicateStudentException(Constant.DUPLICATE_STUDENT);
		}
		
		UniqueStudentKey uniqueStudentKey = new UniqueStudentKey(newStudent.getPrnId(), newStudent.getEmail());
		
		Student previousStudent = studentMap.putIfAbsent(uniqueStudentKey, newStudent);
		if (previousStudent != null) {
			// if previousStudent != null,
			// this mean there is duplicate student with same PRN found
			throw new DuplicateStudentException(Constant.DUPLICATE_STUDENT);
		}
		
		uniqueEmailSet.add(newStudent.getEmail());
		return true;
	}

	public Student loginStudent(String email, String password) throws LoginFailedException {
		List<Student> matchedStudent = studentMap.entrySet()
			.stream()
			.filter(entry -> entry.getKey().getEmail().equals(email))
			.map(entry -> entry.getValue())
			.collect(Collectors.toList());
		
		if (matchedStudent.size() <= 0 || 
			matchedStudent.get(0).getPassword() == null || 
			matchedStudent.get(0).getPassword().equals(password) == false) {
			throw new LoginFailedException(Constant.LOGIN_FAILED);
		} else {
			return matchedStudent.get(0);
		}
	}

	public boolean changePassword(String email, String currentPassword, String newPassword) throws InvalidPasswordException {
		try {
			Student loggedInStudent = loginStudent(email, currentPassword);
			
			loggedInStudent.setPassword(newPassword);
			return true;
		} catch(LoginFailedException e) {
			throw new InvalidPasswordException(Constant.CHANGE_PASSWORD_FAILED);
		}
	}
}