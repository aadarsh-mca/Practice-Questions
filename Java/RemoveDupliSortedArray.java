import java.util.Arrays;
import java.util.HashMap;

public class RemoveDupliSortedArray {
    
    public static void main(String[] args) {
        int[] arr = {-2, -1, -1, -1, 2, 3, 3, 4};

        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0, n = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i=1, j=0; i<n; i++) {
            if(nums[j] != nums[i]) {
                nums[j+1] = nums[i];
                j++;
                System.out.println(Arrays.toString(nums));
            } 

            // if(!map.getOrDefault(nums[i], false)) {
            //     map.put(nums[i], true);
            //     count++;
            //     nums[j] = nums[i];
            //     j++;  
            // }
        }

        return count;
    }
}
