package exception_handling;

import java.io.FileReader;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				FileReader fin = new FileReader("abc.data")) {
			System.out.println("Enter a number");
			System.out.println("you entered - " + sc.nextInt());// a12345
			System.out.println("end of try");
		} // JVM calls automatically -fin.close() ,  sc.close();
		catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("in finally !");
		}
		System.out.println("code continues....");

	}

}
