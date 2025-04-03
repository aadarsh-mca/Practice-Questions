package sets;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//create a TreeSet - for desc order of strings - ano inner class
public class TestTreeSet2 {

	public static void main(String[] args) {
		String[] names = { "Sumeet", "Anish", "Kiran", "Medha", "Puneet", "Shubham", "Kiran", "Anish" };
		// create empty sorted n un ordered TreeSet , to store strings(desc order)
		Set<String> stringSet = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				System.out.println("in compare - ano inner cls");
				return s2.compareTo(s1);
			}

		});// size=0,init capa=16,L.F=0.75
		System.out.println(stringSet);//[]
		// populate set with above names
		for (String s : names) {
			System.out.println("Added " + stringSet.add(s));
		}
		System.out.println("TS contents - " + stringSet);

	}

}
