import java.util.ArrayList;

public class ReversePair {
    
    public static void main(String[] args) {
        // int[] arr = {1,3,2,3,1};
        // int[] arr = {2,4,3,5,1};
        // int[] arr = {40,25,19,12,9,6,2};
        int[] arr = {6,13,21,25,1,2,3,4,4,5,9,11,13};
        int n = arr.length;

        System.out.println("Brute : " + brute_reversePair(arr, n));
        System.out.println("Optimal : " + optimal_reversePair(arr, n));
    }

    /**
     * Brute force approach,
     * 
     * <p>Time Complexity : {@code O(n²)}
     * <p>Time Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of array
     * @return nPair {@code int} number of pair
     */
    static int brute_reversePair(int[] arr, int n) {
        int nPair = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i] > (arr[j] * 2)) {
                    nPair++;
                }
            }
        }
        return nPair;
    }

    /**
     * Optimal approach,
     * 
     * Using the idea of merge sort,
     * First hypothetically divide the array into smaller parts,
     * then having fact that the parts of divided array is sorted in itself.
     * 
     * <p>Therefore comparing the sorted array with the other part of sorted array.
     * 
     * <p>For example :
     * [6,12,21,25]    [1, 2, 3, 4, 4, 5,  9, 11, 13]   ANS = 23
     *  ⁰  ¹  ²  ³      ⁴  ⁵  ⁶  ⁷  ⁸  ⁹  ¹⁰  ¹¹  ¹² 
     * 
     * <p>If 6[⁰] is greater than (1[⁴] * 2),
     * <p>then all the element in the left array after 6[⁰] will also be greater than (1[⁴] * 2),
     * simply move right++;
     * 
     * <p>If 6[⁰] is not greater than 3[⁶],
     * <p>still there might be chance that element after 6[⁰] will be greater than 3[⁶],
     * therefore, move left++,
     * BUT in this case we can't add 6 into tempArr for sorting, 
     * because we still have [3,4,4,5] element smaller than 6 to be added in tempArr.
     * 
     * Therefore first we need to count all the pair, 
     * after that we need to again iterate over both the divided array for sorting purpose.
     * 
     * <p>And in the next iteration 12[¹] will become greater than 3[⁶],
     * <p>now all the element after 12[¹] will be greater than 3[⁶],
     * now move right++;
     * 
     * <p>Completing all the above iteration,
     * iterate over both the divided array and, 
     * simply merge all the elements into the original array,
     * to get the sorted array for next recursion step.
     * 
     * <p>Time Complexity : {@code O(n log n)}
     * <p>Time Complexity : {@code O(n)}
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of array
     * @return nPair {@code int} number of pair
     */
    static int optimal_reversePair(int[] arr, int n) {
        return mergeDivide(arr, 0, n-1);
    }

    static int mergeDivide(int[] arr, int low, int high) {
        int nPair = 0;
        if(low >= high) {
            return nPair;
        }
        int mid = (low + high) / 2;
        nPair += mergeDivide(arr, low, mid);
        nPair += mergeDivide(arr, mid+1, high);
        nPair += countPair(arr, low, mid, high);
        mergeSortAndCount(arr, low, mid, high);
        return nPair;
    }

    static int countPair(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        
        int count = 0;
        while(left <= mid) {
            int eleOnLeft = mid - left + 1;
            int eleOnRight = 0;
            while(right <= high && (arr[left] > ((long)arr[right] * 2))) {
                eleOnRight++;
                right++;
            }
            count += (eleOnLeft * eleOnRight);
            left++;
        }
        return count;
    }

    static void mergeSortAndCount(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tempArr = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                tempArr.add(arr[left]);
                left++;
            } else {
                tempArr.add(arr[right]);
                right++;
            }
        }

        while(left <= mid) {
            tempArr.add(arr[left]);
            left++;
        }
        while(right <= high) {
            tempArr.add(arr[right]);
            right++;
        }

        for(int i=low; i<=high; i++) {
            arr[i] = tempArr.get(i-low);
        }
    }

}
