public class KMissingNumber {
    
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        // int k = 12;
        // int[] arr = {1,2,3,4};
        // int k = 2;
        // int[] arr = {5};
        // int k = 2;

        System.out.println("Brute : " + brute_kMissingNumber(arr, k) + " is missing.");
        System.out.println("Optimal : " + optimal_kMissingNumber(arr, k) + " is missing.");
    }

    /**
     * Brute force approach, 
     * 
     * Intution is : 
     *          index :  ⁰  ¹  ²  ³   ⁴
     *                  [2, 3, 4, 7, 11]    k = 5
     * countOfMissing :  1  1  1  3   6 
     *  
     * Observing above condition, 
     * we can clearly say that there are 3 numbers that are missing before 7[³].
     * 
     * At [³] there is 7, 
     * But there should be number 4,
     * So, if we add 'k' in 4,
     * we will get the number that should be at 'k + 4',
     * because the numbers are in ascending order. 
     * 
     * <p>Time Complexity : {@code O(n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]}
     * @param k {@code int} position of missing number
     * @return {@code int} missing number
     */
    static int brute_kMissingNumber(int[] arr, int k) {
        int n = arr.length;
        for(int i=0; i<n; i++) {

            /**
             * Here we check the number that is at i,
             * eg: 7[³],
             * but [³] should have 4,
             */
            int numAt_i = arr[i];
            int numShouldBeAt_i = i+1;

            /**
             * Now we can calculate that how many numbers are missing before 7[³].
             * eg: 7 - 4 = 3.
             * There are 3 number missing before 7[³].
             */
            int countOfMissing = numAt_i - numShouldBeAt_i;

            /**
             * If we have Count of Missing Number less than k,
             * this mean the missing number will be ahead of current number.
             */
            if(countOfMissing >= k) {
                return (numShouldBeAt_i -1) + k;
            }
        }
        return n+k;
    }


    /**
     * Optimal approach,
     * 
     * Intution is : 
     * It is similar to brute force,
     * the only difference is that, 
     * we are searching the number through binary search.
     * 
     * <p>Time Complexity : {@code O(log n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]}
     * @param k {@code int} position of missing number
     * @return {@code int} missing number
     */
    static int optimal_kMissingNumber(int[] arr, int k) {

        /**
         * Search space will be between 0 to the maximum number the array is having.
         * As we know that the array is sorted in ascending order,
         * this mean max will be at the end,
         * so,
         * low = 0, and
         * high = n-1.
         */
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high) {
            int mid = (low + high) / 2;

            /**
             * Here we check the number that is at i,
             * eg: 7[³],
             * but [³] should have 4,
             */
            int numAtMid = arr[mid];
            int numShouldBeAtMid = mid +1;

            /**
             * Now we can calculate that how many numbers are missing before 7[³].
             * eg: 7 - 4 = 3.
             * There are 3 number missing before 7[³].
             */
            int countOfMissing = numAtMid - numShouldBeAtMid;

            /**
             * If we have Count of Missing Number less than k,
             * this mean the missing number will be ahead (-->) of current number,
             * so, low = mid+1;
             * 
             * else if Count of Missing Number more than or equal to k,
             * this mean the missing number will be prior (<--) of current number,
             * so, high = mid-1;
             */
            if(countOfMissing < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        /**
         *          index :  ⁰  ¹  ²  ³   ⁴
         *                  [2, 3, 4, 7, 11]    k = 5
         * countOfMissing :  1  1  1  3   6 
         *                            ^   ^
         *                         high   low
         *  
         * At the end of binary search, 
         * low is pointing at the number more than k, and
         * high is pointing at the number less than k.
         * 
         * At low [⁴] there is 11, 
         * But there should be number 5,
         * So, if we add 'k' in ⁴,
         * we will get the number that should be at 'k + ⁴',
         * because the numbers are in ascending order. 
         */
        return low + k;
    }

}
