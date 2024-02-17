import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
// package java_folder;
// import java_folder.DecimalToBinary;
import javax.swing.JButton;


public class Test {
    static Tree root;
    static int prevRight = 0;
    public static void main(String[] args) {
        // root = new Tree(2);
        // root.left = new Tree(1);
        // root.right = new Tree(3);
        
        // inOrder(root);


        // PriorityQueue<Integer> pQue = new PriorityQueue<>();
        PriorityQueue<Integer> pQue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                // if(n1 < n2) {
                //     return n2 - n1;
                // } else {
                //     return n1 - n2;
                // }
                return n2 - n1;
            }
        });

        // [3, 5, 1, 4, 2]

        pQue.add(3);
        pQue.add(5);
        pQue.add(1);
        pQue.add(4);
        pQue.add(2);

        System.out.println(pQue);

    }

    static void inOrder(Tree root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.rootData + " ");
        inOrder(root.right);
    }

}

class Tree {
    int rootData;
    Tree left;
    Tree right;

    Tree(int rootData) {
        this.rootData = rootData;
        this.left = null;
        this.right = null;
    }
}

















class Singleton {
    private Singleton() {
        System.out.println("in Singleton Constructor");
    }
    private static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}




class Compart implements Comparator<String> {
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
}