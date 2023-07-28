package DSA;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] arr = {4,8,2,1,5,6,7,3};
        int n = arr.length;

        mergeSort(arr, n, 0, n-1);

    }

    static int[] mergeSort(int[] arr, int n, int start, int end) {
        int mid = (start + end) / 2;

        if(start == end) {
            merge();
        }

        int[] leftArr = mergeSort(arr, n, start, mid);
        int[] rightArr = mergeSort(arr, n, mid+1, end);

        return arr;
    }

    static void merge() {

    }
}
