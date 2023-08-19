import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortEmployee {
    
    public static void main(String[] args) {

        // shortcut
        //  1. Arrays.sort(arr, Comparator.comparing((node temp) -> temp.salary).thenComparing((node temp) -> temp.name));
        /** 2. Arrays.sort(arr,new Comparator<node>(){
            public int compare(node n1,node n2){
                if(n1.salary>n2.salary){
                    return 1;
                }else if(n1.salary==n2.salary){
                    return n1.name.compareTo(n2.name);
                }else{
                    return -1;
                }
            }
        });
        **/

        int n = 4;
        Node[] arr = new Node[n];
        arr[0] = new Node(50, "shyam");
        arr[1] = new Node(100, "ram");
        arr[2] = new Node(200, "aadi");
        arr[3] = new Node(50, "xyz");
        
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> salaryList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            int salary = arr[i].salary;
            String name = arr[i].name;
            salaryList.add(salary);

            nameList = new ArrayList<>();
            nameList.add(name);
            
            if(map.containsKey(salary)) {
                nameList.addAll(map.get(salary));
                Collections.sort(nameList);
            } 
            map.put(salary, nameList);
        }
        
        System.out.println();
        Collections.sort(salaryList);
        System.out.println(salaryList);
        System.out.println(map);
        
        System.out.println();
        for(int i=0; i<n; i++) {
            int key = salaryList.get(i);
            ArrayList<String> empList = map.get(key);
            int noOfEmp = empList.size();
            
            if(noOfEmp <= 1) {
                arr[i].setName(empList.get(0));
                arr[i].setSalary(key);
            } else {
                int j=0;
                while(j<noOfEmp) {
                    arr[i].setName(empList.get(j));
                    arr[i].setSalary(key);
                    if(j != noOfEmp - 1){
                        i++;
                    }
                    j++;
                }
                // i--;
            }
        }

        for(int i=0; i<n; i++) {
            System.out.println(arr[i].name + " --> " + arr[i].salary);
        }


    }
}

class Node {
    int salary;
    String name;

    public Node(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
