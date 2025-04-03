package advanced_generics;

import java.util.Arrays;
import java.util.List;

/*
 * Generic methods - methods containing a type parameter in it's declaration
 * Can exist in non generic class
 * Type declaration fits between method modifiers n its return type
 */
public class Test1 {

	public static void main(String[] args) {
		/*
		 * API - java.util.Arrays -class
		 * public static <T> List<T> asList(T... element)
		 */
		List<Integer> ints=Arrays.asList(10,20,30,40,50);
		System.out.println(ints);
	//	ints.add(60);//UnsupportedOperationExc
		//ints.remove(0);//UnsupportedOperationExc
		ints.set(0, 999999);
		System.out.println(ints);
		List<Double> doubles=Arrays.asList(100.0,1.34,56.778,0.5,67.56);
		System.out.println(doubles);

	}

}
