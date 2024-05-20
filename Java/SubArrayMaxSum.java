public class SubArrayMaxSum {
    
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int n = arr.length;

        int maxSum = 0;
        int tempSum = maxSumDivide(arr, 0, 0, n);
        
        maxSum = Math.max(maxSum, tempSum);

        System.out.println("Max Sum : " + maxSum);
    }

    static int maxSumDivide(int[] arr, int tempSum, int low, int high) {
        if(low >= high) {
            return tempSum;
        }

        // int mid = (low + high) / 2;
        maxSumDivide(arr, tempSum, low, );
        // maxSumDivide(arr, tempSum, mid+1, high);

        return maxSumCalculateSum(arr, low, high);
    }

    static int maxSumCalculateSum(int[] arr, int low, int high) {
        int tempSum = 0;

        while (low < high) {
            tempSum += arr[low];
            low++;
        }

        return tempSum;
    }

}
