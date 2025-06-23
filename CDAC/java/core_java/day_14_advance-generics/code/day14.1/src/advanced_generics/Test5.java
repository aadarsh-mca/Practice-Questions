package advanced_generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import fruits.Apple;
import fruits.Mango;
import fruits.Orange;
import static utils.GenericUtils.*;

/*
 * Add a static  method in the GenericUtils class - to print taste of ANY fruit 
 * added in any Type of Set

Test cases 
HS <Mango> 
| LHS <Apple>
 | TS <Orange>
eg - printTastes 

 */
public class Test5 {

	public static void main(String[] args) {
		HashSet<Mango> mangoes=new HashSet<>(
				Arrays.asList(new Mango(),
						new Mango(),
						new Mango()));
		printTastes(mangoes);
		System.out.println("-----------------------");
		LinkedHashSet<Apple> apples=new LinkedHashSet<>(
				Arrays.asList(new Apple(),
						new Apple(),
						new Apple()));
		printTastes(apples);
		System.out.println("-------------");
//		TreeSet<Orange> oranges=new TreeSet<>(
//				Arrays.asList(new Orange(),
//						new Orange(),new Orange()));
//		printTastes(oranges);
//		System.out.println("-------------");
				

	}

}
