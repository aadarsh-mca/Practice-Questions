import java.util.HashMap;

public class SubArray<E> {
    
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

        /**
         * Negative number array
         */
        int[] arr = {-1, 0, 1, 1, -1, -1, 0};
        int k = 0;
        // int[] arr = {100000, -999812, -218};
        // int k = 0;
        int n = arr.length;
        
        System.out.println(brute_longestSubArrayPositive(arr, n, k));
    }

    /**
     * Brute force approach,
     * { only positive array }
     * using nested loop
     * 
     * Time complexity : O(n²) <- {Worst case}
     * Space complexity : O(1)
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of {@code array}
     * @param k {@code int}
     * @return {@code int} length of sub-array
     */
    static int brute_longestSubArrayPositive(int[] arr, int n, int k) {
        int maxLen = 0;
        for(int i=0; i<n; i++) {
            int length = 0;
            int sum = 0;
            int j=i;
            while(j<n && sum <= k) {
                sum += arr[j];
                length++;
                if(sum == k) {
                    maxLen = Math.max(maxLen, length);
                }
                j++;
            }
        }
        return maxLen;
    }


    /**
     * Better approach,
     * 
     * 
     */
    static int better_longestSubArray(int[] arr, int n, int k) {
        int maxLength = 0;

        

        return maxLength;
    }

}
