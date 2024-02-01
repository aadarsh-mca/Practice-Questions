import java.util.Arrays;

public class ReverseArrayUsingRecursion {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int n = nums.length;
        System.out.println("Before : " + Arrays.toString(nums));
        System.out.println("After : " + Arrays.toString(reverseArray(n, nums)));
    }

    /** 
     *  In O(n) Time Complexity 
     * and O(1) Space Complexity
     * 
     * **/
    
    public static int[] reverseArray(int n, int []nums) {
        reverse(0, n, nums);
        return nums;
    }
    
    static void reverse(int i, int n, int[] nums) {
        if(i >= n/2) {
            return;
        }
        swap(i, n, nums);
        reverse(i+1, n, nums);
    }

    static void swap(int i, int n, int[] nums) {
        nums[i] = nums[i] + nums[n-1-i];
        nums[n-1-i] = nums[i] - nums[n-1-i];
        nums[i] = nums[i] - nums[n-1-i];
    }

}
