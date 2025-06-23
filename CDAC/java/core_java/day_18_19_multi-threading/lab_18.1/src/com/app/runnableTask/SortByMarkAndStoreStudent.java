package com.app.runnableTask;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Student;

public class SortByMarkAndStoreStudent implements Runnable {

	Map<String, Student> studentMap;
	String fileName;

	public SortByMarkAndStoreStudent(Map<String, Student> studentMap, String fileName) {
		this.studentMap = studentMap;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println("Thread :: " + Thread.currentThread().getName() + " -- Started !!!");

		try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName))) {
			studentMap.values()
			.stream()
			.sorted((s1, s2) -> {
				int subSortResult = s1.getSubject().toString().compareTo(s2.getSubject().toString());
				if (subSortResult == 0) {
					return Double.compare(s2.getGpa(), s1.getGpa());
				}
				return subSortResult;
			}).forEach(stud -> {

				out.write(stud.toString() + "\n");
			});
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Thread :: " + Thread.currentThread().getName() + " -- Ended !!!");
	}

}
