package test_iterators;

import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>();// size =0, capa =10
		int[] data = { 10, 2, 24, 2, 10, -10, 45, 60, 10 };
		for (int i : data)
			ints.add(i);// auto boxing
		System.out.println("List via toString - " + ints);
	//	System.out.println(ints.get(ints.size()));//IndexOutOfBoundsExc
	//	ints.remove(-100);
	}

}
