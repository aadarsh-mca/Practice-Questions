import java.util.Arrays;

public class RotateArrayByK {
    
    public static void main(String[] args) {
        int[] arr = {-1,-100,3,99};  // k = 2   Sol: [3,99,-1,-100]
        // int[] arr = {1,2,3,4,5,6,7};  // k = 3
        // int[] arr = {1,-2,3,4,-5};  // k = 3
        // int[] arr = {1,2,3,4,5};  // k = 3
        int k = 2;

        System.out.println("Original Array : " + Arrays.toString(arr));

        rotate(arr, k);

        System.out.println("Rotated Array : " + Arrays.toString(arr));
    }


    /**
     * For brute force approach,
     * simply use extra space,
     * by creating extra array to store rotated array
     */



    /**
     * Optimal Approach
     * 
     * @param nums
     * @param k
     */
    static void rotate(int[] nums, int k) {
        int n = nums.length;

        // to rotate to left
        // k = k;
        
        /**
         * or else,
         * 
         * Intuituion is that if we want to rotate array 'k' steps to right,
         * that mean we are rotating array 'n-k' to left
         */
        k = n-k;

        /**
         * First reverse the array from '0' to 'k-1'
         * k = 3
         * [1, 2, 3, 4, 5, 6, 7]
         * 
         * [3, 2, 1, 4, 5, 6, 7]
         */
        reverse(nums, 0, k-1);
        
        /**
         * Now reverse the array from 'k' to 'n-1'
         * k = 3
         * [1, 2, 3, 4, 5, 6, 7]
         * 
         * [3, 2, 1, 7, 6, 5, 4]
         */
        reverse(nums, k, n-1);
        
        /**
         * Finally reverse the array completely
         * k = 3
         * [1, 2, 3, 4, 5, 6, 7]
         * 
         * [4, 5, 6, 7, 1, 2, 3]
         */
        reverse(nums, 0, n-1);
    }

    static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    

}
