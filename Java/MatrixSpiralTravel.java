import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSpiralTravel {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
        // int[][] matrix = {{1,2,3,4}, {10,11,12,5}, {9,8,7,6}};
        // int[][] matrix = {{1,2,3}, {10,11,4}, {9,12,5}, {8,7,6}};
        // int[][] matrix = {{1,2,3}, {8,9,4}, {7,6,5}};
        // int[][] matrix = {{1,2,3,4,5}, {16,17,18,19,6}, {15,24,25,20,7}, {14,23,22,21,8}, {13,12,11,10,9}};
        // int[][] matrix = {{1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}, {19,20,21,22,23,24}, {25,26,27,28,29,30}};
        // Edge cases
        // int[][] matrix = {{1,2,3}};

        for(int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println();
        System.out.println(spiralList(matrix));
    }

    /**
     * Only single approach,
     * i.e. optimal approach
     * 
     * Idea is simple for spiral traversal,
     * just move to --right-->  (to move to right, iterate left -> right),
     * then move to --bottom-->  (to move to bottom, iterate top -> bottom),
     * then move to --left-->  (to move to left, iterate right -> left),
     * lastly move to --top-->  (to move to top, iterate bottom -> top).
     * 
     * <p>Time Complexity : {@code O(n²)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param matrix
     * @return
     */
    static List<Integer> spiralList(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int nRows = matrix.length;
        int mCols = matrix[0].length;

        /**
         * Initializing
         * top = left = 0,
         * right = last column
         * bottom = last row
         */
        int left = 0;
        int top = 0;
        int right = mCols-1;
        int bottom = nRows-1;

        /**
         * If left is less than or equal to right,
         * this mean there is a gap b/w left |<->| right
         * i.e. there is a row to travel
         * 
         * And
         * If top is less than or equal to bottom,
         * this mean there is a gap b/w top _<->_ bottom
         * i.e. there is a column to travel
         * 
         * Therefore if there is any row and column left to travel,
         * then only the process will be repeated.
         */
        while(left <= right && top <= bottom) {
            
            /**
             * Move from left to the rightmost element,
             * and then move top to one step downward (i.e. top++),
             * so that we do not print the top-right corner
             */
            for(int i=left; i <= right; i++) {
                int num = matrix[top][i];
                ans.add(num);
            }
            top++;
    
            /**
             * Move from new top to bottom-most element,
             * and then move right to one step leftward (i.e. right--),
             * so that we do not print the bottom-right corner again
             */
            for(int i=top; i <= bottom; i++) {
                int num = matrix[i][right];
                ans.add(num);
            }
            right--;

            /**
             * If left is less than or equal to right,
             * this mean there is a gap b/w left |<->| right
             * i.e. there is a row to travel upward
             */
            if(top <= bottom) {

                /**
                 * Move from new right to left-most element,
                 * and then move bottom to one step upward (i.e. bottom--),
                 * so that we do not print the bottom-left corner again
                 */
                for(int i=right; i >= left; i--) {
                    int num = matrix[bottom][i];
                    ans.add(num);
                }
                bottom--;
            }
    
            /**
             * If top is less than or equal to bottom,
             * this mean there is a gap b/w top _<->_ bottom
             * i.e. there is a column to travel leftward
             */
            if(left <= right) {

                /**
                 * Move from new bottom to top-most element,
                 * and then move left to one step right-ward (i.e. left++),
                 * so that we do not print the top-left corner again
                 */
                for(int i=bottom; i >= top; i--) {
                    int num = matrix[i][left];
                    ans.add(num);
                }
                left++;
            }
        }
        
        return ans;
    }

}
