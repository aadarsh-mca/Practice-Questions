package text_io;
import java.io.*;
import java.util.Scanner;
public class TestBufferedFileRead {

	public static void main(String[] args) {
		System.out.println("Enter file name");
		try(Scanner sc=new Scanner(System.in);
				//Java App <----BR <-----FR <----text file
				BufferedReader br=new BufferedReader
						(new FileReader(sc.nextLine()))
				) {
			
			//display all the lines in upper case format , which contains a keyword "java"
			br.lines() //Stream<String>
			.filter(s -> s.contains("java")) //Filtered Stream<String>
			.map(s -> s.toUpperCase())//Filtered upper cased Stream<String> 
			.forEach(s -> System.out.println(s));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
