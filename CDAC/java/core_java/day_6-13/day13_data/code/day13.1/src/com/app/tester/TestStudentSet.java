package com.app.tester;

import java.util.HashSet;

import com.app.core.Student;

public class TestStudentSet {

	public static void main(String[] args) {
		Student s1 = new Student("dac-001", "a1 b1", 80);
		Student s2 = new Student("dac-002", "a2 b2", 78);
		Student s3 = new Student("dac-001", "a1 b1", 80);
		// create empty HashSet n add these students
		HashSet<Student> students = new HashSet<>();
		System.out.println("Added " + students.add(s1));//t
		System.out.println("Added " + students.add(s2));//t
		System.out.println("Added " + students.add(s3));//f
		System.out.println("size " + students.size());//2
		for (Student s : students)
			System.out.println(s);//no dups
		System.out.println(s1.equals(s2));//f
		System.out.println(s1.equals(s3));//t
		System.out.println(s1.hashCode()+" "+s2.hashCode()
		+" "+s3.hashCode());

	}

}
