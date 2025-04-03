import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import linkedList.GenericQueue;
import stack.GenericStack;

public class Main {

	public static void main(String[] args) {
//		callGenericClassObjects();
		
		hashmapTest();
		
	}
	
	private static void hashmapTest() {
		System.out.println("BBBB".hashCode());
		System.out.println("AaBB".hashCode());
		System.out.println("AaAa".hashCode());
		System.out.println("BBAa".hashCode());
		
		System.out.println("Aadarsh".hashCode());
		System.out.println("Aadarsh".hashCode() >> 16);
		System.out.println(("Aadarsh".hashCode()) ^ ("Aadarsh".hashCode() >>> 16));
		
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		
		Set<Integer> set = map.keySet();
		System.out.println(set);
		map.remove(3);
		System.out.println(set);
	
	}
	
	
	
	
	
	private static void callGenericClassObjects() {
		/**
		 * 
		 * Integer
		 * 
		 */
		System.out.println("====== [ Generic Integer Queue ] ======");
		GenericQueue<Integer> genericIntegerQueue = new GenericQueue<Integer>();
		
		genericIntegerQueue.add(10);
		genericIntegerQueue.add(20);
		genericIntegerQueue.add(30);
		
		System.out.println(genericIntegerQueue);
		genericIntegerQueue.remove();
		System.out.println(genericIntegerQueue);

		System.out.println("\n====== [ Generic Integer Stack ] ======");
		GenericStack<Integer> genericIntegerStack = new GenericStack<>();
		
		genericIntegerStack.push(10);
		genericIntegerStack.push(20);
		genericIntegerStack.push(30);
	
		System.out.println(genericIntegerStack);
		genericIntegerStack.pop();
		System.out.println(genericIntegerStack);
		
		/**
		 * 
		 * Double
		 * 
		 */
		System.out.println("\n====== [ Generic Double Stack ] ======");
		GenericStack<Double> genericDoubleStack = new GenericStack<>();
		
		genericDoubleStack.push(10.234);
		genericDoubleStack.push(131.424);
		genericDoubleStack.push(50.00);
		
		System.out.println(genericDoubleStack);
		genericDoubleStack.pop();
		System.out.println(genericDoubleStack);
	}

}
