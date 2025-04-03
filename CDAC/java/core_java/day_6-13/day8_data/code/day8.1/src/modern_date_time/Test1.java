package modern_date_time;

import java.time.LocalDate;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter DoB of the 1st user");
			LocalDate dob1 = LocalDate.parse(sc.next());
			System.out.println("Enter DoB of the 2nd user");
			LocalDate dob2 = LocalDate.parse(sc.next());
			System.out.println("Senior user " 
			+ (dob1.isBefore(dob2) ? "1st User" : "2nd user"));
			

		}

	}

}
