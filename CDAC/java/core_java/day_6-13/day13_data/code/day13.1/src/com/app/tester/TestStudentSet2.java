package com.app.tester;

import java.util.HashSet;

import com.app.core.Student;

public class TestStudentSet2 {

	public static void main(String[] args) {
		Student s1 = new Student("dac-001", "a1 b1", 80);
		Student s2 = new Student("dac-002", "a2 b2", 78);
		Student s3 = new Student("dac-001", "a1 b1", 81);
		Student s4 = new Student("dac-004", "a4 b1", 89);
		Student s5 = new Student("dac-006", "a5 b2", 76);
		Student s6 = new Student("dac-005", "a6 b1", 80);
		// create empty HashSet n add these students
		HashSet<Student> students = new HashSet<>();
		System.out.println("Added " + students.add(s1));//t
		System.out.println("Added " + students.add(s2));//t
		System.out.println("Added " + students.add(s3));//f
		System.out.println("Added " + students.add(s4));//t
		System.out.println("Added " + students.add(s5));//t
		System.out.println("Added " + students.add(s6));//t
		System.out.println("size " + students.size());//5
		for (Student s : students)
			System.out.println(s);//no dups
		System.out.println(s1.hashCode()+" "+s2.hashCode()+" "+s3.hashCode());
		
	}

}
