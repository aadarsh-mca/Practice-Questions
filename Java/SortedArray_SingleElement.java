public class SortedArray_SingleElement {
    
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        // int[] arr = {3,3,7,7,10,11,11};
        // int[] arr = {1};
        // int[] arr = {1,1,2};
        // int[] arr = {1,2,2,3,3};

        System.out.println("Optimal my logic : " + optimal1_myLogic(arr));
        System.out.println("Optimal other logic : " + optimal2_otherLogic(arr));
    }

    /**
     * Optimal approach,
     * 
     * <p>Intution of binary search is to eliminate one part of array.
     * 
     * [1, 1, 2, 2, 3, 3, 4, 5, 5]
     *  ⁰  ¹  ²  ³  ⁴  ⁵  ⁶  ⁷  ⁸
     *              ^     ^    
     *             mid   unique  
     * 
     * <p>The array will be having odd numbers of elements,
     * because each element is twice, except one which is once.
     * 
     * If n=9, and if we divide array in 2 equal part,
     * left = 4, right = 4,  and 1 'mid'.
     * This mean left/right is having 2 duplicates, 
     * and 'mid' might be unique.
     * 
     * But if mid is not unique,
     * it's duplicate might belong with left or right.
     * 
     * Now if mid's duplicate is on left, there will become 5 element on left.
     * that mean 2 element is duplicate and 1 is unique,
     * so eliminate right part of array,
     * and continue searching in this left part of array, And Vice-Versa.
     * 
     * <p>Time Complexity : {@code O(log n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param nums {@code int[]}
     * @return unique element {@code int}
     */
    static int optimal1_myLogic(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = (low + high) / 2;

            /**
             * if mid != (left && right), this mean 'mid' is the unique element,
             * Also check whether there is single element in array, 
             * or unique element is at first/last index,
             * i.e. mid == low == right
             */
            if((mid == low && mid == high) || 
                (nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1])) 
            {
                return nums[mid];

            /**
             * If mid is not unique element :
             */
            } else {

                /**
                 * If Duplicate of mid is on left,
                 */
                if(nums[mid-1] == nums[mid]) {

                    /**
                     * Count number of element on left including 'mid'
                     */
                    int leftN = mid-low +1;

                    /**
                     * If 'left' is having odd number of element,
                     * that mean 'left' will be having unique element, including 'mid'
                     * so eliminate other part of array (i.e. right).
                     */
                    if(leftN % 2 != 0) {
                        high = mid;

                    /**
                     * If number of element is even,
                     * that mean 'left' will not be having unique element,
                     * so eliminate it (i.e. left) including 'mid'.
                     */
                    } else {
                        low = mid+1;
                    }

                /**
                 * If Duplicate of mid is on right,
                 */
                } else { // else (nums[mid] == nums[mid+1])

                    /**
                     * Count the number of element on right including 'mid'
                     */
                    int rightN = high-mid +1;

                    /**
                     * If 'right' is having odd number of element,
                     * that mean 'right' will be having unique element, including 'mid'
                     * so eliminate other part of array (i.e. left).
                     */
                    if(rightN % 2 != 0) {
                        low = mid;

                    /**
                     * If 'right' is having even number of element,
                     * that mean 'right' will not be having unique element,
                     * so eliminate it (i.e. right) including 'mid'.
                     */
                    } else {
                        high = mid-1;
                    }
                }
            }
        }
        return -1;
    }

    

    /**
     * Optimal approach,
     * 
     * <p>Intution is :
     * 
     * [1, 1, 2, 2, 3, 3, 4, 5, 5]
     *  ⁰  ¹  ²  ³  ⁴  ⁵  ⁶  ⁷  ⁸
     *                    ^         
     *                  unique   
     * <p>If we observe,
     * we can see that duplicate pairs, 
     * prior to unique element are in (even, odd) index format, and
     * pairs after unique element are in (odd, even) index format.
     * 
     * <p>So we can easily identify whether the unique element is on left side or right side.
     * 
     * <p>If 'mid' is not equal to 'mid-1' or 'mid+1',
     * that mean 'mid' is the unique element,
     * 
     * <p>else if check if mid's duplicate ('mid-1', 'mid') is in (even, odd) index format,
     * then unique element will lie on right side, and
     * 
     * <p>else if mid's duplicate ('mid', 'mid+1') is in (odd, even) index format,
     * then unique element will lie on left side.
     * 
     * <p>Time Complexity : {@code O(log n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param nums {@code int[]}
     * @return unique element {@code int}
     */
    static int optimal2_otherLogic(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = (low + high) / 2;

            /**
             * if mid != (left && right), this mean 'mid' is the unique element,
             * Also check whether there is single element in array, 
             * or unique element is at first/last index,
             * i.e. mid == low == right
             */
            if((low == mid && mid == high) || 
                (nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid])) 
            {
                return nums[mid];
            }

            /**
             * If mid is equal to 'mid-1',
             * therefore first element of pair will be 'mid-1'.
             */
            if(nums[mid-1] == nums[mid]) {

                /**
                 * If 'mid-1' is even, then unique will be on right,
                 * skip both the duplicate pairs and search on right (mid +1).
                 */
                if((mid-1) % 2 == 0) {
                    low = mid+1;

                /**
                 * else if 'mid-1' is odd, then unique will be on left,
                 * skip both the duplicate pairs and search of left (mid-1 -1).
                 */
                } else {
                    high = mid-1-1;
                }

            /**
             * If mid is equal to 'mid+1',
             * therefore first element of pair will be 'mid'.
             */
            } else {

                /**
                 * If 'mid' is even, then unique will be on right,
                 * skip both the duplicate pairs and search on right (mid+1 +1).
                 */
                if(mid % 2 == 0) {
                    low = mid+1+1;

                /**
                 * else if 'mid' is odd, then unique will be on left,
                 * skip both the duplicate pairs and search of left (mid -1).
                 */
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }


}
