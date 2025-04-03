package p1;

public class FilePrinter implements Printer {
	@Override
	public void print(String mesg) {
		System.out.println("Saving a mesg in the text file - " + mesg);
		/*
		 * Can implementation class directly use i/f constant : YES Non imple classes -
		 * have to access - InterfaceName.dataMember
		 */
		System.out.println(SPEED);
	}

	// Can implementation class add new functionality ? YES
	public void openFile(String fileName) {
		System.out.println("opening file -"+fileName);

	}
	public void closeFile(String fileName) {
		System.out.println("closing file -"+fileName);

	}
}
