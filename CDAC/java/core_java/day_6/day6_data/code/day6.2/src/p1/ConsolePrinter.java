package p1;

public class ConsolePrinter implements Printer{
 @Override
 public void  print(String mesg)
 {
	 System.out.println("Printing a mesg on the console - "+mesg);
	 /*
	  * Can implementation class directly use i/f constant : YES
	  * Non imple classes - have to access - InterfaceName.dataMember
	  */
	 System.out.println(SPEED);
 }
}
