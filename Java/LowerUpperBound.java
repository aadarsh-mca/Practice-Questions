public class LowerUpperBound {
    
    public static void main(String[] args) {
        // int[] arr = {1,2,3,3,4,7,8,9,9,11};  // 9
        // int[] arr = {1,2,3,3,7,8,9,9,9,11};  // 9
        int[] arr = {1,4,7,8,10};  // 7
        int target = 7;
        int n = arr.length;

        System.out.println("Upper Bound : " + upperBound(arr, n, target));
        System.out.println("Lower Bound : " + lowerBound(arr, n, target));
    }

    /**
     * Optimal approach, [Upper Bound]
     * 
     * Upper Bound of a number 'target' is defined as 
     * the index of the first value that is greater than a given target,
     * i.e. arr[idx] must be "more" than target
     * 
     * Start binary search,
     * if we found target at mid,
     * that mean this 'mid' could be the answer so add it to 'ansIdx',
     * and move to left for any further search of index less than mid.
     * 
     * <p>Brute force approach,
     * will go use linear search which take tim complexity as O(n).
     * 
     * <p>Time Complexity : {@code O(log n)}
     * <p>Time Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]} integer array
     * @param n {@code int} length of array
     * @param target {@code int}
     * @return ansIdx {@code int}
     */
    static int upperBound(int[] arr, int n, int target) {
        int ansIdx = n; 
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                ansIdx = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ansIdx;
    }

    /**
     * Optimal approach, [Lower Bound]
     * 
     * Lower Bound of a number 'target' is defined as the smallest index 'idx',
     * such that the value 'arr[idx]' is not less than 'target',
     * i.e. arr[idx] must be "more than or equal" to target
     * 
     * Start binary search,
     * if we found target at mid,
     * that mean this 'mid' could be the answer so add it to 'ansIdx',
     * and move to left for any further search of index less than mid.
     * 
     * <p>Brute force approach,
     * will go use linear search which take tim complexity as O(n).
     * 
     * <p>Time Complexity : {@code O(log n)}
     * <p>Time Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]} integer array
     * @param n {@code int} length of array
     * @param target {@code int}
     * @return ansIdx {@code int}
     */
    static int lowerBound(int[] arr, int n, int target) {
        int ansIdx = n; 
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                ansIdx = Math.min(ansIdx, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ansIdx;
    }
    
}
