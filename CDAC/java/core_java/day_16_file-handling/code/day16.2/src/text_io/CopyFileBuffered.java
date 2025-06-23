package text_io;

import java.io.*;
import java.util.Scanner;

public class CopyFileBuffered {
	/*
	 * Copy all the lines from src file - in upper case format , which contains a
	 * keyword "java" , to dest file.
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Enter src n dest file names");
		try (Scanner sc = new Scanner(System.in);
				// Java App <----BR <-----FR <----src text file
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));
				// Java app --->PrintWriter --> FW --> dest text file
				PrintWriter pw = new PrintWriter(new FileWriter(sc.nextLine()))) {

			br.lines() // Stream<String>
					.filter(s -> s.contains("java")) // Filtered Stream<String>
					.map(s -> s.toUpperCase())// Filtered upper cased Stream<String>
					.forEach(s -> pw.println(s));
			System.out.println("file copied ....");

		} // pw.close --> flush out buffer contents -> close , br.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
