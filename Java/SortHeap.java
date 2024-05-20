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


    static int[] heapSort(int[] arr, int n) {
        

        return arr;
    }

}
