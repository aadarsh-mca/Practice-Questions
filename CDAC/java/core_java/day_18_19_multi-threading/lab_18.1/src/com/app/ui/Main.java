package com.app.ui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.runnableTask.SortAndStoreSpecificDataOfStudent;
import com.app.runnableTask.SortByDobAndStoreStudent;
import com.app.runnableTask.SortByMarkAndStoreStudent;
import com.app.utils.StudentCollectionUtils;

public class Main {

	public static void main(String[] args) {
		Map<String, Student> studentMap = StudentCollectionUtils.populateMap(StudentCollectionUtils.populateList());
	
		try(Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter the name of 1st File :: ");
			String file1 = scan.next();
			
			System.out.print("Enter the name of 2nd File :: ");
			String file2 = scan.next();
			
			System.out.print("Enter the name of 3rd File :: ");
			String file3 = scan.next();
			System.out.print("Enter the city name whose data you want to store :: ");
			String cityName = scan.next();
		
			Thread t1 = new Thread(new SortByDobAndStoreStudent(studentMap, file1), "byDob");
			Thread t2 = new Thread(new SortByMarkAndStoreStudent(studentMap, file2), "byMark");
			Thread t3 = new Thread(new SortAndStoreSpecificDataOfStudent(studentMap, cityName, file3), "onlySpecific");
			
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
}
