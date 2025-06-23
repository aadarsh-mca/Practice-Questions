package tester;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class RestoreProducts {

	public static void main(String[] args) {
		/*
		 * accept file name from user n create chain of strms n restore product details
		 */
		System.out.println("Enter file name");
		try (Scanner sc = new Scanner(System.in);
				// Java App <---- OIS : de ser <----- FIS (bin file)
				ObjectInputStream in = new ObjectInputStream
						(new FileInputStream(sc.nextLine()))) {
			Object o = in.readObject();
			System.out.println(o);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
