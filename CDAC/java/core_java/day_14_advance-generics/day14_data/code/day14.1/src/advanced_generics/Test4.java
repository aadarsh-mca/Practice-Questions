package advanced_generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		/*
		 * Use Collection.shuffle  method to shuffle : 
		 * List - 10,20,30,40,50
		 * 	List - "df" ,"dfg" ,"657","hgd","AADFG"

		 */
		List<Integer> intList=Arrays.asList(10,20,30,40,50);
		Collections.shuffle(intList);
		System.out.println(intList);
		List<String> strings=Arrays.asList("df" ,"dfg" ,"657","hgd","AADFG");
		Collections.shuffle(strings);
		System.out.println(strings);
		 

	}

}
