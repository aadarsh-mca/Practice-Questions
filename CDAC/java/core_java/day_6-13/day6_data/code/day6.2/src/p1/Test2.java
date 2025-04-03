package p1;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * Invoke print method on different type of printers , using single for-each
		 * loop BUT if its a FilePrinter - open file -print -close file If its
		 * NetworkPrinter - establish connection - print -close connection For
		 * ConsolePrinter - no set up required ! , directly print a mesg
		 */
		// printers : array of i/f type of references.
		Printer[] printers = { new ConsolePrinter(),
				new FilePrinter(), 
				new NetworkPrinter() }; // up casting - indirect
																		// referencing. - javac
																								// implicitly adds the
																								// cast
		for (Printer p : printers) {
			if (p instanceof FilePrinter) {
				((FilePrinter) p).openFile("my-file.txt");
				p.print("mesg1");
				((FilePrinter) p).closeFile("my-file.txt");
			} else if (p instanceof NetworkPrinter) {
				((NetworkPrinter) p).establishConnection("www.abc.com");
				p.print("mesg2");
				((NetworkPrinter) p).closeConnection("www.abc.com");
			} else
				p.print("Hello !");// run time polymorphism
		}
	}

}
