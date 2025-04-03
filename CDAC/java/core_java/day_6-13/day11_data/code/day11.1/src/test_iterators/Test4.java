package test_iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class Test4 {

	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>();// size =0, capa =10
		int[] data = { 10, 2, 24, 2, 10, -10, 45, 60, 10 };
		for (int i : data)
			ints.add(i);// auto boxing
		System.out.println("List via toString - " + ints);
		Iterator<Integer> itr = ints.iterator();
	//	ints.set(0, 12345);	
		ints.add(99);
		itr = ints.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");		
		}
		

	}

}
