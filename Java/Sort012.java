import java.util.Arrays;

public class Sort012 {
    
    public static void main(String[] args) {
        int[] arr = {0,2,2,1,0,0,1,0};
        // int[] arr = {2,2,2,2,0,0,1,0};
        // int[] arr = {2,0,2,1,1,0};
        // int[] arr = {2,0,1};
        int n = arr.length;
        
        sort(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Brute force approach,
     * use any sorting algorithm,
     * <p>merge, quick sort
     * 
     * <p>Time Complexity : {@code O(n log n)}
     * <p>Space Complexity : {@code O(1), O(n)}
     */



    /**
     * Better approach,
     * use three variable for 
     * <p>count 0 
     * <p>count 1 
     * <p>count 2 
     * 
     * and replace 0,1,2 with the number according to count variables
     * 
     * <p>Time Complexity : {@code O(2n)}
     * <p>Space Complexity : {@code O(1)}
     */
    
    
    
    /**
     * Optimal approach,
     * use DNF (Dutch National Flag Algorithm)
     * 
     * <p>DNF States that : 
     * <p>all '0' lie between 0 <-> low-1
     * <p>all '1' lie between low <-> mid-1
     * <p>{@code AND mid <-> high-1 contains all the random number (0,1,2)}
     * <p>all '2' lie between high <-> n
     * 
     * <p>Time Complexity : {@code O(n)}
     * <p>Space Complexity : {@code O(1)}
     */

    static void sort(int[] arr, int n) {
        int left = 0;
        int mid = 0;
        int right = n-1;

        while(mid <= right) {
            if(arr[mid] == 0) {
                swap(arr, mid, left);
                left++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else if(arr[mid] == 2) {
                swap(arr, mid, right);
                right--;
            }
        }
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

}
