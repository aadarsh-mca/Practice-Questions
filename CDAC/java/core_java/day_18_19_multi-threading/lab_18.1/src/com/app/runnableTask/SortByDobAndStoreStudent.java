package com.app.runnableTask;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Student;

public class SortByDobAndStoreStudent implements Runnable {

	Map<String, Student> studentMap;
	String fileName;

	public SortByDobAndStoreStudent(Map<String, Student> studentMap, String fileName) {
		this.studentMap = studentMap;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println("Thread :: " + Thread.currentThread().getName() + " -- Started !!!");

		try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName))) {
			studentMap.values()
			.stream()
			.sorted((s1, s2) -> s1.getDob().compareTo(s2.getDob()))
			.forEach(stud -> {
				
				out.write(stud.toString() + "\n");
			});
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Thread :: " + Thread.currentThread().getName() + " -- Ended !!!");
	}

}
