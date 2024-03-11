import java.util.HashMap;

public class SubArray_with {
    
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 1, -1, -1, 0};
        int k = 0;
        // int[] arr = {100000, -999812, -218};
        // int k = 0;
        // int[] arr = {4,2,2,6,4};
        // int k = 6;
        // int[] arr = {1,2,3,2};
        // int k = 2;
        int n = arr.length;


        System.out.println("Sub-Array with SUM 'K' : ");
        System.out.println("Brute (sub-arrays with sum k) : " + brute_subArrayWithSum(arr, n, k));
        System.out.println("Optimal (sub-arrays with sum k) : " + optimal_subArrayWithSum(arr, n, k));

        System.out.println("\n\nSub-Array with XOR 'K' : ");
        System.out.println("Brute (sub-arrays with XOR k) : " + brute_subArrayWithXor(arr, k));
        System.out.println("Optimal (sub-arrays with XOR k) : " + optimal_subArrayWithXor(arr, k));
    }


    /**
     * Count no. of sub-array
     */

    /**
     * Brute force approach,
     * Find the count of sub-array with sum k
     * 
     * Time Complexity : {@code O(n²)}
     * Time Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of arr
     * @param k {@code int} sum
     * @return {@code int} numbers of sub-array
     */
    static int brute_subArrayWithSum(int[] arr, int n, int k) {
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
     * Intution is same as optimal approach of(prefixSum) from SubArray.java
     * 
     * Time Complexity : {@code O(n * log n)}
     * Time Complexity : {@code O(n)}
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of arr
     * @param k {@code int} sum
     * @return {@code int} numbers of sub-array
     */
    static int optimal_subArrayWithSum(int[] arr, int n, int k) {
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










    /**
     * Count no. of sub-array
     */

    /**
     * Brute force approach,
     * Find the count of sub-array with XOR k
     * 
     * Time Complexity : {@code O(n²)}
     * Time Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]}
     * @param k {@code int} XOR
     * @return {@code int} numbers of sub-array
     */
    static int brute_subArrayWithXor(int[] arr, int b) {
        int n = arr.length;
        int count = 0;
        
        for(int i=0; i<n; i++) {
            int xor = 0;
            for(int j=i; j<n; j++) {
                xor ^= arr[j];
                if(xor == b) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal approach,
     * Find the count of sub-array with sum k
     * 
     * Intution is same as optimal approach of(prefixSum) as above solutions
     * 
     * kXor = 6
     * [1, 3, 3, 3, 5]
     *  ⁰  ¹  ²  ³  ⁴
     *     ^     ^  ^
     *     |  1  | 2|
     *     ----------
     * 
     **¹ --> 3 ^ 5 = 6    //  3 ^ 3 ^ 3 ^ 5 = 6
     *   --> 0 ^ 1 = 1   //   1 ^ 3 ^ 3 = 1
     * 
     **² Therefore if we take sub-array [¹-⁴] & [³-⁴],
     * then the xor of their element will be 6 as shown above {**¹}
     * 
     * So, if we deduct xor = 1, i.e. [¹] & [¹-³],
     * we will get required sub-array shown above {**²}
     * 
     * 
     * Time Complexity : {@code O(n * log n)}
     * Time Complexity : {@code O(n)}
     * 
     * @param arr {@code int[]}
     * @param k {@code int} sum
     * @return {@code int} numbers of sub-array
     */
    static int optimal_subArrayWithXor(int[] arr, int b) {
        int n = arr.length;
        int count = 0;

        HashMap<Integer, Integer> xorMap = new HashMap<>();
        int xor = 0;
        // xorMap.put(k, 1);
        for(int i=0; i<n; i++) {
            xor ^= arr[i]; 
            if(xor == b) {
                count++;
            }

            int prefixXor = xor ^ b;
            if(xorMap.containsKey(prefixXor)) {
                count += xorMap.get(prefixXor);
            }

            xorMap.put(xor, xorMap.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

}
