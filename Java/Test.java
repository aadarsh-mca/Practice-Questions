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
        int[] arr = {2,4,10,10,10,10,10,10,11,12,14,14,17,19,19};
        int n = arr.length;
        int x = 10;

        System.out.println(count(arr, n, x));
    }

    public static int count(int arr[], int n, int x) {
        //Your code goes here
        int count = 0;

        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == x) {
                count++;
                count += getLeftCount(arr, x, mid-1, left);
                count += getRightCount(arr, x, mid+1, right);
                break;
            } else if(arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return count;
    }

    static int getLeftCount(int[] arr, int target, int start, int end) {
        int count = 0;
        while(start >= end) {
            if(arr[start] == target) {
                count++;
            } else {
                break;
            }
            start--;
        }
        return count;
    }
    
    static int getRightCount(int[] arr, int target, int start, int end) {
        int count = 0;
        while(start <= end) {
            if(arr[start] == target) {
                count++;
            } else {
                break;
            }
            start++;
        }
        return count;
    }






    


    static int test(int[][] arr) {
        return 0;
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b){
        // Write your code here.
        int nA = a.length;
        int nB = b.length;
        a = Arrays.copyOf(a, (nA+nB));

        int last = nA + nB - 1;
        nA -= 1;
        nB -= 1;

        // If there is no element in b, 
        // that mean all the element of a is in correct place
        // and no further adjustment required.

        // If we have element in b, that mean adjustment is still required.
        while(nB >= 0) {
            if(nA >= 0 && a[nA] > b[nB]) {
                a[last--] = a[nA--];
            } else {
                a[last--] = b[nB--];
            }
        }
    }










    public static <T> T genericReturn(T obj1, T obj2, T obj3) {
        return obj2;
    }
}

interface Interface {
    public void display1();
    public void display2();
}

abstract class AbstractClass implements Interface {
    /**
     * How many methods do we need to implement in class B?
     * 
     * Can we make display1() display2() as abstract in this class?
     * 
     */
}

class Check extends AbstractClass {

    public void display1() {
    }

    public void display2() {
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