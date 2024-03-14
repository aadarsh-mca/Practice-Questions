import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MergeSortedArray {
    
    public static void main(String[] args) {
        System.out.println("Merge both array : ");
        /**
         * Merge inside array 1
         */
        // int nums1[] = {-1,0,0,0,3,0,0,0,0,0,0};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        // int nums1[] = {-1,0,3,0,0,0};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        // int nums1[] = {1,2,3,0,0,0};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        // int nums1[] = {1};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        int nums1[] = {0};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        int m = nums1.length; 
        // int nums2[] = {-1,-1,0,0,1,2};  //  2,5,6   -1,-1,0,0,1,2
        // int nums2[] = {2,5,6};  //  2,5,6   -1,-1,0,0,1,2
        // int nums2[] = {};  //  2,5,6   -1,-1,0,0,1,2
        int nums2[] = {1};  //  2,5,6   -1,-1,0,0,1,2
        int n = nums2.length;
        
        m = m-n;
        mergeInArr1(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        
        
        System.out.println();
        System.out.println("Sort both array in sequential way : ");
        /**
         * Don't merge, 
         * just make array 1, 2 in such a way that, 
         * if we print array 1, 2 in sequence it look like sorted array.
         */
        // long[] a = {1,8,8};
        // long[] b = {2,3,4,5};
        // long[] a = {0,6,6,6,6,6,7,8};
        // long[] b = {5,5,6,6,8};
        long[] a = {1,1,3,6,9,9};
        long[] b = {1,2,3,4,8,8};
        
        shuffle_sort_12_withExtraSpace(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


        // Or else use Shell Sort
    }

    static void mergeInArr1(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        m -= 1;
        n -= 1;

        while(n >= 0) {
            if(m >= 0 && nums1[m] > nums2[n]) {
                nums1[last] = nums1[m];
                m--;
            } else {
                nums1[last] = nums2[n];
                n--;
            }
            last--;
        }
    }


    /**
     * Optimal approach,
     * Just move all the smaller element 
     * from 2nd array to the 1st array,
     * then sort both array.
     * 
     * <p>We can shuffle the element by 
     * comparing last element of 1st array
     * and first element of 2nd array.
     * 
     * <p>Time Complexity : {@code O(min(n, m) + (n log n) + (m log m))}, wher n, m is the size of Array 1, 2 respectively
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param a
     * @param b
     */
    static void shuffle_sort_12_withExtraSpace(long[] a, long[] b) {
        int aLen = a.length;
        int bLen = b.length;

        int lastA = aLen-1;
        int firstB = 0;

        while(lastA >= 0 && firstB < bLen) {
            if(a[lastA] > b[firstB]) {
                swap(a, b, lastA, firstB);
                lastA--;
                firstB++;
            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }
    
    static void swap(long[] fromArr, long[] toArr, int fromIdx, int toIdx) {
        long temp = fromArr[fromIdx];
        fromArr[fromIdx] = toArr[toIdx];
        toArr[toIdx] = temp;
    }


}
