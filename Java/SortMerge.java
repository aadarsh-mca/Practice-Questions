import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In Merge Sort, 
 * first we {@code hypothetically divide array} in smallest part
 * i.e. {@code array having only 1 element}.
 * 
 * <p>Then we add all the single element array in a list in ascending order
 * after adding,
 * now we have a list having sorted element.
 * 
 * <p>We replace the list element back into the original array
 * 
 * all the above step will be performed {@code recursively}
 * finally we have sorted array
 * 
 * <p>{@code Time Complexity : O(n log n)}
 * <p>{@code Space Complexity : O(n*)}
 */
public class SortMerge {

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
        System.out.println("Merge sort : " + Arrays.toString(mergeSort(arr, n)));
    }

    
    /**
     * @param arr , original {@code array}
     * @param n , last element index of {@code array}
     * 
     * @return arr , sorted {@code array}
     */
    static int[] mergeSort(int[] arr, int n) {
        mergeDivide(arr, 0, n-1);
        return arr;
    }
    /**
     * Here we are hypothetically dividing the array
     * using, {@code low, mid, high}.
     * 
     * @param arr , the original array
     * @param low , the left-most element INDEX
     * @param high , the right-most element INDEX
     */
    static void mergeDivide(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        /**
         * Calculating middle element to divide array in half
         * using average mean
         */
        int mid = (low + high) / 2;

        /**
         * Using Head Recursion for backtracking purpose
         */

        /**
         *    [3, 5, 1, 4, 2]
         *     ⁰  ¹  ²  ³  ⁴
         *     /           \
         * [3, 5, 1]       [4, 2]
         *  ⁰  ¹  ²         ³  ⁴
         * 
         */
        

        /**
         * Dividing the first half array until we are left with single element
         * Backtracking to previous divided array, and
         * again diving it, until we are left with signle element
         * 
         * 
         * After division, arranging all the element in order
         * After dividing we got [3, 5, 1]
         * Now assuming this array is sorted, move to next step
         * 
         * { Recursion }
         */
        mergeDivide(arr, low, mid);

        /**
         * We have assumed that we got [3, 5, 1] in sorted array
         * Now divide the second half of array, and
         * assume second half is also sorted
         * 
         * { Recursion }
         */
        mergeDivide(arr, mid+1, high);

        /**
         * Now we have both half arrays sorted in ascending order
         * We only have to merge both the array in next step
         * 
         * { Separate method }
         */
        mergeMerge(arr, low, mid, high);

    }

    /**
     * Here we are merging both the sorted {@code Array}
     * 
     * @param arr , original {@code array}
     * @param low , the left-most element INDEX
     * 
     * @param mid , 
     * <p>{@code mid}, last element of first array,
     * <p>{@code mid+1}, starting element of second array,
     * 
     * @param high , the right-most element INDEX
     */
    static int[] mergeMerge(int[] arr, int low, int mid, int high) {

        /**
         * Creating a List to store combined sorted element of both array
         */
        List<Integer> list = new ArrayList<>();

        /**
         * Starting pointer for first array
         */
        int left = low;

        /**
         * Starting pointer for second array
         */
        int right = mid+1;

        /**
         * Both pointer must have to be within array
         * If anyone exceeds, 
         * that mean one of the array has beed added completely
         * In that case, break the while loop
         */
        while(left <= mid && right <=  high) {

            /**
             * Both the array is in ascending order.
             * 
             * if left is less or equal to right
             * i.e. left is minimum or equal, add it to List
             * 
             * else left is more than right
             * i.e. right is minimum, add it to list
             * 
             * In this way we add element in List in ascending order
             */
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }

        /**
         * If second array is completely added to List, then
         * we have to add all the element of first array in List
         */
        while(left <= mid) {
            list.add(arr[left]);
            left++;
        }

        /**
         * If first array is completely added to List, then
         * we have to add all the element of second array in List
         */
        while(right <= high) {
            list.add(arr[right]);
            right++;
        }

        /**
         * Now we have all the element of both array,
         * stored in List
         * in ascending order
         * 
         * We have to replace these element from Original Array
         * 
         * respective to their original Index
         * using the starting index of first array, i.e. "low"
         * and ending index of second array, i.e. "high"
         */
        for(int i=low; i<=high; i++) {
            arr[i] = list.get(i-low);
        }
        
        /**
         * Now return the sorted original array back
         * for further computation of Divide and Merge Algorithm
         */
        return arr;
    }


}
