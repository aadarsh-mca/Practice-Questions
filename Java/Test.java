import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import java.util.Map.Entry;

public class Test {
    
    public static void main(String[] args) {

        node[] nd = new node[4];
        nd[0] = new node("Aadi", 100000);
        nd[1] = new node("ABC", 100);

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("10");
        arrList.add("20");
        arrList.add("-10");
        arrList.add("12");

        System.out.println(arrList);
        Collections.sort(arrList);
        System.out.println(arrList);

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        // Collections.sort(map);

    }

}

class node {
    int salary;
    String name;

    public node(String s, int a) {
        this.name=s;
        this.salary=a;
    }
}
