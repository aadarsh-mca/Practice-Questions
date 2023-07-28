import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortEmployee {
    
    public static void main(String[] args) {
        int n = 4;
        Node[] arr = new Node[n];
        arr[0] = new Node(50, "shyam");
        arr[1] = new Node(100, "ram");
        arr[2] = new Node(200, "aadi");
        arr[3] = new Node(50, "xyz");
        
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> salaryList = new ArrayList<>();
        ArrayList<String> empName = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            int salary = arr[i].salary;
            String name = arr[i].name;
            salaryList.add(salary);
            empName.clear();
            empName.add(name);
            System.out.println("Emp : " + empName);
            
            if(map.containsKey(salary)) {
                // empName.clear();
                empName.addAll(map.get(salary));
                // empName.add(arr[i].name);
                Collections.sort(empName);
                map.put(salary, empName);
            } else {
                // empName.clear();
                // empName.add(arr[i].name);
                map.put(salary, empName);
            }
        }
        
        System.out.println();
        Collections.sort(salaryList);
        System.out.println(salaryList);
        System.out.println(empName);
        System.out.println(map);

        
        System.out.println();
        System.out.println(map.get(200));

    }
}

class Node {
    int salary;
    String name;

    public Node(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
}
