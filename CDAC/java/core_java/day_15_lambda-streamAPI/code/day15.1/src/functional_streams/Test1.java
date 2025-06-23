package functional_streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * Attach stream to the int[] n display all the elems
		 */
		int[] data= {12,34,2,3,4,5,77,100,-10};
		
		/*
		 * Use java.util.Arrays method
		 * public static IntStream stream(int[] ints)
		 * Use IntStream terminal op
		 * public default void forEach(IntConsumer action)
		 * IntConsumer - Func i/f
		 * SAM - public void accept(int i) 
		 * 
		 */
		Arrays.stream(data) //IntStream : src
		.forEach(i -> System.out.println(i)); //terminal op.	
		
		IntStream intStream=IntStream.of(1,2,3,5,6,8,67,23);
		intStream.forEach(i -> System.out.println(i));
		System.out.println("----------");
		
//	intStream.forEach(i -> System.out.println(i));//JVM - IllegalStateExc - stream alrdy closed !
		/*
		 *  create IntStream : 2-----50 n display it
		 *  IntStream i/f - method
		 *  public static IntStream range|rangeClosed(int begin,int end)
		 */
		System.out.println("Printing ints 2 -50");
		IntStream.range(2, 51) //IntStream - ints 2 50
		.forEach(i -> System.out.print(i+" "));
		 
	
		
		
		

	}

}
