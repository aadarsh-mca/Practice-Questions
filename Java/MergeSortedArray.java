import java.util.Arrays;

public class MergeSortedArray {
    
    public static void main(String[] args) {
        // int nums1[] = {-1,0,0,0,3,0,0,0,0,0,0};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        // int nums1[] = {-1,0,3,0,0,0};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        int nums1[] = {1,2,3,0,0,0};  //  1,2,3,0,0,0   -1,0,0,0,3,0,0,0,0,0,0
        int m = nums1.length; 
        // int nums2[] = {-1,-1,0,0,1,2};  //  2,5,6   -1,-1,0,0,1,2
        int nums2[] = {2,5,6};  //  2,5,6   -1,-1,0,0,1,2
        int n = nums2.length;
        m = m - n;

        merge(nums1, m, nums2, n);

    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int j = m - 1;
        int k = n - 1;
        while(k >= 0) { // untill nums2 get merged
            if(nums1[j] <= nums2[k]) {
                nums1[i] = nums2[k];
                i--;
                k--;
            } else {
                nums1[i] = nums1[j];
                i--;
                j--;
            }
        }

        System.out.println("After : " + Arrays.toString(nums1));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("Before : " + Arrays.toString(nums1));

        System.out.println("m : " + m + ", n : " + n);

        int i=0;
        int j=0;
        while(j < n) {
            // if(nums1[i] != 0 && nums1[i] <= nums2[j]) {
            //     i++;
            // } else 
            if(nums1[i] > nums2[j] || (i >= ((m+n) - (n-j)) && nums1[i] == 0)) {
                int temp1 = nums1[i];
                nums1[i] = nums2[j];
                for(int k=i+1; k < m+n; k++) {
                    int temp2 = nums1[k];
                    nums1[k] = temp1;
                    temp1 = temp2;
                }
                j++;
            }
            i++;
        }

        System.out.println("After : " + Arrays.toString(nums1));
    }



}
