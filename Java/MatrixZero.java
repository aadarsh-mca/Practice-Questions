import java.util.ArrayList;
import java.util.Arrays;

public class MatrixZero {
    
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        // int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        for(int[] data : matrix) {
            System.out.println(Arrays.toString(data));
        }
        
        setZeroes(matrix);
        
        System.out.println();
        for(int[] data : matrix) {
            System.out.println(Arrays.toString(data));
        }

    }

    /**
     * Better approach,
     * 
     * <p>Using 2 extra array for row and column, 
     * for storing the index of row/col that need all to become zero
     * 
     * <p>Time Complexity : {@code O(2 (n × m))}
     * <p>Space Complexity : {@code O(n + m)}
     * 
     * @param matrix {@code int[][]}
     */
    static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] rowIdx = new boolean[n];
        boolean[] colIdx = new boolean[m];

        /**
         * Storing which row/col need to become zero,
         * by making that index to TRUE
         */
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    rowIdx[i] = true;
                    colIdx[j] = true;
                }
            }
        }

        for(int row=0; row < n; row++) {
            if(rowIdx[row] == true) {
                for(int col=0; col < m; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        for(int col=0; col < m; col++) {
            if(colIdx[col] == true) {
                for(int row=0; row < n; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }


    


    // /**
    //  * O(1) space, O(n*m) time
    //  * **/
    // static ArrayList<ArrayList<Integer>> setZero(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
    //     // Boolean variable isColZero will tell us the same for the entire 1st column.
    //     boolean isColZero = false;
    //     for (int i = 0; i < n; i++) {
    //         /*
    //         If MATRIX[0][i] is 0, then isColZero = true. Because we have found a 0 in,
    //         the 1st column so we have to set the entire 1st column to be 0.
    //         */
    //         if (matrix.get(i).get(0) == 0) {
    //             isColZero = true;
    //         }
    //         for (int j = 1; j < m; j++) {
    //             if (matrix.get(i).get(j) == 0) {
    //                 // We have to set that entire row to be 0
    //                 matrix.get(i).set(0, 0);
    //                 // We have to set that entire column to be 0
    //                 matrix.get(0).set(j, 0);
    //             }
    //         }
    //     }
    //     for (int i = 1; i < n; i++) {
    //         for (int j = 1; j < m; j++) {
    //             /*
    //             If starting cell of row or starting cell of column is zero,
    //             then set entry at i,j to 0.
    //             */
    //             if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
    //                 matrix.get(i).set(j, 0);
    //             }
    //         }
    //     }
    //     // If MATRIX[0][0] is 0, then we have to set the entire 1st row to be 0
    //     if (matrix.get(0).get(0) == 0) {
    //         for (int j = 0; j < m; j++) {
    //             matrix.get(0).set(j, 0);
    //         }
    //     }
    //     // If isColZero is true, then we have to set the entire 1st column to be 0
    //     if (isColZero) {
    //         for (int i = 0; i < n; i++) {
    //             matrix.get(i).set(0, 0);
    //         }
    //     }

    //     return matrix;
    // }


}
