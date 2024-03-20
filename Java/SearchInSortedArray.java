import java.util.ArrayList;
import java.util.Arrays;

public class SearchInSortedArray {
    
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5,6,7,8,9};
        // int[] arr = {7,8,9,1,2,3,4,5,6};
        // int[] arr = {5,6,7,8,9,1,2,3,4};
        // int[] arr = {2,3,4,5,6,7,8,9,1};
        // int target = 1;
        int[] arr = {3,1};
        int target = 1;

        //¹²³⁴

        System.out.println("Optimal 1 (log n) : " + optimal1_searchInDistinctArray(arr, target));
        System.out.println();
        System.out.println("Optimal 2 (2 log n) : " + optimal2_find_pivotIndex_thenSearch(arr, target));
    }

    /**
     * Optimal approach,
     * 
     * <p>Time Complexity : {@code O(log n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * <p>Finding sorted part of the array,
     * and then searching in that sorted half.
     * 
     * @param nums
     * @param target
     * @return
     */
    static int optimal1_searchInDistinctArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = (low + high) / 2;

            /**
             * If mid == target
             * then we found the target
             */
            if(nums[mid] == target) {
                return mid;

            /**
             * If left is less than or equal to mid,    (eg. in this arra [3,1])
             * that mean this part of array is in sorted manner.
             */
            } else if(nums[low] <= nums[mid]) {
                
                /**
                 * When first half of array is in sorted manner,
                 * the check whether target lie in first half of array or not ?
                 * 
                 * If yes, then eliminate second part of array.
                 */
                if((nums[low] <= target && target < nums[mid])) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }

            /**
             * If left is more than mid,
             * that mean this part of array is in un-sorted manner,
             * 
             * Therefore, 
             * the other part of array must be in sorted manner.
             */
            } else { // else if(nums[mid] < nums[right])

                /**
                 * When second half of array is in sorted manner,
                 * the check whether target lie in second half of array or not ?
                 * 
                 * If yes, then eliminate first part of array.
                 */
                if(nums[mid] < target && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }





    
    /**
     * Optimal 2 approach,
     * 
     * <p>Time Complexity : {@code O(log n + log n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * <p>First find the pivot index,
     * the index from where the array is rotated.
     * 
     * @param nums
     * @param target
     * @return
     */
    static int optimal2_find_pivotIndex_thenSearch(int[] nums, int target) {
        /**
         * Pivot Index is the index of element 
         * which should be at first place,
         * but because array is sorted that element is moved to other index.
         * 
         * Using Pivot Index,
         * we can easily find both of the sorted array.
         * 
         * Array before Pivot Index will be first sorted array,
         * and
         * Array from Pivot Index till end will be second sorted array.
         */
        int pivotIndex = 0;

        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = (low + high) / 2;

            /**
             * [7,8,9,1,2,3,4,5,6]     [4,5,6,7,8,9,1,2,3]
             *  ^       ^               ^       ^
             *  0      mid              0      mid
             * 
             * If first element is more than mid,
             * this mean right part is sorted, and Pivot Index will be on left.
             */
            if(nums[0] > nums[mid]) {
                pivotIndex = mid;
                high = mid-1;

            /**
             * If first element is less than mid,
             * this mean left part is sorted, and Pivot Index will be on right.
             */
            } else {
                low = mid+1;
            }
        }
        System.out.println("Pivot-Idx : " + pivotIndex);

        /**
         * As we have both the sorted array,
         * Now check in which array does the target lie.
         * 
         * If arr[0] <= target <= pivotIndex-1
         * this mean target lie in first sorted array. 
         */
        if(pivotIndex != 0 && (nums[0] <= target && target <= nums[pivotIndex-1])) {
            return binarySearch(nums, 0, pivotIndex-1, target);

        /**
         * If pivotIndex <= target <= right
         * this mean target lie in second sorted array.
         */
        } else {
            return binarySearch(nums, pivotIndex, nums.length-1, target);
        }
    }

    /**
     * Normal Binary Search...
     */
    static int binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) {
                return mid;
            } 
            
            if(target < arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
    
}
