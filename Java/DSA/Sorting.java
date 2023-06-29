package DSA;

import java.util.Arrays;

/**
 * arr[] = {4, 1, 3, 9, 7}
 * arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
 * arr[] = {4, 2, 7, 1, 9, 3, 6, 0}
 * **/

public class Sorting {
    
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 9, 3, 6, 0};
        int n = arr.length;

        System.out.println("Before sorting : " + Arrays.toString(arr));
        // System.out.println("Bubble sort : " + Arrays.toString(bubbleSort(arr, n)));
        // System.out.println("Selection sort : " + Arrays.toString(selectionSort(arr, n)));
        System.out.println("Insertion sort : " + Arrays.toString(insertionSort(arr, n)));

    }

    /**
     *  In Bubble Sort, compare the element with its adjacent element and
     *      perform swapping as for one time
     * **/
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
     *  In Selection Sort, find the smallest element and place it in the beginning and
     *      place it in the beginning and 
     *      perform swapping as for one time
     * **/
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
     *  In Insertion Sort, compare the element with its adjacent element and
     *      perform swapping until it reaches on its correct position
     *      use for/while loop in reverse order
     * **/
    static int[] insertionSort(int[] arr, int n) {
        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                // for(int j=i+1; j>0 && arr[j-1] > arr[j]; j--) {
                //     int temp = arr[j-1];
                //     arr[j-1] = arr[j];
                //     arr[j] = temp;
                // }

                int j = i+1;
                while (j > 0 && arr[j-1] > arr[j]) {

                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    j--;
                }
            }
        }

        // for (int i = 1; i < n; ++i) {
        //     int key = arr[i];
        //     int j = i - 1;
 
        //     /* Move elements of arr[0..i-1], that are
        //        greater than key, to one position ahead
        //        of their current position */
        //     while (j >= 0 && arr[j] > key) {
        //         arr[j + 1] = arr[j];
        //         j = j - 1;
        //     }
        //     arr[j + 1] = key;
        // }

        return arr;
    }

    
    /**
     *  In Merge Sort, 
     * 
     * **/
    static int[] mergeSort(int[] arr, int n) {
        int mid = n/2;
        int left = 
        return arr;
    }

}
