public class SplitArrayWithLargestSum {
    
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int k = 2;
        // int[] arr = {7,2,5,10,8};
        // int k = 5;
        // int[] arr = {7,2,5,10,8};
        // int k = 1;
        // int[] arr = {1,2,3,4,5};
        // int k = 2;
        // int[] arr = {2,3,1,1,1,1,1};
        // int k = 5;

        System.out.println("Brute : " + brute_splitArraySum(arr, k) + " sum with " + k + " division of array");

        // System.out.println(countOfSubArray(arr, arr.length, 3));
    }

    static int brute_splitArraySum(int[] nums, int k) {
        int n = nums.length;
        int minSum = nums[0];
        int maxSum = 0;
        for(int num : nums) {
            minSum = Math.max(minSum, num);
            maxSum += num;
        }

        if(n == k) return minSum;
        
        for(int i = minSum; i < maxSum; i++) {
            int noOfSubArray = countOfSubArray(nums, n, i);
            if(noOfSubArray == k) {
                return i;
            }
        }
        return -1;
    }

    static int countOfSubArray(int[] nums, int n, int sum) {
        int subArrays = 0;
        int tempSum = 0;
        int i=0;
        while(i<n) {
            while(i < n && (tempSum + nums[i]) <= sum) {
                tempSum += nums[i];
                i++;
            }
            subArrays++;
            tempSum = 0;
        }
        return subArrays;
    }
}
