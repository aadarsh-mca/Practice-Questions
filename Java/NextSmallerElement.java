import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    
    public static void main(String[] args) {
        /**
         * I/P :: [4, 5, 2, 10, 8]
         * O/P :: [-1, 4, -1, 2, 2]
         * 
         * I/P :: [ 39, 27, 11, 4, 24, 32, 32, 1 ]
         * O/P :: [-1, -1, -1, -1, 4, 24, 24, -1]
         */

        // int[] arr = {4, 5, 2, 10, 8};
        int[] arr = {39, 27, 11, 4, 24, 32, 32, 1};

        System.out.println(Arrays.toString(nextSmallerElement(arr)));
    }

    private static int[] nextSmallerElement(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> minStack = new Stack<>();

        int idx = 0;
        for(int num : arr) {
            while(!minStack.isEmpty() && minStack.peek() >= num) {
                minStack.pop();
            }

            if(minStack.isEmpty()) {
                res[idx] = -1;
            } else {
                res[idx] = minStack.peek();
            }

            minStack.push(num);
            idx++;
        }

        return res;
    } 

}
