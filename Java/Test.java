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

interface int1 {
    abstract void show();
}
interface int2 {
    abstract void show();
}
interface int3 extends int1, int2 {

}

class Int implements int3 {
    public void show() {
    }
}

public class Test {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);   //   6    3 2 54 7 4 2
        
        check(10, 20, 30, 40, 50);

        String pwd = "Aadarsh1999@";
        System.out.println("Original Password: " + pwd);
        if(isValidPwd(pwd)) {
            int shiftValue = -1;
            System.out.println("Encoded Password: " + getEncodedPwd(pwd, shiftValue));
        } else {
            System.out.println("Error!");
        }
    }

    static void check(int... a) {
        System.out.println(Arrays.toString(a));
    }

    static boolean isValidPwd(String pwd) {
        int n = pwd.length();
        if(n < 8) {
            return false;
        }

        boolean oneDigit = false;
        boolean specialChar = false;
        boolean uppercase = false;
        boolean lowercase = false;

        for(char ch : pwd.toCharArray()) {
            if(ch >= 48 && ch <= 57) {
                oneDigit = true;
            }
            if(ch >= 65 && ch <= 90) {
                uppercase = true;
            }
            if(ch >= 97 && ch <= 122) {
                lowercase = true;
            }
            if(ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '&' || ch == '!') {
                specialChar = true;
            }
        }

        if(oneDigit && specialChar && uppercase && lowercase) {
            return true;
        } else {
            return false;
        }
    }

    static String getEncodedPwd(String pwd, int shiftValue) {
        StringBuilder strb = new StringBuilder();

        for(char ch : pwd.toCharArray()) {
            char encodedChar = (char)((int)ch + shiftValue);
            strb.append(encodedChar);
        }

        return strb.toString();
    }

    static String removeBracket(String inputStr) {
        int n = inputStr.length();
        
        String result = "";

        for(int i=0; i<n; i++) {
            char ch = inputStr.charAt(i);   // a + ( ( b - c ) + d )
            if(ch != '(' && ch != ')') {
                result += ch;
            }
        }

        // System.out.println(result);
        return result;
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