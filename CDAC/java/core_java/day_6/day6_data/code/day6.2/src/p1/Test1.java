package p1;

public class Test1 {

	public static void main(String[] args) {
		
//		FilePrinter filePrinter=new FilePrinter();
//		filePrinter.print("some mesg!!!!!");
//		ConsolePrinter cp=new ConsolePrinter();
//		cp.print("mesg1");
//		NetworkPrinter np=new NetworkPrinter();
//		np.print("mesgs....");
//		Printer p;//p : interface type of the reference
//		//p=new Printer();
//		p=filePrinter;//up  casting
		/*
		 * Invoke print method on different type of printers , using single
		 * for-each loop
		 */
		//printers : array of i/f type of references.
		Printer[] printers= {
				new ConsolePrinter(),
				new FilePrinter(),
				new NetworkPrinter()
		}; //up casting - indirect referencing. - javac implicitly adds the cast
		for (Printer p : printers)
			p.print("Hello !");//run time polymorphism
	}

}
