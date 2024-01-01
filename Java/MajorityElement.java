public class MajorityElement {
    /**
     * 
     * 169. Majority Element
     * https://leetcode.com/problems/majority-element/description/
     * 
     * **/
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2,1};

        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == candidate) {
                count++;
            } else if(count > 0) {
                count--;
            } else {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

}
