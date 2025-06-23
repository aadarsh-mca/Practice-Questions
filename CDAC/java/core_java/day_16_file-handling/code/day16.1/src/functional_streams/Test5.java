package functional_streams;

import java.util.stream.IntStream;

public class Test5 {

	public static void main(String[] args) {
		/*
		 * Display sum of all odd numbers within some range
		 */
		int sumOfOdds = IntStream.rangeClosed(1, 15) //IntStream : 1---15
		.filter(i -> i % 2 != 0) //IntStream - odd nos
		.sum();//terminal op (specialized form of reduce) 
		System.out.println("Sum "+sumOfOdds);

	}

}
