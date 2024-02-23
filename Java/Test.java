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
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;
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

    // {8,5,4,5,1,4,5,2,2}
    // {4,5,6,5}
    // {5,4,3,2,1}

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        // int[] arr = {4,5,6,5};
        int n = arr.length;

        System.out.println(genericReturn("obj1", "obj2", "obj3"));


        



        // PriorityQueue<Integer> pQue = new PriorityQueue<>();
        // PriorityQueue<Integer> pQue = new PriorityQueue<>((a, b) -> b - a);
        // PriorityQueue<Integer> pQue = new PriorityQueue<>(new MinHeap());
        // PriorityQueue<Integer> pQue = new PriorityQueue<>(new MaxHeap());
    }

    public static <T> T genericReturn(T obj1, T obj2, T obj3) {
        return obj2;
    }
}











class MinHeap implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}

class MaxHeap implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}