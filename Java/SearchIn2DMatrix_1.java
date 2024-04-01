public class SearchIn2DMatrix_1 {
    
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 5;
        // int target = 100;

        // int[][] matrix = {{1}};
        // int target = 1;

        System.out.println("Brute : Does " + target + " exist ?\n\t>> " + brute_searchInMatrix(matrix, target));
        System.out.println("Better : Does " + target + " exist ?\n\t>> " + optimal_searchInMatrix(matrix, target));
        System.out.println("Optimal : Does " + target + " exist ?\n\t>> " + better_searchInMatrix(matrix, target));
    }

    /**
     * Brute force approach, 
     * 
     * <p>Time Complexity : {@code O(m * n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param matrix {@code int[][]}
     * @param target {@code int}
     * @return true/false {@code boolean}, {@code True} if target exist else {@code false}
     */
    static boolean brute_searchInMatrix(int[][] matrix, int target) {
        for(int[] row : matrix) {
            for(int colValue : row) {
                if(colValue == target) {
                    return true;
                }
            }
        }
        return false;  
    }



    /**
     * Optimal 2 approach, 
     * 
     * Intution is :
     * 
     * [ 1,  3,  5,  7]
     * [10, 11, 16, 20]
     * [23, 30, 34, 60]  < cols
     *  ^
     *  rows
     * 
     * Perform Binary Search on rows,
     * and check 
     * <p>if 'row[0]' <= target <= 'row[n-1]'
     * <p>if YES, then perform binary search on that particular row of matrix,
     * else
     *   <p>if 'row[0]' < target, than low = mid+1 ( --> )
     *   <p>else 'row[0]' > target, than high = mid-1 ( <-- )
     * 
     * <p>Time Complexity : {@code O(m + log(n))}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param matrix {@code int[][]}
     * @param target {@code int}
     * @return true/false {@code boolean}, {@code True} if target exist else {@code false}
     */
    static boolean better_searchInMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rLow = 0;
        int rHigh = m-1;
        while(rLow <= rHigh) {
            int row = (rLow + rHigh) / 2;
            if(matrix[row][0] <= target && target <= matrix[row][n-1]) {
                return findTarget(matrix[row], target);
            } else if(matrix[row][0] < target) {
                rLow = row +1;
            } else {
                rHigh = row -1;
            }
        }
        return false;
    }

    static boolean findTarget(int[] row, int target) {
        int low = 0;
        int high = row.length -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(row[mid] == target) {
                return true;
            } else if(row[mid] > target) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return false;
    }

    
    
    /**
     * Optimal approach 1, 
     * 
     * Intution is :
     * 
     * [ 1,  3,  5,  7]
     * [10, 11, 16, 20]
     * [23, 30, 34, 60]  < cols
     *  ^
     *  rows
     * 
     * As problem stated that 
     * [0,0] < [0,m] AND
     * [0,0] < [1,0]
     * 
     * <p>That mean all the element of matrix are in ascending order.
     * 
     * Therefore, hypothetically imagine the 2D array as 1D array, and
     * directly applying binary search on matrix from '0' -> 'totalCell'.
     * 
     * <p>Time Complexity : {@code O(log(m * n))}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param matrix {@code int[][]}
     * @param target {@code int}
     * @return true/false {@code boolean}, {@code True} if target exist else {@code false}
     */
    static boolean optimal_searchInMatrix(int[][] matrix, int target) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        int totalCell = nCol*nRow;

        int low = 0;
        int high = totalCell -1;
        while(low <= high) {
            int mid = (low + high) / 2;

            int row = mid / nCol;
            int col = mid % nCol;
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }


}
