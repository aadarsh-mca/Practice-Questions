package advanced_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

import fruits.Apple;
import fruits.Fruit;
import fruits.Mango;
import static utils.GenericUtils.printElements;

/*
 * Tester - test cases 
AL<Integer> | Vector<String> | LinkedList<Fruit>
HS | LHS | TS of any type .


 */
public class Test2 {

	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		ints.add(12345);
		printElements(ints);
		System.out.println("------------------");
		Vector<String> strings = new Vector<>(Arrays.asList("aa", "bb", "cc"));
		printElements(strings);
		System.out.println("------------------");

		LinkedList<Fruit> fruits = new LinkedList<Fruit>();
		fruits.add(new Mango());
		fruits.add(new Apple());
		printElements(fruits);
		System.out.println("------------------");

		HashSet<Double> doubles = new HashSet<>
		(Arrays.asList(100.0, 1.34, 56.778, 0.5, 67.56,1.34, 56.778));
		printElements(doubles);
		System.out.println("------------------");

		TreeSet<Double> ts=new TreeSet<>(doubles);
		printElements(ts);
		System.out.println("------------------");

	}

}
