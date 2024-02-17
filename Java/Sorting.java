import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * arr[] = {4, 1, 3, 9, 7}
 * arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
 * arr[] = {4, 2, 7, 1, 9, 3, 6, 0}
 * arr[] = {4, 2, 7, 1, 9, 3, 6, 0, 5, 10}
 * arr[] = {4, 6, 2, 5, 7, 9, 1, 3}
 * arr[] = {4, 3, 8, 4, 6, 5}
 * **/

public class Sorting {
    
    public static void main(String[] args) {
        int[] arr = {4, 9, 6, 2, 5, 7, 9, 1, 3, 4, 2, 4, 3};
        int n = arr.length;

        System.out.println("Before sorting : " + Arrays.toString(arr));
        // System.out.println("Bubble sort : " + Arrays.toString(bubbleSort(arr, n)));
        // System.out.println("Bubble sort : " + Arrays.toString(bubbleSort(arr)));
        // System.out.println("Selection sort : " + Arrays.toString(selectionSort(arr, n)));
        // System.out.println("Selection sort : " + Arrays.toString(selectionSort(arr)));
        // System.out.println("Insertion sort : " + Arrays.toString(insertionSort(arr, n)));
        // System.out.println("Insertion sort : " + Arrays.toString(insertionSort(arr)));
        
        // System.out.println("Merge sort : " + Arrays.toString(mergeSort(arr, n)));
        System.out.println("Quick sort : " + Arrays.toString(quickSort(arr, n)));


    }









    /**
     * In Bubble Sort, 
     * we compare the element with its adjacent element and then
     * swap and move to next element
     * 
     * @param arr, n
     * 
     * @return arr , sorted {@code array}
     */
    static int[] bubbleSort(int[] arr, int n) {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Way 2 :
     */
    public static void bubbleSort(int[] arr) {
        // Bubble sort by Recursion
        int n = arr.length;
        loop1(arr, 0, n);
    }

    static void loop1(int[] arr, int i, int n) {
        if(i < n) {
            loop2(arr, 0, n-1-i);
            loop1(arr, i+1, n);
        }
    }

    static void loop2(int[] arr, int j, int n) {
        if(j < n) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
            loop2(arr, j+1, n);
        }
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }












    /**
     * In Selection Sort, 
     * we find the smallest element and  then
     * swap it on 'start index' and
     * check for next smallest element x leaving start index
     * 
     * @param arr, n
     * 
     * @return arr , sorted {@code array}
     */
    static int[] selectionSort(int[] arr, int n) {
        for(int i=0; i<n-1; i++) {
            int indexSmall = i;
            for(int j=i+1; j<n; j++) {
                if(arr[indexSmall] > arr[j]) {
                    indexSmall = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[indexSmall];
            arr[indexSmall] = temp;
        }

        return arr;
    }

    /**
     * Way 2 :
     */
    static int[] selectionSort(int[] arr) {
        int n = arr.length;
        int pos = 0;
        int minIdx = 0;

        while(pos < n) {
            minIdx = pos;
            for(int i=pos; i<n; i++) {
                if(arr[minIdx] > arr[i]) {
                    minIdx = i;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[pos];
            arr[pos] = temp;
            pos++;
        }
        
        return arr;
    }











    /**
     * In Insertion Sort, 
     * compare the element with its previous element and then
     * swap it until it reaches on its correct position
     * 
     * @param arr, n
     * 
     * @return arr , sorted {@code array}
     */
    static int[] insertionSort(int[] arr, int n) {
        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                int j = i+1;
                while (j > 0 && arr[j-1] > arr[j]) {

                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    j--;
                }
            }
        }

        return arr;
    }

    /**
     * Way 2
     * Recursive form of Insertion Sort
     */
    public static int[] insertionSort(int[] arr) {
        int size = arr.length;
        recursiveInsertion(arr, size-1, 1);
        return arr;
    }
    static void recursiveInsertion(int[] arr, int last, int i) {
        if(i > last) {
            return;
        }
        int j = i;
        while(j > 0 && arr[j] < arr[j-1]) {
            insertionSwap(arr, j, j-1);
            j--;
        }
        recursiveInsertion(arr, last, i+1);
    }
    static void insertionSwap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }











    
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
     
     * all the above step will be performed {@code recursively}
     * finally we have sorted array
     * 
     * <p>{@code Time Complexity : O(n log n)}
     * <p>{@code Space Complexity : O(n*)}
     * 
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
     * 
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
                swap(arr, left, right);
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




    

}
