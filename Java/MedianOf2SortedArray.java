import java.util.Arrays;

public class MedianOf2SortedArray {
    
    public static void main(String[] args) {
        // int[] arr1 = {6,7,10,12};
        // int[] arr2 = {1,2,15,20,22};
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        // int[] arr1 = {1,3,5,6};
        // int[] arr2 = {2,4,7,8};
        // int[] arr1 = {1,3,5};
        // int[] arr2 = {2,4};
        // int[] arr1 = {1,3};
        // int[] arr2 = {2,4,5};
        // int[] arr1 = {1,4,7,10,12};
        // int[] arr2 = {2,3,6,15};

        System.out.println(">>>> Brute is simple, just create 3rd array and find the median. <<<<\n");
        System.out.println("Better : " + better_medianOfSortedArray(arr1, arr2));
        System.out.println("Optimal : " + optimal_medianOfSortedArray(arr1, arr2));
    }

    /**
     * 
     * Brute force approach,
     * 
     * Simply create a new array of size(n+m), and 
     * find the median of new array to get to the answer.
     * 
     * <p>Time Complexity : {@code O(n + m)}
     * <p>Space Complexity : {@code O(n + m)}
     */


    

    /**
     * Better approach,
     * It is similar to brute approach, 
     * but without using any extra space.
     * 
     * <p>First take mid = (n + m) / 2;
     * 
     * <p>We are creating two variable,
     * num1 and num2.
     * 
     * <p>On every iteration, we are sliding the value of num1 -> num2,
     * and then storing new value in num1,
     * along with that we are keeping a count variable 
     * to check how many elements we have traversed.
     * 
     * <p>As soon we hit the 'count == mid',
     * this mean that we are now having the median value in num1 & num2.
     * 
     * <p>If noOfElements in merged array would be even :
     * than, (num1 + num2) / 2 will be the median 
     * as there are two median element.
     * 
     * <p>If noOfElements in merged array would be odd :
     * than, num1 will be the median 
     * as there is only one median element.
     * 
     * <p>Time Complexity : {@code O(n + m)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param nums1 {@code int[]} 1st sorted array
     * @param nums2 {@code int[]} 2nd sorted array
     * @return median {@code int} median of both the array
     */
    static double better_medianOfSortedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int mid = (n + m) / 2;

        int num1 = 0;
        int num2 = 0;
        
        int count = -1;
        int left1 = 0;
        int left2 = 0;

        /**
         * if,
         * 'count == mid', 
         * this mean we have our median element, 
         * therefore do not check any further element.
         * 
         * else,
         * keep iterating until one of the array finishes.
         */
        while(left1 < n && left2 < m && (count != mid)) {
            count++;

            /**
             * On every iteration, just keep storing the smallest on num1,
             * slide the value fo num1 to -> num2.
             */
            if(nums1[left1] <= nums2[left2]) {
                num2 = num1;
                num1 = nums1[left1];
                left1++;
            } else {
                num2 = num1;
                num1 = nums2[left2];
                left2++;
            }
        }

        /**
         * But if elements on 1st/2nd array finishes 
         * before we encounter 'count == mid',
         * then the median element will surely be on either 1st array or 2nd array.
         */
        while(left1 < n && count != mid) {
            count++;
            num2 = num1;
            num1 = nums1[left1];
            left1++;
        }
        while(left2 < m && count != mid) {
            count++;
            num2 = num1;
            num1 = nums2[left2];
            left2++;
        }

        /**
         * After encountering 'count == mid',
         * we are having the median element in num1 & num2.
         * 
         * Now return the median according to odd/even.
         */
        if((n+m) % 2 != 0) {
            return (double)num1;
        } else {
            return ((double)(num1 + num2)) / 2.0;
        }
    }
    









    /**
     * Optimal approach,
     * 
     *       n1 [1, 4, 7, 10, 12]   <-->   n2 [2, 3, 6, 15]
     * 
     * First swap the smallest on n1 
     * and larger on n2.
     * 
     *       n1 [2, 3, 6, 15]   <-->   n2 [1, 4, 7, 10, 12]
     * 
     *                          |
     * merged : [1, 2, 3, 4, 6, | 7, 10, 12, 15]
     *           ⁰  ¹  ²  ³  ⁴  | ⁵   ⁶   ⁷   ⁸
     * 
     * <p>If we carefully observe that,
     * we have 5 element on left if both array is merged,
     * and 4 element on right.
     * 
     * <p>And on left we have (3 from arr1 & 2 from arr2),
     * rest on the right.
     * 
     * <p>So, if we somehow able to decide that, 
     * we have to take 3 element from arr1,
     * and 2 element from arr2,
     * then it will help solving the ques.
     * 
     * merged : [1, 2, 3, 4, 6, | 7, 10, 12, 15]
     *           ⁰  ¹  ²  ³  ⁴  | ⁵   ⁶   ⁷   ⁸
     * arr1 - 3     [2, 3, 6]   |   [15]
     * arr2 - 2        [1, 4]   |   [7, 10, 12]
     *                         mid
     * 
     * <p>Now carefully look that we have all the sorted elements on left,
     * and all the other sorted element on the right.
     * 
     * <p>We can perform binary search on min(arr1, arr2),
     * to decide how many element we have to from arr1 & arr2.
     * 
     * Total length = 5,   arr1 = 3,
     * therefore, arr2 = total_length - arr1;
     * 
     * <p>Smallest array (n2) = [2, 3, 6, 15]
     *                           ⁰  ¹  ²   ³
     * 
     * low = 0, high = 4 --> mid 2,
     * this mean take 3 from arr2, and
     * arr1 = 5 - arr2 
     *      = 2
     * 
     *                    'l1'         'r1'
     * arr1 - 3     [2, 3, 6]     |    [15]
     * arr2 - 2        [1, 4]     |    [7, 10, 12]
     *                    'l2'   mid   'r2'
     * 
     * Above, is the perfect combination of arr1 & arr2,
     * because,
     * >>>>>>   l1 <= r2 && l2 <= r1
     * 
     * We always check in cross/diagonal,
     * because l1 will always be less than r1, as it is already a sorted array, and vice versa.
     * 
     * 
     *                                   'r1'
     * arr1 - 1              [2]    |    [3, 6, 15]
     * arr2 - 4    [1, 4, 7, 10]    |    [12]
     *                      'l2'   mid   
     * 
     * when l2 > r1,
     * this mean we are taking less element from arr1 (that mean we are on low side), 
     * and binary search is also on arr1,
     * so we need to take more element from arr1 (need to go on high side),
     * >>>>>>>   low = mid +1.
     * 
     * 
     *                      'l1'
     * arr1 - 4    [2, 3, 6, 15]    |    [ ]
     * arr2 - 1              [1]    |    [4, 7, 10, 12]
     *                           mid     'r2'
     * 
     * when l1 > r2,
     * this mean we are taking more element from arr1 (that mean we are on high side), 
     * and binary search is also on arr1,
     * so we need to take more element from arr1 (need to go on low side),
     * >>>>>>>>   high = mid -1.
     * 
     * <p>Time Complexity : {@code O(log(n + m))}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param nums1 {@code int[]} 1st sorted array
     * @param nums2 {@code int[]} 2nd sorted array
     * @return median {@code int} median of both the array
     */
    static double optimal_medianOfSortedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        /**
         * Here we are swapping the smallest array in nums1,
         * and larger array on nums2.
         */
        if(n > m) return optimal_medianOfSortedArray(nums2, nums1);

        /**
         * Calculate the length of left section,
         * if total is even, both side will have equal elements,
         * if total is odd, left side will have 1 extra element.
         */
        int totalLength = n + m;
        int leftSection = (totalLength +1) / 2;
        int num1 = 0;
        int num2 = 0;

        /**
         * Performing binary search on arr1, 
         * because arr1 is smallest.
         */
        int low = 0;
        int high = n;
        while(low <= high) {

            /**
             * Calculating mid, which will be mid of arr1, 
             * as binary search is performing on arr1.
             * 
             * 'mid1' depict the last element of left-side of arr1
             * 'mid1 +1' depict the first element of right-side of arr1
             * 
             * Similary,
             * 'mid2' or 'totalLength - mid1' depict the last element of left-side of arr2
             * 'mid2 +1' depict the first element of rght-side of arr2.
             */
            int mid = (low + high) / 2;
            int mid1 = mid;
            int mid2 = leftSection - mid1;

            /**
             * if 'l1' or 'l2' is less than 0, than assign least possible value (i.e. MIN_VALUE),
             * otherwise l1 = 'mid1 -1' / l2 = 'mid2 -1',
             * if 'r1' or 'r2' is more than n, than assign largest possible value (i.e. MAX_VALUE),
             * otherwise r1 = 'mid1' / r2 = 'mid2'.
             */
            int l1 = (mid1 > 0) ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? nums2[mid2] : Integer.MAX_VALUE;

            /**
             * if l1 <= r2 && l2 <= r1,
             * this mean all the left side element is less than right side element,
             * i.e. both are in sorted manner,
             * And this will be our answer.
             */
            if(l1 <= r2 && l2 <= r1) {
                num1 = Math.max(l1, l2);
                num2 = Math.min(r1, r2);
                break;

            /**
             * when l1 > r2,
             * this mean we are taking more element from arr1 (that mean we are on high side),
             * move to left side ( <-- ).
             */
            } else if(l1 > r2) {
                high = mid-1;

            /**
             * when l2 > r1,
             * this mean we are taking less element from arr1 (i.e. more element from arr2)
             * (that mean we are on high side),
             * move to right side ( --> ).
             */
            } else { // if(l2 > r1)
                low = mid+1;
            }
        }

        /**
         * if 
         * total-length is odd,
         * than num1 will be our answer,
         * num1 = max(l1, l2).
         * 
         * else
         * (num1 + num2) / 2,
         * i.e. median of num1 & num2,
         * num2 = min(r1, r2).
         */
        if(totalLength % 2 != 0) {
            return (double)num1;
        } else {
            return ((double)(num1 + num2)) / 2.0;
        }
    }
}
