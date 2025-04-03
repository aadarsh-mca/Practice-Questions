package lists;

import java.util.ArrayList;

public class IntegerList {

	public static void main(String[] args) {
		/*
		 * Objectives 
0. Create empty ArrayList of integers & populate it with
 some data from array - {10,2,24,2,10,-10,45,60}
  Check for dup n also if its growable
1. check if element exists in the list.
2. disp index of 1st n last  occurrence of the elem
3. double values in the list --if elem val > 20
4. remove elem at the specified index - 5. 

		 */
		ArrayList<Integer> ints=new ArrayList<>();//size =0, capa =10
		int[] data= {10,2,24,2,10,-10,45,60,10};
		for(int i : data)
			ints.add(i);//auto boxing
		System.out.println("List via toString - "+ints);
		ints.add(0, 12345);
		System.out.println("List via toString - "+ints);
		System.out.println(ints.contains(-100)?"Exists":"Doesn't Exist");
		System.out.println(ints.indexOf(10)+"  "+ints.lastIndexOf(10));
		//double values in the list --if elem val > 20
		for (int i=0;i<ints.size();i++)
		{
			if(ints.get(i) > 20) {
				System.out.println(ints.set(i, ints.get(i)*2));
			}
		}
		System.out.println("List after replace - "+ints);
		//remove elem at the specified index - 5. 
		System.out.println("Removed - "+ints.remove(5));
		System.out.println("List after remove - "+ints);
	}

}
