import java.util.Arrays;

public class FrequencyArraySpaceO1 {
    public static void main(String[] args) {
        /**
         * Create Frequency Array in-place
         * at O(1) space complexity
         * 
         * Step 1   : Take i as loop index,
         * Step 2   : Take j as element's correct index
         * Step 3   : Check the range of number
         *      3.1 : If not in range, skip it and move to further element else move to step 4
         * Step 4   : Now if 'i' is more than or equal to 'j'
         *      4.1 : set the frequency of 'j' accordingly
         * Step 5   : if 'i' is less than 'j'
         *      5.1 : Then check if we have any frequency count at 'j'
         *      5.2 : if we have frequency, just increase it
         *      5.3 : else swap 'i' with 'j' and set the frequency of 'j' accordingly
         * Step 6   : Now correct the array
         *      6.1 : make the element positive if we have any frequency
         *      6.2 : else make it 0
         * **/

        int[] nums = {11, 4, 8, 9, 19, 5, 7, 7};   //  1, 3, 1, 1, 2, 1  //  1, 3, 1, 9, 2, 7  //  11, 4, 8, 9, 19, 5, 7, 7
        int n = nums.length;
        int x = 19;  //  6  //  9  //  19

        countFrequency(n, x, nums);

        System.out.println(Arrays.toString(nums));
    }

    static void countFrequency(int n, int x, int []nums){
        // Step 1
        int i=0;
        while(i < n) {
            // Step 2
            // for having j at 0 based minus (-1)
            int j = nums[i];
            /**
             *      Step 3
             * **/
            if(j >= 1 && j <= n) {
                if(i >= j-1) {
                    /**
                     *      Step 4
                     * **/
                    setFrequency(j, nums);
                    i++;
                } else {
                    /**
                     *      Step 5
                     * **/
                    if(nums[j-1] < 0) {
                        /**  
                         *      Step 5.1
                         * **/
                        setFrequency(j, nums);
                        i++;
                    } else {
                        /** 
                         *      Step 5.2
                         * **/
                        swap(i, j-1, nums);
                        setFrequency(j, nums);
                    }
                }
            } else {
                // element is not in range, just skip it.
                i++;
            }
        }

        /**
         *      Step 6
         * **/
        for(int a=0; a<n; a++) {
            if(nums[a] <= 0) {
                nums[a] *= -1;
            } else {
                nums[a] = 0;
            }
        }
    }

    static void setFrequency(int j, int[] nums) {
        /**
         * if less than 0 this mean we already have some frequency count 
         * only increase the frequency
         * else
         * set frequency to be -1
         * **/
        if(nums[j-1] < 0) {
            nums[j-1]--;
        } else {
            nums[j-1] = -1;
        }
    }

    static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
