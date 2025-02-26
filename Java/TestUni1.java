import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUni1 {
    /**
     * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
     * 
     */

     public static void main(String[] args) {
        // int[] arr = {1,2};
        // int limit = 3;
        // int[] arr = {3,2,2,1};
        // int limit = 3;
        // int[] arr = {3,5,3,4};
        // int limit = 5;
        // int[] arr = {2,1,1,2};
        // int limit = 3;
        int[] arr = {3,3,3,3,3};
        int limit = 3;

        System.out.println("Max boats required : " + minBoat(arr, limit));


        // int[] arr1 = {2, 2, 3, 1, 3, 2, 1, 1};
        int[] arr1 = {-5, 3, -5};  // -5:2  , 3:1
        // int[] arr1 = {3, 2, 2, 4, 1, 4};   //  3:1  ,2:2  , 4:2  ,1:1
        System.out.println("Number occurring more than n/3 time : " + moreThanN3(arr1));

     }

     static int minBoat(int[] people, int limit) {
        int n = people.length;
        int boats = 0;

        // First we will sort the array
        Arrays.sort(people);

        // Now the array is sorted into 
        // [1,1,3,2,2]
        //  f       l
        //    f   l
        //     fl

        // [1,1,2,2,3]   limit 3
        //  f       l
        //  f     l
        int firstPerson = 0;
        int lastPerson = n-1;

        while(firstPerson <= lastPerson) {
            int totalWeight = people[firstPerson] + people[lastPerson];

            if(totalWeight <= limit) {
                boats++;
                firstPerson++;
                lastPerson--;
            } else {
                boats++;
                lastPerson--;
            }
        }

        return boats;
     }

     // [2, 1, 2]
     // 

     // {2, 2, 3, 1, 3, 2, 1, 1}  n/3 = 2
     //  i         
     // 
     // key 1 = 2 
     // count1 = 1
     // key 2 = 1
     // count2 = 1

     // {2, 2, 3, 1, 3, 2, 1}   n/3 = 2
     //                       i
     // 
     // 2= 3
     // 3= 2
     // 1= 2
     //
     // key1 = 2
     // count1 = 1
     // key2 = 3
     // count2 = 0

     static List<Integer> moreThanN3(int [] arr) {
        int n = arr.length;
        int limit = n/3;
        List<Integer> result = new ArrayList<>();

        int key1 = 0, count1 = 0;
        int key2 = 0, count2 = 0;

        // {2, 2, 3, 1, 3, 2, 1, 1}  n/3 = 2
        //           i
        // key1 = 2  , count1 = 2
        // key2 = 3  , count2 = 1

        for(int i=0; i<n; i++) {
            int num = arr[i];  // 1

            if(count1 == 0 && num != key2) {
                key1 = num;
                count1 = 1;
            } else if(count2 == 0 && num != key1) {
                key2 = num;
                count2 = 1;
            } else if(num == key1) {
                count1++;
            } else if(num == key2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        if(count1 > 0) {
            result.add(key1);
        }
        if(count2 > 0) {
            result.add(key2);
        }
        
        return result;
     }

    
}
