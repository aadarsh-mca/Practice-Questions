package com.generic.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;
import java.time.LocalDate;

/*
 * 2. Solve - Write a generic method to return  max element
 *  from ANY List
eg - Test cases
ArrayList<Integer>
LinkedList<Double>
Vector<LocalDate>

 */
public class Test2 {

	public static void main(String[] args) {
		ArrayList<Integer> ints=
				new ArrayList<>(Arrays.asList(10,20,1,34,45,-70,59));
		System.out.println("Max int "+GenericUtils.findMax(ints));

		
		LinkedList<Double> doubles=
				new LinkedList<>(Arrays.asList(10.0,20.6,1.3,3.4,
						45.6,-70.77,102.0));
		System.out.println("Max double "+GenericUtils.findMax(doubles));

		
		Vector<LocalDate> dates=
				new Vector<>(Arrays.asList(LocalDate.parse("2025-10-20"),
						LocalDate.parse("2024-11-20"),
						LocalDate.parse("2022-09-25"),
						LocalDate.parse("2024-11-29"),
						LocalDate.parse("2025-03-20")
						));
		System.out.println("Max Date (Latest Date) "+GenericUtils.findMax(dates));
	
	}

}
