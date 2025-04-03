package modern_date_time;

import java.time.LocalDate;
import java.util.Scanner;

import custom_exceptions.LicenseExpiredException;

import static java.time.LocalDate.*;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * accept license exp date from user . Raise custom exception - if the license
		 * is expired.
		 */
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter license exp date yr mon day");
			LocalDate expDate = of(sc.nextInt(), sc.nextInt(), sc.nextInt());
			if (expDate.isBefore(now()))
				throw new LicenseExpiredException("License is expired !!!!!!");
			System.out.println("Valid license ...");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("code continues");

	}

}
