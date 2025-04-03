package sets;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		String[] names = { "Sumeet", "Anish", "Kiran", "Medha", 
				"Puneet", "Shubham", "Kiran", "Anish" };
		// create empty sorted n  un ordered TreeSet , to store strings
		Set<String> stringSet = new TreeSet<>();// size=0,init capa=16,L.F=0.75
		// populate set with above names
		for (String s : names) {
			System.out.println("Added " + stringSet.add(s));
		}
		System.out.println("TS contents - "+stringSet);	
		
	}

}
