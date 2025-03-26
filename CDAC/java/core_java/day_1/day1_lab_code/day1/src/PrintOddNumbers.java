import java.util.Scanner;
class PrintOddNumbers {
public static void main(String[] args) {
	//1  create scanner
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter begin n end values to print odd nums");
	int begin=sc.nextInt();
	int end=sc.nextInt();
	for(int i=begin;i<=end;i++) {
		if (i % 2 != 0)
			System.out.println("Next odd no "+i);
	}
	sc.close();
}
}