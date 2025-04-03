package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;
import static java.time.LocalDate.parse;

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
						45.6,-70.77,59.0));
		System.out.println("Max double "+GenericUtils.findMax(doubles));

		Vector<LocalDate> dates=
				new Vector<>(Arrays.asList(parse("2025-10-20"),
						parse("2024-11-20"),
						parse("2022-09-25"),
						parse("2024-11-29"),
						parse("2025--3-20")
						));
		System.out.println("Max Date (Latest Date) "+GenericUtils.findMax(dates));
	
	}

}
