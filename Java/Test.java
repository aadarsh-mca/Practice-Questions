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

public class Test {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 3;
        // int max = n*2-1;
        
        // int max = n*2;
        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print(j);
        //     }
        //     int spaces = max - (i*2);
        //     for(int j=1; j<=spaces; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j=i; j>=1; j--) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j + " ");
            }
            int spaces = 2*(n-i);
            for(int j=1; j<=spaces; j++) {
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        // int spaces = 2*(n-1);
        // for(int i=1; i<=n; i++){
        //     //number
        //     for(int j=1; j<=i;j++){
        //         System.out.print(j+" ");
        //     }
        //     //spaces
        //     for(int j=1; j<=spaces;j++){
        //         System.out.print(" ");
        //     }
        //     //number
        //     for(int j=i; j>=1; j--){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        //     spaces -= 2;
        // }


        // numberCrown(3);


    }

    public static void numberCrown(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print((j+1)+" ");
            }
            for(int k = 0; k < 2*(n-1-i); k++) {
                System.out.print(" ");
            }
            for(int l = 0; l < i + 1; l++) {
                System.out.print((i+1-l)+" ");
            }
            System.out.println();
        }
    }


}