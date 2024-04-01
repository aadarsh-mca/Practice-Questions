public class SearchIn2DMatrix_2 {
    
    public static void main(String[] args) {
        // int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        // // int target = 8;
        // int target = 14;
        // // int target = 29;

        int[][] matrix = {{-1}, {-1}};
        int target = -2;

        System.out.println("Better : " + better_searchIn2DMatrix(matrix, target));
        System.out.println("Optimal : " + optimal_searchIn2DMatrix(matrix, target));
    }


    /**
     * Better approach,
     * 
     * Perform linear search on rows,
     * and binary search on columns.
     * 
     * <p>Time Complexity : {@code O(n * log m)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param matrix {@code int[][]}
     * @param target {@code int}
     * @return true/false {@code boolean}, {@code True} if target exist else {@code false}
     */
    static boolean better_searchIn2DMatrix(int[][] matrix, int target) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;

        boolean ans = false;
        for(int row = 0; row < nRow; row++) {
            if(matrix[row][0] <= target && target <= matrix[row][nCol-1]) {
                ans = findTarget(matrix[row], target);
                if(ans) return ans;
            }
        }
        return ans;
    }

    static boolean findTarget(int[] row, int target) {
        int low = 0;
        int high = row.length -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(row[mid] == target) {
                return true;
            } else if(row[mid] < target) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }


    
    /**
     * Optimal approach,
     * 
     * Intution is :
     * 
     *      --->
     *         ⁰    ¹    ²     ³    ⁴
     *  |  ⁰  [1,   4,   7,   11,  15]
     *  |  ¹  [2,   5,   8,   12,  19]
     *  v  ²  [3,   6,   9,   16,  22]
     *     ³  [10,  13,  14,  17,  24]
     *     ⁴  [18,  21,  23,  26,  30]
     * 
     * Arrows show the ascending order of matrix.
     * 
     * <p>Suppose if we are standing on 1[0,0] / 30[4,4],
     * if we try to search 8 via binary search, 
     * we will not be able to decide whether low contains 8, or high, 
     * because in both direction it is in increasing order.
     * 
     * <p>But if we are standing on 15[0,4] / 18[4,0],
     * we can observe that low is in decreasing order, and high in is increasing order,
     * so we can easily perform search on this hypothetical array.
     * 
     *                        <-----
     *        ⁰    ¹    ²     ³    ⁴   |
     *    ⁰  [1,   4,   7,   11,  15]  |
     *    ¹  [2,   5,   8,   12,  19]  v
     *    ²  [3,   6,   9,   16,  22]
     *    ³  [10,  13,  14,  17,  24]
     *    ⁴  [18,  21,  23,  26,  30]
     * 
     * <p>We are on 15[0,4],
     * now observe that target 14[3,2] is on 'low' side of 15[0,4],
     * that mean 14[3,2] cannot be on column '4', 
     * because column '4' contains all the number more than 15[0,4],
     * Therefore decrease column by 1.
     * 
     * 
     *                        <-----
     *        ⁰    ¹    ²     ³    ⁴   |
     *    ⁰  [1,   4,   7,   11,  15]  |
     *    ¹  [2,   5,   8,   12,  19]  v
     *    ²  [3,   6,   9,   16,  22]
     *    ³  [10,  13,  14,  17,  24]
     *    ⁴  [18,  21,  23,  26,  30]
     * 
     * <p>Now we are on 11[0,3],
     * observe that target 14[3,2] is on 'high' side of 11[0,3],
     * that mean 14[3,2] cannot be on row '0',
     * because row '0' contains all the number less than 11[0,3],
     * Therefore increase row by 1.
     * 
     * <p>Repeat this process and we will eventually be at 14[3,2] after some iteration.
     * 
     * <p>Time Complexity : {@code O(n + m)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param matrix {@code int[][]}
     * @param target {@code int}
     * @return true/false {@code boolean}, {@code True} if target exist else {@code false}
     */
    static boolean optimal_searchIn2DMatrix(int[][] matrix, int target) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        
        int diagRow = 0;
        int diagCol = nCol-1;
        while(diagRow < nRow && diagCol >= 0) {
            if(matrix[diagRow][diagCol] == target) {
                return true;
            } else if(matrix[diagRow][diagCol] < target) {
                diagRow++;
            } else {
                diagCol--;
            }
        }

        return false;
    }

}
