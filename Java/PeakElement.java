public class PeakElement {
    
    public static void main(String[] args) {
        // int[] arr = {1,2,3,1};
        int[] arr = {0,1,2,3,4,5,6,7,8,1};
        // int[] arr = {1,2,1,3,5,6,4};
        // int[] arr = {2,1,3};
        // int[] arr = {1,2};
        // int[] arr = {1};

        /**
         * Brute force will lead to O(n) Time complexity,
         * and can be executed using linear search
         */
        System.out.println("Optimal 1 : " + arr[findPeakElement(arr)]);
    }

    /**
     * Optimal approach,
     * 
     * Intution is to find a dip in array,
     * (like we used find in next permutation problem).
     * 
     *  ⁰  ¹  ²  ³  ⁴  ⁵
     * [4, 5, 6, 7, 8, 1]
     *              ^
     *             / \
     *           /
     *         /
     *       /
     *     /
     * <p>From [⁰] to [⁴], 
     * elements are in increasing order,
     * this mean each element will be greater than its previous element, And
     * as soon as we encounter a dip in graph, i.e [⁵]
     * that mean [⁴] is the peak element,
     * because it is greater than previous element (increasing order), and 
     * next element is dip in graph (therefore it will be smaller).
     * 
     * <p>Now if we do it in binary search { O(log n) }, 
     * Firstly, 
     * 'mid' will be [²], and 
     * we can clearly observe that 'mid' is greater than 'mid-1', 
     * this mean it is in increasing slope/graph, and
     * this conclude that peak element will be on "right" side, beacause 'mid-1' is smaller.
     * 
     * <p>else if 'mid-1' is greater than 'mid',
     * this mean it is in decreasing slope/graph, and
     * this conclude that peak element will be on "left" side, beacause 'mid-1' is greater.
     * 
     * <p>Time Complexity : {@code O(log n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param nums {@code int[]} array containing peak element
     * @return index {@code int} index of peak element
     */
    static int findPeakElement(int[] nums) {
        int n = nums.length;

        /**
         * First check for edge case :
         *  1. only single element array
         *  2. first element in array is peak
         *  3. last element in array is peak
         */
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-2] < nums[n-1]) return n-1;
        
        /**
         * Now check for rest of the elements :
         * Shrink the search space by one-one element 
         * as we have already check them in above step
         * 
         * [1, 2, 1, 3, 4, 5, 6, 1]
         *  ⁰  ¹  ²  ³  ⁴  ⁵  ⁶  ⁷
         *     ^              ^    
         *    low            high
         */
        int low = 1;
        int high = n-2;
        while(low <= high) {
            int mid = (low + high) / 2;

            /**
             * if 'mid-1' < mid > 'mid+1', 
             * mid is the peak.
             */
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            /**
             * If 'mid-1' < 'mid', 
             * this mean mid is in increasing slope/graph,
             * therefore peak element will lie on 'right' side of array.
             */
            if(nums[mid-1] < nums[mid]) { // increasing order
                low = mid+1;

            /**
             * else the mid is in decreasing slope/graph,
             * therefore peak element will lie on 'left' side of array.
             */
            } else { // decreasing order
                high = mid-1;
            }
        }
        return 0;
    }
}
