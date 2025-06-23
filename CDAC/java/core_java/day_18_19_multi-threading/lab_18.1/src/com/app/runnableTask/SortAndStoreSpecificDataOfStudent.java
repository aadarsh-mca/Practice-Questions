package com.app.runnableTask;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Student;

public class SortAndStoreSpecificDataOfStudent implements Runnable {

	Map<String, Student> studentMap;
	String cityName;
	String fileName;
	
	public SortAndStoreSpecificDataOfStudent(Map<String, Student> studentMap, String cityName, String fileName) {
		this.studentMap = studentMap;
		this.cityName = cityName;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		System.out.println("Thread :: " + Thread.currentThread().getName() + " -- Started !!!");

		try(PrintWriter out = new PrintWriter(new FileOutputStream(fileName))) {
			studentMap.values()
			.stream()
			.filter(stud -> stud.getAddress().getCity().equals(cityName))
			.sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
			.forEach(stud -> {
				
				out.write("Roll No :: " + stud.getRollNo() + 
						", Name :: " + stud.getName() +
						", GPA :: " + stud.getGpa() + 
						", City :: " + stud.getAddress().getCity() + 
						"\n");
			});
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Thread :: " + Thread.currentThread().getName() + " -- Ended !!!");		
	}
	
}
