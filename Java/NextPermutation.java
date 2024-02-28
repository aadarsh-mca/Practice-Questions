import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    
    public static void main(String[] args) {
        // int[] arr = {1,2,3};
        // int[] arr = {3,2,1};
        int[] arr = {2,1,5,4,3,0,0};

        // List<int[]> list = brute_allPermutation(arr);
        // for(int[] listArr : list) {
        //     System.out.println(Arrays.toString(listArr));
        // }

        optimal_nextPermutation(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Brute force approach,
     * <p>The idea is to find all the possible permutation,
     * and then find the required next permutation.
     * 
     * <p>{@code N!} is the total number of permutation for 'N' number
     * <p>For eg. N = 3, i.e. {@code [1,2,3]},
     * <p>there are total 3!, i.e. 6 permutation available.
     * 
     * <p>Time Complexity : {@code O(N! * N)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param arr
     * @return
     */
    static List<int[]> brute_allPermutation(int[] arr) {
        List<int[]> list = new ArrayList<>();
        int n = arr.length;

        

        return list;
    }
    
    /**
     * Optimal approach,
     * 
     * <p>To find next permutation we first need to know what permutation is.
     * 
     * <p>Permutation is the all possible ways that a number can be arranged.
     * <p>For eg. {@code [1,2,3]} can be arranged in 3! ways : {@code ¹[1,2,3] ²[1,3,2] ³[2,1,3] ⁴[2,3,1] ⁵[3,1,2] ⁶[3,2,1]}
     * 
     * <p>Now what is next permutation ?
     * Next Permutation is the next arrangement which will come right after the current arrangement.
     * <p>For eg. next permutation of [2,1,4,3] --> [2,3,1,4]
     * 
     * <p>If we observe the pattern, we can see that the format is similar to dictionary.
     * <p>'B' comes after 'A', and 'AZ' comes after 'AX'.
     * <p> Similarly, '2' comes after '1' and '121' comes after '112'
     * 
     * <p>We can see the pattern that smaller number comes first and larger number comes after.
     * <p>So in next permutation, we have to tell the next number which will come after arranging the current number.
     * 
     * <p>Time Complexity : {@code O(3N)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param arr {@code int[]}
     * @return {@code int} next permutation
     */
    static void optimal_nextPermutation(int[] arr) {
        // [2,1,5,4,3,0,0]
        int n = arr.length;

        /**
         * To find the number that is just greater than the current,
         * we have to find the break point where we can replace the number which is just greater.
         * 
         * Break point is the number which is smaller than the number from its right.
         * Here [2,1,5,4,3,0,0]
         *         ^
         * '1' is the break point, because it is smaller than the number which is on its right '5'.
         */
        int breakPoint = -1;
        for(int i=n-1; i>0; i--) {
            if(arr[i-1] < arr[i]) {
                breakPoint = i-1;
                break;
            }
        }
        System.out.println("Pivot Index : " + breakPoint);

        /**
         * If break point == -1,
         * that mean we were not able to find break point,
         * and we do not have any next permutation number,
         * i.e. the current arrangement of number is the largest number we can find.
         * 
         * So the next permutation will be the first arrangement that we found,
         * i.e. the smallest number we can make by arranging the numbers,
         * i.e. the reverse of current largest number .
         */
        if(breakPoint == -1) {
            reverseRemainingArr(arr, 0, n-1);
            return;
        }

        /**
         * If we found the break point,
         * now we have to swap that break point number with the next smallest number,
         * which is the smallest but just greater than breakpoint number.
         * [2,1,5,4,3,0,0]
         *    ^     ^
         *   bp    small
         * 
         * This swap will make the current arrangement of numbers,
         * to be 'just' greater.
         * [2,3,5,4,1,0,0]
         *    ^     ^
         * 
         * Now '23' is just greater than '21'
         * BUT to make whole number smallest but just greater than previous,
         */
        for(int i=n-1; i>=0; i--) {
            if(arr[breakPoint] < arr[i]) {
                swap(arr, breakPoint, i);
                break;
            }
        }

        /**
         * We have to make all the 'smallest' numbers to be arranged just after the breakpoint.
         * And we have the smallest number starting from the right index.
         * 
         * Therefore simply reverse all the number right after the breakpoint.
         * [2,3,5,4,1,0,0]
         *      ¹ ²   ² ¹
         * 
         * -->[2,3,0,0,1,4,5]
         * 
         * Now 2154300 --> 2300145
         *     current     next smallest
         */
        reverseRemainingArr(arr, breakPoint+1, n-1);
    }

    static void reverseRemainingArr(int[] arr, int start, int end) {
        // Arrays.sort(arr, start, end+1);
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
