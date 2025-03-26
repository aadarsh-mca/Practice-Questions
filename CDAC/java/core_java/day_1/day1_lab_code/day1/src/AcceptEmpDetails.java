import java.util.Scanner;
class AcceptEmpDetails {
public static void main(String[] args) {
	//1  create scanner
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter emp details - id firstname lastname salary permanent status");
	System.out.printf("Emp Id %d Name %s %s Salary %.2f Is Permanent %b %n",sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),sc.nextBoolean());
	sc.close();
}
}