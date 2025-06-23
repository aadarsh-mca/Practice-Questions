package functional_streams;

import java.util.stream.IntStream;

public class Test0 {

	public static void main(String[] args) {
		/*
		 * Create int stream in the range : 5-50
		 * Filter out odd nos n Display them
		 */
		IntStream.rangeClosed(5, 50) //IntStream - ints 5 -50
		.filter(i -> i % 2 != 0)//new IntStream - odd nos in 5,7,.....49  
		.forEach(i -> System.out.print(i+" "));
	}

}
