import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class AlternateNumber {
    
    public static void main(String[] args) {
        // int[] arr = {3,1,-2,-5,2,-4};
        // int[] arr = {-1,-2,-3,-4,1,2,3,4};
        int[] arr = {28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};
        int n = arr.length;

        System.out.println(Arrays.toString(rearrange(arr, n)));
    }
    
    static int[] rearrange(int[] nums, int n) {
        int[] res = new int[n];
        int i = 0;
        int posIdx = 0;
        int negIdx = 1;

        while(i < n) {
            int num = nums[i];

            if(num >= 0) {
                res[posIdx] = num;
                posIdx += 2;
            } else {
                res[negIdx] = num;
                negIdx += 2;
            }
            i++;
        }

        return res;
    }

    static boolean isPositive(int num) {
        if(num >= 0) {
            return true;
        }
        return false;
    }

    static boolean isNegative(int num) {
        if(num < 0) {
            return true;
        }
        return false;
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
