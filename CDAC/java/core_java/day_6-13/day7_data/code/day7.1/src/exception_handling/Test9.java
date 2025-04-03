package exception_handling;

import static utils.VehicleValidationRules.validateSpeed;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) /* throws SpeedOutOfRangeException */ {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter current speed ");
			validateSpeed(sc.nextInt());
			System.out.println("end of try ....");
		} // sc.close() - JVM
		catch (Exception e) {
		//	e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("code continues....");
	}

}
