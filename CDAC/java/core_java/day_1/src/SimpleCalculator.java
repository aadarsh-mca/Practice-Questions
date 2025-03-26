import java.util.Scanner;

class SimpleCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean toExit = false;
		while(toExit == false) {
			printCalculatorOption();

			char operation = scan.next().charAt(0);

			int num1 = 0;
			int num2 = 0;
			int value = 0;

			switch(operation) {
			case '+':
				System.out.println("Enter 2 numbers : ");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				value = num1 + num2;

				System.out.println("The sum of " + num1 + " and " + num2 + " is : " + value);
				break;
			case '-':
				System.out.println("Enter 2 numbers : ");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				value = num1 - num2;

				System.out.println("The difference of " + num1 + " and " + num2 + " is : " + value);
				break;
			case '*':
				System.out.println("Enter 2 numbers : ");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				value = num1 * num2;

				System.out.println("The product of " + num1 + " and " + num2 + " is : " + value);
				break;
			case '/':
				System.out.println("Enter 2 numbers : ");
				num1 = scan.nextInt();
			 	num2 = scan.nextInt();
				value = num1 / num2;

				System.out.println("The division of " + num1 + " and " + num2 + " is : " + value);
				break;
			default:
				toExit = true;
				System.out.println("Invalid operation !!!");
				System.out.println("Closing the Calculator.....");
			}
		}

		scan.close();
	}

	static void printCalculatorOption() {
		System.out.println("\nPress '+' for Addition");
		System.out.println("Press '-' for Subtraction");
		System.out.println("Press '*' for Multiplication");
		System.out.println("Press '/' for Division");
	}
}