import java.util.Arrays;

/**
 * In Quick Sort,
 * we pick a pivot index and place the pivot element at its correct place,
 * then we move element smaller than pivot on left
 * and element larger than pivot on the right
 * 
 * <p>Basically first we are {@code selecting a pivot} index,
 * then we are moving {@code smaller} elements on the {@code left of pivot} index
 * and moving {@code larger} elements on the {@code right of pivot} index
 * 
 * <p>{@code Time Complexity : O(n log n)}
 * <p>{@code Space Complexity : O(1)}
 */
public class SortQuick {

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
        System.out.println("Quick sort : " + Arrays.toString(quickSort(arr, n)));
    }


    /**
     * @param arr , original {@code array}
     * @param n , last element index of {@code array}
     * 
     * @return arr , sorted {@code array}
     */
    static int[] quickSort(int[] arr, int n) {
        /**
         * In this step,
         * we go into a recursive function,
         * where we move smaller on left,
         * and larger on right
         * 
         * and then recursive call to left hypothetical array
         * and then recursive call to right hypothetical array
         */
        quickSortHelper1(arr, 0, n-1);
        // quickSortHelper2(arr, 0, n-1);

        return arr;
    }

    static void quickSortHelper1(int[] arr, int low, int high) {
        /**
         * If low is less than 
         */
        if(low >= high) {
            return;
        }

        /**
         * selecting pivot as first element of array / sub-array
         */
        int pivot = low;

        /**
         * Pointer used to swap elements smaller than pivot element
         */
        int left = low;

        /**
         * Pointer used to swap elements larger than pivot element
         */
        int right = high;

        /**
         * Checking and swapping elements,
         * till left and right pointer cross each other,
         * and right pointer reaches on, 
         * to be correct index of pivot element.
         * 
         * we first move all the smaller elements on the left of pivot index,
         * and larger elements on the right of pivot index,
         * 
         * and as soon as the left pointer cross the right pointer
         * we will exit the while loop,
         * and we will get our to be correct index of pivot element 
         */
        while(left <= right) {
            if(arr[pivot] >= arr[left]) {
                left++;
            }else if(arr[right] >= arr[pivot]) {
                right--;
            }else if(arr[pivot] <= arr[left] && arr[pivot] >= arr[right]) {
                quickSwap(arr, left, right);
                left++;
                right--;
            } else {

            }
        }

        /**
         * right pointer reached on, 
         * to be correct index of pivot element
         */
        // System.out.println("Pivot " + arr[pivot] + " must be at : " + right);
        int sortedMiddleIndex = right;

        /**
         * Swapping the pivot element,
         * and moving it to its correct index
         */
        quickSwap(arr, pivot, sortedMiddleIndex);

        /**
         * After swapping smaller to left,
         * and larger to right,
         * and placing pivot at correct index,
         * 
         * now we will call recursively,
         * and perform all the above steps, 
         * to the hypothetical array on the left of pivot,
         * and to the hypothetical array on the right of pivot,
         * without disturbing pivot index
         */
        quickSortHelper1(arr, low, sortedMiddleIndex - 1);
        quickSortHelper1(arr, sortedMiddleIndex + 1, high);
    }
    


    static void quickSwap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }



    /**
     * Way 2 of Quick Sort,
     * 
     * Here we first place the pivot element on the correct index,
     * and then perform swapping of 
     * smaller elements to left of pivot,
     * and larger elements to the right of pivot,
     * 
     * and then recursively performing the above steps,
     * until we sort the complete array
     */
    static void quickSortHelper2(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        /**
         * First select any element as pivot
         */
        int previousPivotIndex = low;

        /**
         * Now count the number of element, smaller than (or equal) pivot
         * 
         * Please Note :
         * we have to count equal elements also,
         * so that we also move all equal elements to left,
         * to maintain consistency of smaller on left and larger on right
         * 
         * either move all equal elements on left, 
         * or move all equal elements on right.
         * * (Data must be consistent)
         */
        int leftElementCount = 0;
        for(int i = low + 1; i <= high; i++) {
            if(arr[previousPivotIndex] >= arr[i]) {
                leftElementCount++;
            }
        }
        
        /**
         * Here we counted the number of elements,
         * that need to be on the left of pivot,
         * 
         * and then adding low + leftElementCount,
         * so that the pivotIndex is not always fixed to any index,
         * when we go deeper in sub-arrays
         * 
         * to tackle this,
         * we are adding low so that we get index ranging from low - high
         * and pivot lie in that particular sub-array only
         * 
         * that mean 
         * now we have the correct index of pivot
         * on which the pivot element should be placed
         */
        // System.out.println("Number of element that need to be on left of pivot are : " + leftElementCount);
        int currentPivotIndex = low + leftElementCount;

        /**
         * Swapping the current pivot to its correct pivot index
         */
        quickSwap(arr, previousPivotIndex, currentPivotIndex);

        /**
         * As we have placed the pivot at corrent index,
         * now we can proceed with further steps.
         * 
         * We will arrange all the smaller (or equal) elements on the left of pivot,
         * and all the larger elements on the right of pivot.
         */
        quickSortArrange(arr, currentPivotIndex, low, high);

        quickSortHelper2(arr, low, currentPivotIndex - 1);
        quickSortHelper2(arr, currentPivotIndex + 1, high);
    }

    static void quickSortArrange(int[] arr, int pivotIndex, int left, int right) {
        /**
         * Here we will arrange the elements 
         * until left and right both reaches pivot index,
         */
        while(left <= pivotIndex && right >= pivotIndex) {

            /**
             * As we already assumed that, 
             * all the (equal) elements will also be on left of pivot element,
             * so simply skip the equal elements which are on left.
             */
            if(arr[pivotIndex] >= arr[left]) {
                left++;

            /**
             * But we cannot skip equal elements on right,
             * because we have assumed to have smaller (or equal) elements on left.
             * Therefore we will only skip greater ('<') elements on right.
             */
            } else if(arr[pivotIndex] < arr[right]) {
                right--;

            /**
             * Therefore,
             * if we found smaller (or equal '>=') elements on right,
             * we will move them on left side of pivot index.
             */
            } else if(arr[pivotIndex] < arr[left] && arr[pivotIndex] >= arr[right]) {
                quickSwap(arr, left, right);
                left++;
                right--;
            }
        }
    }


}
