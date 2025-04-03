package com.app.tester;

import java.util.HashSet;

import com.app.core.Student;

public class TestStudentSet3 {

	public static void main(String[] args) {
		Student s1 = new Student("dac-001", "a1 b1", 80);
		Student s2 = new Student("dac-002", "a2 b2", 78);
		Student s3 = new Student("dac-001", "a1 b1", 81);
		/** 
		 * 
		 * BBBB AaBB AaAa BBAa 
		 * - different strings BUT having the same hash code
		 * Extremely rare - Great for understanding the working
		 */
		Student s4 = new Student("BBBB", "a4 b1", 89);
		Student s5 = new Student("AaBB", "a5 b2", 76);
		Student s6 = new Student("AaAa", "a6 b1", 80);
		Student s7 = new Student("BBAa", "a6 b1", 80);
		// create empty HashSet n add these students
		HashSet<Student> students = new HashSet<>();
		System.out.println("Added " + students.add(s1)); // 1 0 
		System.out.println("Added " + students.add(s2)); // 1 0
		System.out.println("Added " + students.add(s3)); // 1 1
		System.out.println("Added " + students.add(s4)); // 1 0
		System.out.println("Added " + students.add(s5)); // 1 1
		System.out.println("Added " + students.add(s6)); // 1 2
		System.out.println("Added " + students.add(s7)); // 1 3
		System.out.println("size " + students.size()); // 6
		for (Student s : students)
			System.out.println(s);//no dups
		System.out.println(s4.hashCode()+" "+s5.hashCode()+" "+s6.hashCode());
		
	}

}
