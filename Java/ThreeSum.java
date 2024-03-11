import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    
    public static void main(String[] args) {
        // int[] arr = {-1,0,1,2,-1,-4};
        // int[] arr = {-1,0,1,2,-1,-4};
        // int[] arr = {-18,-1,-44,-48,-9,-16,-36,-13,29,17,-12,9,-49};
        // int[] arr = {-2,-2,-2,-1,-1,-1,0,0,0,1,1,1,2,2,2};
        int[] arr = {-2,-2,-2,-1,-1,-1,0,0,0,2,2,2};

        System.out.println("Brute 3 Sum : " + brute_3Sum(arr));
        System.out.println("Better 3 Sum : " + better_3Sum(arr));
        System.out.println("Optimal 3 Sum : " + optimal_3Sum(arr));
    }

    static List<List<Integer>> brute_3Sum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

    /**
     * Better approach,
     * 
     * nested loop
     * [-1, 0, 1, 2,-1,-4]
     *   ⁰  ¹  ²  ³  ⁴  ⁵
     *   i           j     
     * storing element b/w  i & j in 'tempArr', to check for third element        
     * 
     * <p>Time Complexity : {@code O(n² * log m)} where m is the size of tempArr
     * <p>Space Complexity : {@code O(m) + O(no of unique set)} where m is the size of tempArr
     * 
     * @param nums {@ocde int[]}
     * @return ans {@code List<List>}
     */
    static List<List<Integer>> better_3Sum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        /**
         * Using Set to store unique triplet
         */
        Set<List<Integer>> finalSet = new HashSet<>();

        for(int i=0; i<n-2; i++) {
            Set<Integer> tempArr = new HashSet<>();
            for(int j=i+1; j<n; j++) {
                int num3 = 0 - (nums[i] + nums[j]);
                if(tempArr.contains(num3)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], num3);
                    temp.sort(null);
                    finalSet.add(temp);
                } else {
                    tempArr.add(nums[j]);
                }
            }
        }

        ans.addAll(finalSet);
        return ans;
    }

    /**
     * Optimal approach
     * 
     * <p>Using Two Pointer approach
     * 
     * [-2,-2,-2,-1,-1,-1, 0, 0, 0, 1,  1,  1,  2,  2,  2]
     *   ⁰  ¹  ²  ³  ⁴  ⁵  ⁶  ⁷  ⁸  ⁹   ¹⁰  ¹²  ¹³  ¹⁴  ¹⁵
     *   i  j                                            k
     * 
     * <p> NOTE : array must be sorted
     * 
     * <p>Assuming i as base constant value, 
     * we have j and k as pointer
     * if sum = nums[i] + nums[j] + nums[k]
     * 
     * <p>SUM is less than 0 (target),
     * then that mean we need to shift toward right 
     * because we have increasing number on right,
     * 
     * <p>therefore j++ until we found element different from nums[j]
     * because if we have repeated element on j,
     * then we must skip all the element equal to nums[j]
     * 
     * <p>For eg. i=-2, j = -2, k=2  |  sum = -2
     * and j++ is also -2, 
     * then it do not make any sense to check again for j++ = -2
     * therfore move j until we found other than -2
     * 
     * <p>Similarly for SUM more that 0 (target).
     * 
     * <p>BUT in case SUM == 0,
     * then we must skip all the element similar to j and k (i.e. repeated element).
     * therefor move j and k both.
     * 
     * <p>As soon as j and k cross each other 
     * that mean no more element left to compare with base value i...
     * 
     * <p>So, move i++ until nums[i] is different,
     * because considering i= -2 
     * again and again do not make any sense,
     * it will give repeated triplet which is denied by problem.
     * 
     * <p>Time Complexity : {@code O(n² + (n log n))}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param nums {@ocde int[]}
     * @return ans {@code List<List>}
     */
    static List<List<Integer>> optimal_3Sum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        /**
         * For this algo, 
         * array must be sorted to apply two pointer
         */
        Arrays.sort(nums);

        /**
         * Initializing j more than i
         * and k at n-1 (last) element
         */
        int i=0;
        while(i < n) {
            int j = i+1;
            int k = n-1;
            int num1 = nums[i];

            while(j < k) {
                int num2 = nums[j];
                int num3 = nums[k];
                int sum = num1 + num2 + num3;

                /**
                 * If SUM is less than 0,
                 * larger element needed to make sum = 0,
                 * therefore 'j++' and 
                 * if next element is also equal then it will again move j++
                 */
                if(sum < 0) {
                    j++;

                /**
                 * If SUM is more than 0,
                 * smaller element needed to make sum = 0,
                 * therefore 'k--' and 
                 * if next element is also equal then it will again move k--
                 */
                } else if(sum > 0) {
                    k--;

                /**
                 * If SUM == 0,
                 * add the triplet and then
                 * its necessary to skip all the repeated element at 'j' and 'k',
                 * otherwise it will create similar threeSum pair,
                 * therefore move j++ and k-- until new element found.
                 */
                } else if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < n && nums[j] == num2) {
                        j++;
                    }
                    while(k > 0 && nums[k] == num3) {
                        k--;
                    }
                }
            }

            /**
             * When 'j' become more than 'k',
             * move 'i' until different element found,
             * and skip all the repeated element,
             * 
             * Skipping repeated element to avoid,
             * similar triplet (i.e. [-1,0,1] and [0,-1,1])
             */
            while(i < n && nums[i] == num1) {
                i++;
            }
        }

        return ans;
    }

}
