package legacy_dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) /* throws ParseException */{
		/*
		 * Solve - Accept DoB date from user n store it in 
		 * BankAccount class.
		 *LATER  - sort the bank accounts as per a/c creation date.
		 */
		try (Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter DoB - yr-mon-day");
			//1. SDF
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//2. parse
			Date dob=sdf.parse(sc.next());
			//3 toString & format 
		//	System.out.println("toString "+dob);
			System.out.println(sdf.format(dob));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("code continues......");

	}

}
