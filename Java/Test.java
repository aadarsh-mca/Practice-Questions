import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    
    public static void main(String[] args) {
        Math.sqrt(0);
        Math.round(0);

        ArrayList<Integer> intList = new ArrayList<>();
        StringBuilder stb = new StringBuilder();

        Long A = (long)10, B = (long)5;

        Long[] lcmGcd = new Long[2];
        Long min = Math.min(A, B);
        Long max = Math.max(A, B);

        System.out.println(min);
        System.out.println(max);
        
        // for(long i=2; i<=min; i++) {
        //     if(A % i == 0 && B % i == 0) {
        //         lcmGcd[1] = i;
        //     }
            
        //     if(min % i == 0 && max % i == 0) {
        //         lcmGcd[0] = lcmGcd[0] * i;
        //         min /= i;
        //         max /= i;
        //         continue;
        //     } else if(min % i == 0) {
        //         lcmGcd[0] = lcmGcd[0] * i;
        //         min /= i;
        //     } else if(max % i == 0) {
        //         lcmGcd[0] = lcmGcd[0] * i;
        //         max /= i;
        //     }
        // }
        
        // if(max > 1) {
        //     lcmGcd[0] = lcmGcd[0] * max;
        // }
        
        System.out.println(Arrays.toString(lcmGcd));

    }

}