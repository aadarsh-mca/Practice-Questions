import java.util.Arrays;

public class PeakElement2DMatrix {
    
    public static void main(String[] args) {
        // int[][] matrix = {{10,20,15}, {21,30,14}, {7,16,32}};  // 1,1  2,2
        // int[][] matrix = {{41,8,2,48,18}, {16,15,9,7,44}, {48,35,6,38,28}, {3,2,14,15,33}, {39,36,13,46,42}};  // 0,3
        // int[][] matrix = {{36,15,44,21,50}, {50,4,15,3,21}, {26,18,5,14,37}, {46,21,14,42,32}, {26,42,30,10,17}};  // 0,2
        // int[][] matrix = {{1}};  // 0,0
        // int[][] matrix = {{1,2}};  // 0,1
        // int[][] matrix = {{1}, {2}};  // 1,0
        // int[][] matrix = {{7,2,3,1,2}, {6,5,4,2,1}};  // 0,0
        int[][] matrix = {{10,30,40,50,20}, {1,3,2,500,4}};  // 0,0

        System.out.println("Brute : " + Arrays.toString(brute_getPeakIn2D(matrix)));
        System.out.println("Optimal : " + Arrays.toString(optimal_getPeakIn2D(matrix)));
    }

    /**
     * Brute force approach,
     * 
     * Iterating over each element one by one.
     * 
     * Create prev, next, top, bottom variable around to current element,
     * and check for peak condition.
     * 
     * <p>Time Complexity : {@code O(n * m))}
     * <p>Time Complexity : {@code O(1)}
     * 
     * @param mat {@code int[][] matrix} 
     * @return position {@code int[row, col]} of peak element
     */
    static int[] brute_getPeakIn2D(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int totalCell = n*m;

        for(int i=0; i < totalCell; i++) {
            int row = i / m;
            int col = i % m;

            int curr = mat[row][col];
            int prev = (col <= 0) ? Integer.MIN_VALUE : mat[row][col-1];
            int next = (col >= m-1) ? Integer.MIN_VALUE : mat[row][col+1];
            int top = (row <= 0) ? Integer.MIN_VALUE : mat[row-1][col];
            int bottom = (row >= n-1) ? Integer.MIN_VALUE : mat[row+1][col];

            if((prev < curr && curr > next) && (top < curr && curr > bottom)) {
                return new int[]{row, col};
            }
        }
        return new int[]{-1,-1};
    }



    /**
     * Optimal approach,
     * 
     *               mid
     *                v
     *         [4, 2, 5, 1, 4, 5]
     *         [2, 9, 3, 2, 3, 2]
     * max  >  [1, 7, 6, 0, 1, 3]
     *         [3, 6, 2, 3, 7, 2]
     * 
     * Intution is : 
     * <p>To perform binary search on col and select 'midCol',
     * then linearly find the maximum element on that column (i.e. 'maxMidEle').
     * 
     * <p>This will help to find the element that is greater than his 'top' and 'bottom'.
     * 
     * <p>Now check for its 'left' and 'right', 
     * If it is greater than its 'left' and 'right',
     * that mean it is the peak element.
     * 
     * <p>Else if 'left' is smaller than 'maxMidEle',
     * that mean that there might be a dip on high side or there might be '-1',
     * so move to the right half,
     * i.e. low = 'midCol +1'
     * 
     * or if 'left' is greater than 'maxMidEle',
     * that mean there might be a dip on left side or there might be '-1',
     * so move to the left half,
     * i.e. high = 'midCol -1'.
     * 
     * <p>            mid
     *                 v
     *           ⁰  ¹  ²  ³  ⁴  ⁵
     *        ⁰ [4, 2, 5, 1, 4, 5]
     *        ¹ [2, 9, 3, 2, 3, 2]
     * max >  ² [1, 7, 6, 0, 1, 3]
     *        ³ [3, 6, 2, 3, 7, 2]
     * 
     * 'midCol' = mid [²]
     * maxElement on midCol = 6 [²,²]
     * therefore 'maxMid-Row' = [²]
     * 
     * 6 [²,²] is maximum in col[²], 
     * that mean it is greater than [²-¹] and [²+¹].
     * 
     * Now check for [mid-1] and [mid+1],
     * If true, then 6 [²,²] is the peak element.
     * 
     * otherwise check for the dip of left or right,
     * and eliminate the low or high accordingly.
     * 
     * <p>Time Complexity : {@code O(log m * n)}
     * <p>Time Complexity : {@code O(1)}
     * 
     * @param mat {@code int[][] matrix} 
     * @return position {@code int[row, col]} of peak element
     */
    static int[] optimal_getPeakIn2D(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;
        while(low <= high) {
            int midCol = (low + high) / 2;
            int maxEleRow = getMaxElementRow(mat, midCol, n);

            // if curr is max in his row,
            // no need to compare with top/bottom
            int currMaxEle = mat[maxEleRow][midCol];
            int prevEle = (midCol <= 0) ? Integer.MIN_VALUE : mat[maxEleRow][midCol-1];
            int nextEle = (midCol >= m-1) ? Integer.MIN_VALUE : mat[maxEleRow][midCol+1];

            if(prevEle < currMaxEle && currMaxEle > nextEle) {
                return new int[]{maxEleRow, midCol};
            }

            if(prevEle < currMaxEle) {
                low = midCol +1;
            } else {
                high = midCol -1;
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * Finding the maximum element on specified col,
     * and returning its row index.
     */
    static int getMaxElementRow(int[][] mat, int col, int n) {
        int maxIdx = 0;
        int maxEle = mat[0][col];
        for(int row=1; row < n; row++) {
            if(mat[row][col] > maxEle) {
                maxIdx = row;
                maxEle = mat[row][col];
            }
        }
        return maxIdx;
    }
    


}
