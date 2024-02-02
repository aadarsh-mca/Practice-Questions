import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// package java_folder;
// import java_folder.DecimalToBinary;

public class Test {
    
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(fibonacciHelper(5, new int[5])));

        System.out.println(fib(4));
    }

    static int[] fibonacciHelper(int n, int[] res) {
        if(n < 3) {
            res[0] = 0;
            res[1] = 1;
            return res;
        }
        fibonacciHelper(n-1, res);
        res[n-1] = res[n-2] + res[n-3];
        return res;
    }

    public static int fibo(int[] arr, int n)
    {
        if(n>=0 && n<= 30) //constraint
        {
            if(arr[n]==0)    //DP logic
                if(n==0 || n==1)
                    return n;
                else
                    return arr[n]=fibo(arr,n-1)+fibo(arr,n-2);
            else 
                return arr[n];
        }
        return 0;
    }
    public static int fib(int n) {
        int[] arr = new int[n+1];
        return fibo(arr,n);
    }


}