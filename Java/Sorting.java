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
        // System.out.println("Quick sort : " + Arrays.toString(quickSort(arr, n)));
        // System.out.println("Quick sort : " + Arrays.toString(heapSort(arr, n)));

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
     * Merge Sort,
     * 
     * shifted to { SortMerge.java }
     */
    
    
    
    
    /**
     * Quick Sort,
     * 
     * shifted to { SortQuick.java }
     */
    
    
    
    
    /**
     * Heap Sort,
     * 
     * shifted to { SortHeap.java }
     */





}
