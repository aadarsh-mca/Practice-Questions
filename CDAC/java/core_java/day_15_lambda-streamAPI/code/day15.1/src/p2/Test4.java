package p2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 *remove all odd nos from the int list
 */
public class Test4 {

	public static void main(String[] args) {
		List<Integer> ints=new LinkedList<>(Arrays.asList(14,2,50,6,8,90,10));
		System.out.println("orig list");
		ints.forEach(i -> System.out.println(i));
		/*
		 * Collection<T>  i/f method
		 * public default boolean removeIf(Predicate<? super T> filter)
		 * Removes all the elements from the collection , if it satisfies 
		 * given filtering condition
		 * rets true - if the elems are removed , o.w false
		 * Predicate : func i.f
		 * SAM - public abstract boolean test(T arg)
		 */
		System.out.println("Removed anything at all ? "
		 +ints.removeIf(i -> i % 2 != 0));
		System.out.println("List after remove");
		ints.forEach(i -> System.out.println(i));
		

	}

}
