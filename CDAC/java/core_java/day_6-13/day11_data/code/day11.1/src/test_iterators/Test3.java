package test_iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class Test3 {

	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>();// size =0, capa =10
		int[] data = { 10, 2, 24, 2, 10, -10, 45, 60, 10 };
		for (int i : data)
			ints.add(i);// auto boxing
		System.out.println("List via toString - " + ints);
		Iterator<Integer> itr = ints.iterator();
	//	itr.remove();//IllegalStateException
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
			itr.remove();
			itr.remove();
		}
		System.out.println();
		System.out.println("List again  toString - " + ints);

	}

}
