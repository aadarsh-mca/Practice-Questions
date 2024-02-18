public class CheckArrayIsSortedAndRotated {

    public static void main(String[] args) {
        // {3,4,5,1,2}
        // {3,4,5,4}
        // {8,5,4,5,1,4,5,2,2}
        // {4,5,6,5}
        // {5,4,3,2,1}  in this case the array is not sorted in ascending order and also it is not rotated

        int[] arr = {3,4,5,1,2};
        int n = arr.length;

        System.out.println("Result : " + check(arr));
    }

    static boolean check(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2) return true;
        
        boolean flowChanged = false;
        boolean result = true;
        
        for(int i=1; i<n; i++) {
            /**
             * check whether the flow of array have changed or not
             */
            if(flowChanged == false) {
                /**
                 * if previous element is smaller,
                 * then it is okay
                 */
                if(nums[i-1] <= nums[i]) {
                    result = true;

                /**
                 * if previous element is larger,
                 * now the flow of array is changed
                 */
                } else {
                    flowChanged = true;

                    /**
                     * As we know the flow of array has changed,
                     * now the current and all the upcoming elements 
                     * must be smaller than first element
                     *
                     * if false then we cannot sort the array by rotation
                     */
                    if(nums[0] < nums[i]) {
                        return false;
                    }
                }

            /**
             * Now the flow of array has been changed
             */
            } else {
                /**
                 * Now again, 
                 * previous element must be smaller
                 *
                 * But along with that
                 * the element must be smaller than first element too 
                 */
                if(nums[i-1] <= nums[i] && nums[0] >= nums[i]) {
                    result = true;

                /**
                 * if false then we cannot sort the array by rotation
                 */
                } else {
                    return false;
                }
            }
        }
        return result;
    }
    
}
