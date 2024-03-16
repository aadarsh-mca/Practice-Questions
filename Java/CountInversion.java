import java.util.ArrayList;

public class CountInversion {

    public static void main(String[] args) {
        // int[] arr = {5,3,2,1,4};
        int[] arr = {2,3,5,6,1,3,4,4,8};
        int n = arr.length;
        
        System.out.println("Brute : " + brute_countInversePair(arr, n));
        System.out.println("Optimal : " + optimal_countInversePair(arr, n));
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
    static int brute_countInversePair(int[] arr, int n) {
        int nPair = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i] > arr[j]) {
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
     * [2,3,5,6]    [1,3,4,4,8]    ANS = 10
     *  ⁰ ¹ ² ³      ⁴ ⁵ ⁶ ⁷ ⁸
     * 
     * <p>If 2[⁰] is greater than 1[⁴],
     * <p>then all the element in the left array after 2[⁰] will also be greater than 1[⁴],
     * simply move right++;
     * 
     * <p>If 3[¹] is not greater than 3[⁵],
     * <p>then there might be chance that element after 3[¹] will be greater than 3[⁵],
     * therefore, move left++
     * 
     * <p>And in the next iteration 5[²] will become greater than 3[⁵],
     * <p>now all the element after 5[²] will be greater than 3[⁵],
     * now move right++;
     * 
     * <p>Completing all the above iteration,
     * simply merge all the elements of both the divided array into the original array,
     * to get the sorted array for next recursion step.
     * 
     * <p>Time Complexity : {@code O(n log n)}
     * <p>Time Complexity : {@code O(n)}
     * 
     * @param arr {@code int[]}
     * @param n {@code int} length of array
     * @return nPair {@code int} number of pair
     */
    static int optimal_countInversePair(int[] arr, int n) {
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
        nPair += mergeSortAndCount(arr, low, mid, high);
        return nPair;
    }

    static int mergeSortAndCount(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tempArr = new ArrayList<>();
        int count = 0;

        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                tempArr.add(arr[left]);
                left++;
            } else {
                tempArr.add(arr[right]);
                count += (mid - left + 1);
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

        return count;
    }

}
