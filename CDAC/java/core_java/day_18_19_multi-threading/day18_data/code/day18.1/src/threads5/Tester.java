package threads5;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter range of nos");
			int begin=sc.nextInt();
			int end =sc.nextInt();
			//create runnable task , attach thrd to it n start the thread
			Thread t1=new Thread(new EvenPrinterTask(begin, end), "even");
			Thread t2=new Thread(new SumOfOddSquares(begin, end), "sum");
			Thread t3=new Thread(new SqrtAvgAll(begin, end), "sqrt");
			//start threads
			t1.start();
			t2.start();
			t3.start();
			System.out.println("main waiting for child thrds....");
			t1.join();
			t2.join();
			t3.join();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over.....");

	}

}
