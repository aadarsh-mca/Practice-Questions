package enums;

import java.util.Iterator;
import java.util.Scanner;

public class TestEnum {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// display all available colors -
			for (Color c : Color.values())
				System.out.print(c + " ");
			System.out.println("Choose color");
			Color chosenColor = Color.valueOf(sc.next().toUpperCase());
			System.out.println("you chose - " + chosenColor);
			/*
			 * Can you use enum as switch argument ? YES
			 */
			switch (chosenColor) {
			case RED:
				System.out.println("1");

				break;
			case BLUE:
				System.out.println("2");
				break;
			case GREEN:
				System.out.println("3");

				break;

			default:
				break;
			}

		} // JVM - sc.close()

	}

}
