package com.app.core;

import java.util.HashMap;
import java.util.Scanner;

public class TestStudentMap {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create empty HashMap to store student details - init capa =128
			HashMap<String, Student> students = new HashMap<>(128);
			System.out.println(students);// {}
			// populate the map
			System.out.println("rets " 
			+ students.put("dac-009", new Student("dac-009", "Rama", 80)));
			System.out.println("rets " 
			+ students.put("dac-009", new Student("dac-009", "Mihir", 70)));
			System.out.println("rets " 
			+ students.put("dac-0031", new Student("dac-0031", "Kiran", 85)));
			System.out.println("rets " 
			+ students.put("dac-0015", new Student("dac-0015", "Souma", 76)));
			System.out.println("rets " 
			+ students.put("dac-0024", new Student("dac-0024", "Samay", 72)));
			System.out.println("rets "
			+ students.putIfAbsent("dac-009", new Student("dac-009", "Riya", 71)));
		//	System.out.println(students);
			//display student details - on separate lines
			System.out.println("All students - ");
			for(Student s : students.values())// Collection<Student>
				System.out.println(s);

		}

	}

}
