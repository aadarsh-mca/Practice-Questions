import java.util.Scanner;
class TestScanner {
public static void main(String[] args) {
 //1. Create instance of Scanner class , to wrap std in - System.in : Inputstream
   Scanner sc=new Scanner(System.in);
    System.out.println("Enter 2 doubles");
	double d1=sc.nextDouble();
	double d2=sc.nextDouble();
	System.out.println("Div "+(d1/d2));
   //close scanner before terminating the app
   sc.close();
}
}