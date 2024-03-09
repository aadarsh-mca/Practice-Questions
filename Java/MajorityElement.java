import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    
    public static void main(String[] args) {
        /**
         * Majority Element I (n/2)
         */
        int[] nums1 = {2,2,1,3,1,1,3,1,1};
        // int[] nums1 = {7,7,5,7,5,1};
        /**
         * Majority Element II (n/3)
         */
        // int[] nums2 = {3,2,3};
        int[] nums2 = {1,2,3,3,2,1,1,2,3,3,2,3,1,1};

        System.out.println("Majority Element I (optimal) : " + optimal_majorityElement_1(nums1));
        
        System.out.println("Majority Element II (brute) : " + brute_majorityElement_2(nums2));
        System.out.println("Majority Element II (optimal) : " + optimal_majorityElement_2(nums2));
    }

    /**
     * Brute force approach,
     * using nested loop.
     * 
     * <p>Compare and count each element one by one
     * 
     * <p>Time complexity : {@code O(n²)}
     * <p>Space complexity : {@code O(1)}
     */


     

    /**
     * Hashing approach,
     * using HashMap.
     * 
     * <p>Time complexity : {@code O(n + (n log n))}
     * <p>Space complexity : {@code O(n)}
     * 
     * @param nums {@code int[]}
     * @return {@code int} (Majority element)
     */
    static int hashing_majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n/2) {
                return entry.getKey();
            }
        }
        return -1;
    }



    /**
     * Optimal approach,
     * using Moore Voting Algorithm.
     * 
     * <p>Time complexity : {@code O(n)}
     * <p>Space complexity : {@code O(1)}
     * 
     * @param nums {@code int[]}
     * @return {@code int} (Majority element)
     */
    public static int optimal_majorityElement_1(int[] nums) {
        /**
         * Initialize 2 variable,
         * one is key to store
         */
        int key = nums[0];
        int counter = 0;
        
        for(int num : nums) {
            if(counter <= 0) {
                key = num;
                counter = 1;
            } else if (key == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return key;
    }



    /**
     * Majority Element II (n/3)
     */

    /**
     * Brute force approach
     * Either use HashMap or Sorting...
     * 
     * <p>Intution is to sort the array first,
     * and then count element one by one.
     * 
     * <p>Time complexity : {@code O(n + n log n)}
     * <p>Space complexity : {@code O(1)}
     * 
     * @param nums {@code int[]}
     * @return list {@code List<Integer>} list of majority elements
     */
    static List<Integer> brute_majorityElement_2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        int n3 = nums.length / 3;

        int key = nums[0];
        int counter = 0;
        for(int num : nums) {
            if(num == key) {
                counter++;
                if(counter > n3 && list.contains(key) == false) list.add(num);
            } else {
                key = num;
                counter = 1;
            }
        }
        return list;
    }


    /**
     * Optimal approach for element more than n/3
     * 
     * <p>Intution is similar (extended version) of Moore Voting Algo.
     * 
     * <p>Time complexity : {@code O(2n)}
     * <p>Space complexity : {@code O(1)}
     * 
     * 
     * @param nums {@code int[]}
     * @return list {@code List<Integer>} list of majority elements
     */
    static List<Integer> optimal_majorityElement_2(int[] nums) {
        /**
         * Replicating the algo for two candidate key, instead of one.
         */
        List<Integer> list = new ArrayList<>();
        int key1 = Integer.MIN_VALUE;
        int counter1 = 0;
        int key2 = Integer.MIN_VALUE;
        int counter2 = 0;

        for(int num : nums) {
            if(num == key1 && num != key2) {
                counter1++;
            } else if(num == key2 && num != key1) {
                counter2++;
            } else if(counter1 == 0) {
                key1 = num;
                counter1 = 1;
            } else if(counter2 == 0) {
                key2 = num;
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }

        /**
         * After replicating Moore voting Algo,
         * just iterate over array once, 
         * to count the actual frequency
         */
        counter1 = 0;
        counter2 = 0;
        for(int num : nums) {
            if(num == key1) counter1++;
            if(num == key2) counter2++;
        }

        /**
         * And finally verifiying whether,
         * key1 and key2 are majority or not
         */
        if(counter1 > nums.length / 3) list.add(key1);
        if(counter2 > nums.length / 3) list.add(key2);
        
        return list;
    }

}
