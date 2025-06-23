package p2;

import java.util.Arrays;
import java.util.List;

/*
 * Display all integers from the integer list
 */
public class Test1 {

	public static void main(String[] args) {
		List<Integer> ints=Arrays.asList(10,2,5,67,8,9,10);
		for(int i : ints)
			System.out.println(i);
		//SAM of the Consumer i/f 
		//public void accept(T arg)
		ints.forEach(i -> System.out.println(i));
		//forEach - higher order method , whic accepts a Functional i/f
		//which can be replaced by a lambda !

	}

}
