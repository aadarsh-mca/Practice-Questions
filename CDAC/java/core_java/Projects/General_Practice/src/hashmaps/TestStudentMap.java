package hashmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStudentMap {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create empty HashMap to store student details - init capa =128
			HashMap<String, Student> students = new HashMap<>(128);
			System.out.println(students);// {}
			// populate the map
			System.out.println("rets " 
			+ students.put("dac-0009", new Student("dac-0009", "Rama", 80)));
			System.out.println("rets " 
			+ students.put("dac-0009", new Student("dac-0009", "Mihir", 70)));
			System.out.println("rets " 
			+ students.put("dac-0031", new Student("dac-0031", "Kiran", 85)));
			System.out.println("rets " 
			+ students.put("dac-0015", new Student("dac-0015", "Souma", 76)));
			System.out.println("rets " 
			+ students.put("dac-0024", new Student("dac-0024", "Samay", 72)));
			System.out.println("rets "
			+ students.putIfAbsent("dac-0009", new Student("dac-0009", "Riya", 71)));
		//	System.out.println(students);
			//display student details - on separate lines
//			System.out.println("All students - ");
//			for(Student s : students.values())// Collection<Student>
//				System.out.println(s);
			
			
//			System.out.println("\n=================================");
//			System.out.println("Enter roll no : ");
//			String rollNo = sc.next();
//			System.out.println("Enter marks : ");
//			int marks = sc.nextInt();
//
////			System.out.println(students);
//			System.out.println(students.get(rollNo));
//			students.get(rollNo).setMarks(marks);
////			System.out.println(students);
//			System.out.println(students.get(rollNo));
//			
//			System.out.println(students);
//			
//			System.out.println("\n==================================");
//			System.out.println("Enter marks : ");
//			marks = sc.nextInt();
//			for(Map.Entry<String, Student> entry : students.entrySet()) {
//				if(entry.getValue().getMarks() > marks) {
//					System.out.println(entry.getValue());
//				}
//			}

			
			System.out.println("\n==================================");
//			System.out.println(students);
			
//			TreeMap<String, Student> sortedMap = new TreeMap<>(
//				Comparator.comparing(key -> students.get(key).getName())
//			);
			
//			List<Map.Entry<String, Student>> sortedList = new ArrayList<>(students.entrySet());
//			
//			sortedList.sort(new Comparator<Map.Entry<String, Student>>() {
//				@Override
//				public int compare(Entry<String, Student> s1, Entry<String, Student> s2) {
//					return s1.getValue().getName().compareTo(s2.getValue().getName());
//				}
//			});
			
			System.out.println(students);
			
			
			//
			List<Entry<String, Student>> sortedList = new ArrayList<>(students.entrySet());
			
			sortedList.sort(new Comparator<Entry<String, Student>>() {
				@Override
				public int compare(Entry<String, Student> s1, Entry<String, Student> s2) {
					return s1.getValue().compareTo(s2.getValue());
				}
			});
			System.out.println(sortedList);
			
			
			//
			LinkedHashMap<String, Student> linkedSortedMap = new LinkedHashMap<>();
			
			students.entrySet().stream().sorted(new Comparator<Map.Entry<String, Student>>() {
				@Override
				public int compare(Entry<String, Student> s1, Entry<String, Student> s2) {
					return s1.getValue().getName().compareTo(s2.getValue().getName());
				}
			}).collect(Collectors.toList()).forEach((entry) -> linkedSortedMap.put(entry.getKey(), entry.getValue()));
			
			System.out.println(linkedSortedMap);
			
//			TreeMap<String, Student> sortedMap = new TreeMap<>(new Comparator<Map.Entry<String, Student>>() {
//				@Override
//				public int compare(Entry<String, Student> s1, Entry<String, Student> s2) {
//					return Integer.compare(s1.getMarks(), s2.getMarks());
//				}
//			});
			
			
//			students.entrySet().stream().sorted(new Comparator<Map.Entry<String, Student>>() {
//				@Override
//				public int compare(Entry<String, Student> s1, Entry<String, Student> s2) {
//					return s1.getKey().compareTo(s2.getKey());
//				}
//			});
			
//			System.out.println(sortedMap);

			
			
			
		}

	}

}
