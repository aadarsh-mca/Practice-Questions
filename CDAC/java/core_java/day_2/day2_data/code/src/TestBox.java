/*
Create another separate class : TestBox , for  user interaction (UI) , with main method 
Use scanner , to accept box dimentions from user and  create a box instance.
Display box details details & volume.

*/
import java.util.Scanner;
class TestBox {
	 public static void main(String[] args) {
	//	 int data;
	//	 System.out.println(data);
		  //scanner
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter box dims - width depth height");
		  Box b1; //mem is allocated on the stack , to store ref type of a var , un inited !
	//	  System.out.println(b1);
	      b1=new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());//1 box type object created in the heap
		  System.out.println(b1);//no javac err ! . o/p Box@123456
		  //display
		  System.out.println(b1.getBoxDetails());
		  System.out.println("Box volume "+b1.getBoxVolume());
		  //close scanner - to avoid resource leak
		  sc.close();
	 }
}