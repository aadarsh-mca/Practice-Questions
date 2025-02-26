import java.lang.foreign.MemorySegment;
import java.math.BigInteger;
import java.nio.channels.Pipe;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
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

import java.awt.*;
import java.util.Collection;
import java.util.Queue;
import java.util.Collections;
import java.applet.*;

class Pair {
    char character;
    int freq;

    Pair(char character, int freq) {
        this.character = character;
        this.freq = freq;
    }
}

class Pair1 {

}

class SingletonClass {
    private static SingletonClass obj;

    // Private constructor
    private SingletonClass() {
        System.out.println("In singleton class");
    }

    public static SingletonClass getInstance() {
        if (obj == null) {
            return obj = new SingletonClass();
        }
        return obj;
    }
}

abstract class AbstractClass {
    // Constructor
    AbstractClass() {
    }

    // Abstract method
    abstract void show();

    // Concrete method
    void display() {

    }
}

interface Interface1 {
    // This is implicitly public, static, and final
    int a = 10;

    // only abstract class
    void show();
}

interface Interface2 {
    void show();
}

class Class1 implements Interface1, Interface2 {
    public void show() {
        System.out.println("In class 1");
    }

    
}

public class Test {

    static class XYZ {

    }

    void show() {
        System.out.println("From Test Class");
    }

    public static void main(String[] args) {

        // Abs1 abs1 = new Abs1();




        // Map<Integer, Integer> map = new HashMap<>();
        
        // ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(4,2,7,2,8,5,2,1));
        // ArrayList<Integer> newList = new ArrayList<>();

        // String str = "23121";
        // StringBuilder strb = new StringBuilder(str);

        // String output = "779547853567944361646796413529854316337622379127456186173866698141925185953533154694734739531332878";
        // String expected = "779547853679443616467964135298543163376223791274561861738666981419251859535331546947347395531332878";

        // BigInteger num1 = new BigInteger(output);
        // BigInteger num2 = new BigInteger(expected);

        // BigInteger subs = num1.subtract(num2);

        // System.out.println(subs.longValue());

        // map.put(1,1);
        // map.put(2,2);
        // map.put(3,3);
        // map.put(4,4);
        // System.out.println(map);

        // newList.add(1);
        // newList.add(2);
        // newList.add(3);
        // newList.add(4);

        // Iterator itr = newList.iterator();

        // while(itr.hasNext()) {
        //     System.out.println(itr.next());
        // }


        


        Test obj = new Test();






    }


    





    static String correctedString(String str) {
        int lowerCount = 0;
        int upperCount = 0;
        for(char ch : str.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z') {
                upperCount++;
            } else if(ch >= 'a' && ch <= 'z') {
                lowerCount++;
            }
        }

        if(upperCount > lowerCount) {
            return str.toUpperCase();
        } else {
            return str;
        }
    }






    static boolean equalFrequency(String word) {
        int[] freq = new int[26];

        boolean removed = false;
        for(char ch : word.toCharArray()) {
            if(freq[ch-'a'] >= 1) {
                if(removed == false) {
                    removed = true;
                } else {
                    return false;
                }
            }
            freq[ch-'a']++;
        }

        return true;
    }

    static int fib(int n) {
        if(n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);


        // int n1 = 0;
        // System.out.print(n1 + " ");
        // int n2 = 1;
        // System.out.print(n2 + " ");
        // for (int i = 2; i < n; i++) {
        //     int n3 = n1 + n2;
        //     System.out.print(n3 + " ");

        //     n1 = n2;
        //     n2 = n3;
        // }
    }

    protected static String getSpacedSentence(String str, int[] spaces) {
        String result = "";
        int n = str.length();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx < spaces.length && i == spaces[idx]) {
                result += " ";
                idx++;
            }
            result += str.charAt(i);
        }

        return result;

    }

    static int lengthOfLongestSubstring(String s) {
        int maxLen = 1;
        Map<Character, Integer> map = new LinkedHashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                System.out.println(map);
                System.out.println(maxLen);
                maxLen = Math.max(maxLen, getSubLen(map));

                // map.remove(ch);
                map.put(ch, i);
            } else {
                map.put(ch, i);
            }
        }

        maxLen = Math.max(maxLen, getSubLen(map));
        return maxLen;
    }

    static int getSubLen(Map<Character, Integer> map) {
        int maxLen = 1;

        int len = 1;
        int lastIdx = -2;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((lastIdx + 1) == entry.getValue()) {
                len++;
                lastIdx = entry.getValue();
            } else {
                maxLen = Math.max(maxLen, len);

                len = 1;
                lastIdx = entry.getValue();
            }
        }

        maxLen = Math.max(maxLen, len);
        return maxLen;
    }

    static int trap(int[] height) {
        int totalVolume = 0;
        int n = height.length;

        int lastIdx = 0;
        int curr = 1;

        // while(curr < n && height[curr] == 0) {
        // lastIdx++;
        // curr++;
        // }

        while (curr < n) {
            while (curr < n && (height[curr - 1] > height[curr]) && (height[curr] < height[lastIdx])) {
                curr++;
            }
            if (curr == n) {
                break;
            }

            int volume = getVolume(height, lastIdx, curr);

            totalVolume += volume;

            lastIdx = curr;
            curr++;
        }

        return totalVolume;
    }

    static int getVolume(int[] height, int from, int to) {
        int distance = to - from - 1;
        int maxHeight = Math.min(height[from], height[to]);

        int totalArea = distance * maxHeight;

        int occupiedArea = 0;
        for (int i = from + 1; i < to; i++) {
            occupiedArea += height[i];
        }

        int volume = totalArea - occupiedArea;
        return volume;
    }

    static int longestPalindrome() {
        return 0;
    }

    static String longestPalindrome(String s) {
        int n = s.length();

        String result = String.valueOf(s.charAt(0));
        int resLen = 1;

        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;

            while (start >= 0 && end <= n - 1) {
                if (s.charAt(start) != s.charAt(end)) {
                    break;
                }
                start--;
                end++;
            }

            int len = end - (start + 1);
            if (len > resLen) {
                resLen = len;
                result = s.substring(start + 1, end);
            }
        }

        return result;
    }

    static int countPairs(int n, int k, int arr[]) {
        // Code Here.
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] == arr[j]) && ((i + j + 2) % k == 0)) {
                    count++;
                }
            }
        }

        return count;
    }

    static void waterPlant(int[] arr, int n, int maxWater) {
        int totalSteps = 0;

        int i = 0;
        while (i < n) {
            int can = maxWater;
            while (i < n && arr[i] <= can) {
                int waterReq = arr[i];

                can -= waterReq;
                waterReq = 0;
                arr[i] = waterReq;
                i++;
            }

            if (i < n) {
                totalSteps += (i * 2);
            } else {
                totalSteps += i;
            }
        }

        System.out.println(totalSteps);
    }

    static void check(int... a) {
        System.out.println(Arrays.toString(a));
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