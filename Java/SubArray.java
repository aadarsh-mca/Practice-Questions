import java.util.HashMap;

public class SubArray {
    
    public static void main(String[] args) {
        /**
         * Positive number array
         */
        // int[] arr = {8, 15, 17, 0, 11};
        // int k = 17;
        // int[] arr = {1,2,1,3};
        // int k = 2;
        // int[] arr = {1, 2, 3, 1, 1, 1, 1};
        // int k = 3;
        // int[] arr = {1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0};
        // int k = 6;

        /**
         * Negative number array
         */
        int[] arr = {-1, 0, 1, 1, -1, -1, 0};
        int k = 0;
        // int[] arr = {100000, -999812, -218};
        // int k = 0;
        int n = arr.length;
        
        System.out.println("Brute for all : " + brute_longestSubArray(arr, n, k));
        System.out.println("Optimal for positive : " + optimalForPositive_longestSubArray(arr, n, k));
        System.out.println("Optimal for negative & Better for positive : " + optimalForNegative_longestSubArray(arr, n, k));

        System.out.println("Brute (count sub-array with sum k) : " + brute_countOfSubArray(arr, n, k));
        System.out.println("Optimal (count sub-array with sum k) : " + optimal_countOfSubArray(arr, n, k));
    }

    /**
     * Brute force approach (for All positive/negative),
     * using nested loop
     * 
     * Simply iterate over the array again and again 
     * to find the sub array with sum == k
     * 
     * <p>Time complexity : {@code O(n²)} <- {Worst case}
     * <p>Space complexity : {@code O(1)}
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of {@code array}
     * @param k {@code int}
     * @return {@code int} length of sub-array
     */
    static int brute_longestSubArray(int[] arr, int n, int k) {
        int maxLen = 0;
        for(int i=0; i<n; i++) {
            
            /**
             * Initialize variable length and sum with 0
             * for each iteration
             */
            int length = 0;
            int sum = 0;
            
            for(int j=i; j<n; j++) {

                /**
                 * add each array element in sum
                 * and increase the length by 1
                 */
                sum += arr[j];
                length++;

                /**
                 * if sum == k
                 * then replace the maxLength by length,
                 * only if length is greater than maxLength
                 */
                if(sum == k) {
                    maxLen = Math.max(maxLen, length);
                }
            }
        }
        return maxLen;
    }


    /**
     * Optimal approach (only for positive),
     * using Two Pointer,
     * 
     * In this method, 
     * we will be taking two pointer,
     * and shrinkig the size of array accordingly.
     * 
     * <p>But in this method,
     * we will not be able to consider negative values,
     * because we are shrinking the sub-array, 
     * as soon as it the totalSum become grater than k
     * 
     * <p>Time complexity : {@code O(n)} and Worst Case {@code O(2n)}
     * <p>Space complexity : {@code O(1)}
     */
    static int optimalForPositive_longestSubArray(int[] arr, int n, int k) {
        int maxLength = 0;
        long totalSum = 0;
        int left = 0;
        int right = 0;

        /**
         * First loop to iterate over the array,
         * and to move 'right' pointer
         */
        for( ; right < n; right++) {

            /**
             * Add array element to totalSum
             */
            totalSum += arr[right];

            /**
             * Check if total sum is more than required sum
             * 
             * if yes, 
             * then move left pointer until it become equal to k,
             * or it reaches the right pointer.
             * 
             * Using this we are able to find the sub-array,
             * between left and right,
             * having sum == k.
             */
            if(totalSum > k) {
                while(left < right && totalSum > k) {
                    totalSum -= arr[left];
                    left++;
                }
            }

            /**
             * Check if totalSum is equal to k in each case,
             * even after reducing the size of sub-array, 
             * by moving left pointer.
             * 
             * [4,1,2,0,0,1,3,6,0,1]  k=3
             *  ⁰ ¹ ² ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹
             *    ^       ^
             *   left   right
             */
            if(totalSum == k) {

                /**
                 * Length of sub-array will be calculated as
                 * right - left + 1
                 * eg. 5 - 1 = 4 + 1 => 5
                 */
                int len = right - left + 1;
                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }



    /**
     * Optimal approach (for negative),
     * Better approach (for positive),
     * using HashMap
     * 
     * <p>This is the most optimal method, 
     * if the array contains negative values,
     * because it will condsider the negative values also,
     * by adding all elements to totalSum, 
     * and saving it in hashmap for future references
     *
     * <p>else if array contains only positive values, then
     * the two pointer approach will be considered as the most optimal approach.
     * 
     * <p>Time complexity : {@code O(n)} and Worst Case {@code O(n²)}
     * <p>Space complexity :{@code O(n)}
     */
    static int optimalForNegative_longestSubArray(int[] arr, int n, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        int maxLength = 0;
        long totalSum = 0;

        for(int i=0; i<n; i++) {
            
            /**
             * As usual, 
             * each element is added to totalSum.
             */
            totalSum += arr[i];

            /**
             * The remaining sum is calculated by
             * assuming if we minus 'k' from totalSum,
             * then the remaining sum must be one of the totalSum calculated previously.
             * 
             * If found,
             * then we finally found a sub-array whose sum is k
             */
            long remainPrevSum = totalSum - k;

            /**
             * If totalSum is equal to k, 
             * then this will surely be the longest sub-array,
             * no need to check for any other sub-array;
             */
            if(totalSum == k) {
                maxLength = Math.max(maxLength, i+1);

            /**
             * else,
             * if we found the remaining sum in map,
             * then we found another sub-array whose sum is k
             */
            }else if(map.containsKey(remainPrevSum)) {
                int prevSumIndex = map.get(remainPrevSum);
                maxLength = Math.max(maxLength, i-prevSumIndex);
            }

            /**
             * If we find any 'totalSum' key already mapped, 
             * then we will not update its value;
             * 
             * This will occur in case of multiple 0 or neagtive values,
             *              [1,2,-2,2,0,0,0]  k = 3
             * totalSum ->   ¹ ³  ¹ ³ ³ ³ ³
             */
            if(!map.containsKey(totalSum)) {
                map.put(totalSum, i);
            }
        }
        return maxLength;
    }




    /**
     * 
     */


    /**
     * Brute force approach,
     * Find the count of sub-array with sum k
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of arr
     * @param k {@code int} sum
     * @return {@code int} numbers of sub-array
     */
    static int brute_countOfSubArray(int[] arr, int n, int k) {
        int nSubArrays = 0;

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j < n; j++) {
                sum += arr[j];
                if(sum == k) {
                    nSubArrays++;
                }
            }
        }
        return nSubArrays;
    }

    /**
     * Optimal approach,
     * Find the count of sub-array with sum k
     * 
     * Intution is same as optimal approach of(prefixSum)
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of arr
     * @param k {@code int} sum
     * @return {@code int} numbers of sub-array
     */
    static int optimal_countOfSubArray(int[] arr, int n, int k) {
        int nSubArrays = 0;

        /**
         * Storing all the 'sum' in map as key,
         * and the 'occurence' of that sum as value
         */
        HashMap<Long, Integer> sumMap = new HashMap<>();
        long sum = 0;
        sumMap.put(sum, 1); // or if(sum == k) nSubArray++;

        for(int i=0; i<n; i++) {
            sum += arr[i];

            /**
             * k = 2
             * arr -> [1,1,1,0,1,1]
             * sum ->  ¹ ² ³ ³ ⁴ ⁵
             * if sum = 5, and k = 2
             * then the map must have prefixSum = 3 (5-2)
             * and if we found 3 in map, 
             * than that mean we found the sub-array with sum k (i.e. 2),
             * along with the times of occurence of that sub-array
             */
            long prefixSum = sum - k;
            if(sumMap.containsKey(prefixSum)) {
                int occurence = sumMap.get(prefixSum);
                nSubArrays += occurence;
            }

            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return nSubArrays;
    }

}
