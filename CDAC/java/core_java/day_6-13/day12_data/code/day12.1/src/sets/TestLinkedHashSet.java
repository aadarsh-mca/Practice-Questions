package sets;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		String[] names = { "Sumeet", "Anish", "Kiran", "Medha", 
				"Puneet", "Shubham", "Kiran", "Anish" };
		// create empty unsorted n  ordered LinkedHashSet , to store strings
		Set<String> stringSet = new LinkedHashSet<>();// size=0,init capa=16,L.F=0.75
		// populate set with above names
		for (String s : names) {
			System.out.println("Added " + stringSet.add(s));
		}
		System.out.println("LHS contents - "+stringSet);	
		
	}

}
