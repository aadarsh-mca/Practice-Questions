import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutive {
    
    public static void main(String[] args) {
        // int[] arr = {5,2,4,1,3};
        // int[] arr = {5,8,2,4,1,3};
        // int[] arr = {1,2,3,4,5,8,9,10,11,12,13,14,15};
        int[] arr = {100,4,200,1,3,2};
        // int[] arr = {15,6,2,1,16,4,2,29,9,12,8,5,14,21,8,12,17,16,6,26,3};

        // System.out.println("Brute : " + brute_longestConsecutive(arr));
        // System.out.println("Better : " + better_longestConsecutive(arr));
        System.out.println("Optimal : " + optimal_longestConsecutive(arr));
    }

    /**
     * Brute force approach,
     * 
     * <p>Using TreeSet to sort and store unique element,
     * then iterating over element to check continuity.
     * 
     * <p>Time Complexity : {@code O((n log n) + n)}
     * <p>Space Complexity : {@code O(n)}
     * 
     * @param nums {@code int[]}
     * @return maxCount {@code int}
     */
    static int brute_longestConsecutive(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int num : nums) {
            treeSet.add(num);
        }

        int maxCount = 0;
        
        int count = 1;
        int prev = treeSet.pollFirst();
        for(int num : treeSet) {
            if(prev+1 == num) {
                count++;
                prev = num;
            } else {
                maxCount = Math.max(maxCount, count);
                prev = num;
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    /**
     * Better approach,
     * Two pointer approach
     * 
     * <p>Better in term of time,
     * Optimal in term of space. 
     * 
     * <p>Time Complexity : {@code O((n log n) + n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param nums {@code int[]}
     * @return maxCount {@code int}
     */
    static int better_longestConsecutive(int[] nums) {
        int n = nums.length;
        
        /**
         * Sorting the array
         */
        Arrays.sort(nums);
        
        int maxCount = 0;
        int count = 1;

        /**
         * Store the first element of array,
         * and start looping from next element.
         */
        int prev = nums[0];

        /**
         * Prev is left pointer,
         * i is right pointer.
         */
        for(int i=1; i<n; i++) {
            int curr = nums[i];

            /**
             * If curr element is equal to prev
             * simply skip the iteration,
             * as we are not interest in equal elements.
             */
            if(prev == curr) {
                continue;

            /**
             * If curr element is equal to prev+1,
             * i.e. in sequence,
             * increase the count and 
             * store curr element in prev for further sequence check.
             */
            } else if(prev+1 == curr) {
                count++;
                prev = curr;

            /**
             * If curr element is not equal to prev+1,
             * i.e. not in sequence because of gap of 2 or more number,
             * simply compute maxCount and reset the prev and count value. 
             */
            } else {
                maxCount = Math.max(maxCount, count);
                prev = curr;
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    /**
     * Optimal approach,
     * 
     * <p>Put everything in {@code SET} for unique elements,
     * then iterate over set and check if we have element less than current element,
     * 
     * <p>If yes, that mean the current element will not be the starting element of sequence,
     * <p>If no, that mean the current element is the starting element of sequence,
     * and keep checking for further element in {@code SET}.
     * 
     * <p>Time Complexity : {@code O(n + 2n)}
     * <p>Space Complexity : {@code O(n)}
     * 
     * @param nums {@code int[]}
     * @return maxCount {@code int}
     */
    static int optimal_longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        /**
         * Adding every unique element in set.
         */
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        for(int num : set) {
            int curr = num;
            int count = 1;

            /**
             * If element less than current element found, 
             * that mean the current element is not the starting element of sequence.
             * So simply skip further statements.
             * 
             * Time Complexity : O(n)
             */
            if(set.contains(curr - 1)) {
                continue;
            } 

            /**
             * Run a loop till we find element more than the current element,
             * this ensure the continuity of sequence.
             * Increase te count along with each iteration
             * 
             * Time Complexity : O(2n)
             */
            while(set.contains(curr + 1)) {
                count++;
                curr = curr + 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
