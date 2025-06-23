public class DuplicateNumPigeonHole {
    
    public static void main(String[] args) {
        // int[] arr = {1, 3, 4, 2, 2};
        int[] arr = {1, 3, 4, 3, 5};
        
        System.out.println("(Better) -- Duplicate Number is :: " + findDuplicate_better(arr));
        System.out.println("(Optimal) -- Duplicate Number is :: " + findDuplicate_better(arr));
    }

    /**
     * 
     * ====== [   Pigeon Hole Principle   ] ======
     * 
     * 
     * Counting the number of Pigeon present in half of the hole...
     * 
     * * if Pigeon is more than the the holes present, 
     * than there must be a hole where more than 1 pigeon is present,
     * 
     * * if Pigeon is less than the holes present,
     * than there must be missing Pigeon in that range
     * 
     */
    private static int findDuplicate_better(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n-1;
        while(left < right) {
            int mid = (left + right) / 2;

            int count = countFreq(nums, mid);

            if(count > mid) {
                right = mid;
            } else if(count <= mid) {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int countFreq(int[] nums, int mid) {
        int count = 0;
        for(int num : nums) {
            if(num <= mid) {
                count++;
            }
        }
        return count;
    }


    /**
     * 
     * ====== [ Linked List Cycle method ] ======
     * 
     *  ⁰  ¹  ²  ³  ⁴
     * [1, 3, 4, 2, 2]
     * 
     * 
     * 1 -> 3 -> 2 -> 4
     *           ^    |
     *           |____|
     *        
     * apply slow / fast pointer algo
     * 
     */

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0];
        int fast = nums[0];

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast) {
                break;
            }
        }

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
