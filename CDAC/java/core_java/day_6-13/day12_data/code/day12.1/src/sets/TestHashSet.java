package sets;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {

	public static void main(String[] args) {
		String[] names = { "Sumeet", "Anish", "Kiran", "Medha", 
				"Puneet", "Shubham", "Kiran", "Anish" };
		// create empty unsorted n un ordered HashSet , to store strings
		HashSet<String> stringSet = new HashSet<>();// size=0,init capa=16,L.F=0.75
		// populate set with above names
		for (String s : names) {
			System.out.println("Added " + stringSet.add(s));
		}
		System.out.println("HS contents - "+stringSet);
		System.out.println(stringSet.size());
		//display set using Iterator
		Iterator<String> itr=stringSet.iterator();
		System.out.println("HS via Iterator");
		while(itr.hasNext())
			System.out.println(itr.next());
		
		System.out.println(stringSet.contains("Kiran"));//t
		System.out.println(stringSet.remove("Kiran"));//t
		System.out.println(stringSet.contains("Kiran"));//f
		System.out.println("HS contents after remove - "+stringSet);
	}

}
