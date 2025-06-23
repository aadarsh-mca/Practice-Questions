import java.util.Arrays;

public class SortHeap {
    
    /**
     * arr[] = {4, 1, 3, 9, 7}
     * arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
     * arr[] = {4, 2, 7, 1, 9, 3, 6, 0}
     * arr[] = {4, 2, 7, 1, 9, 3, 6, 0, 5, 10}
     * arr[] = {4, 6, 2, 5, 7, 9, 1, 3}
     * arr[] = {4, 3, 8, 4, 6, 5}
     */

    public static void main(String[] args) {
        int[] arr = {4, 9, 6, 2, 5, 7, 9, 1, 3, 4, 2, 4, 3};
        int n = arr.length;

        System.out.println("Before sorting : " + Arrays.toString(arr));
        System.out.println("Merge sort : " + Arrays.toString(heapSort(arr, n)));
    }

    /**
     * Explanation is on method declaration
     * 
     * @param arr
     * @param n
     * @return
     */
    static int[] heapSort(int[] arr, int n) {
        for(int i = n/2-1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        for(int i = n-1; i >= 0; i--) {
            /**
             * Removing the max element from max-heap
             * and adding it to last
             * 
             * [30, 23, 10, 21, 20]
             *  ^                ^
             * 
             *      [20, 23, 10, 21, 30]
             *       |____________|
             *             ^
             *      now max-heapify the remaining array
             * 
             * ===>
             *      [23, 20, 10, 21, 30]
             *       ^            ^
             * 
             *      [21, 20, 10, 23, 30]
             *       |________|
             *             ^
             *      now max-heapify the remaining array
             * 
             * ===>
             *      [21, 20, 10, 23, 30]
             *       ^        ^
             * 
             *      [10, 20, 21, 23, 30]
             *       |____|
             *          ^
             *      now max-heapify the remaining array
             * 
             * One-by-One all the max element will go at the end,
             * and array will be sorted in ascending order
             * 
             * In-order to sort array in descending order
             * 
             *      1. First minHeapify the array
             *      2. and start moving min element at the end
             *      2. Array will be sorted in descending order
             */
            int peek = arr[0];
            arr[0] = arr[i];
            arr[i] = peek;

            /**
             * Now after moving max element at last,
             * perform maxHeapify on the rest of the array 
             * to get max out of remaining elements
             */
            maxHeapify(arr, i, 0);
        }
        
        return arr;
    }


    /**
     * Performing max-heapify
     * 
     * @param nums
     * @param n
     * @param parent
     */
    private static void maxHeapify(int[] nums, int n, int parent) {
        int largest = parent;

        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if(left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if(right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if(largest == parent) {
            return;
        }

        swap(nums, largest, parent);
        maxHeapify(nums, n, largest);
    }

    private static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }


}
