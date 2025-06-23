package advanced_generics;

import java.util.ArrayList;
import java.util.List;

import fruits.Apple;
import fruits.Fruit;
import fruits.Mango;
import static utils.GenericUtils.*;

public class Test3 {

	public static void main(String[] args) {
		Fruit f=new Mango();
		f.taste();
		f=new Apple();
		f.taste();
		List<Fruit> fruits=new ArrayList<>();
		List<Mango> mangoes=new ArrayList<>();
	//	fruits=mangoes;
		List<Object> objects=new ArrayList<>();
	//	objects=fruits;
	//	object=mangoes;
		/*
		 * Inheritance is generics does NOT work exactly as it works in OOP.
		 * Super type reference can directly refer to ANY sub type object
		 * BUT -
		 * List<Object> IS NOT a super type of List<Fruit> | List<Emp> ....
		 * javac error - type mismatch! 
		 */
		//List<T> anyList;
		List<?> anyList;
		/*
		 * ? => un bounded wild card in generics
		 * It can be substituted by ANY type
		 */
		anyList=fruits;
		anyList=mangoes;
		printElements2(fruits);
	}

}
