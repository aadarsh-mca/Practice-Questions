import java.util.Arrays;

public class MatrixRotate {
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        for(int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

        rotateMatrixClockwiseBy90(matrix);

        System.out.println();
        for(int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * Optimal approach,
     * 
     * <p>Time Complexity : {@code O(n²/2 + n²)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param matrix
     */
    static void rotateMatrixClockwiseBy90(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int firstRow = 0;
        int lastRow = n-1;

        /**
         * First reverse the rows of matrix,
         * i.e. move 1st row to last
         * and 2nd row to last-1
         * 
         * 1 2 3      7 8 9
         * 4 5 6  =>  4 5 6
         * 7 8 9      1 2 3
         */
        while(firstRow < lastRow) { // n/2*n
            for(int j=0; j<m; j++) {
                swapRows(matrix, firstRow, lastRow, j);
            }
            firstRow++;
            lastRow--;
        }

        /**
         * Now transpose the resultant matrix,
         * which will simply rotate the matrix clockwise by 90 deg
         * 
         * 7 8 9      7 4 1
         * 4 5 6  =>  8 5 2
         * 1 2 3      9 6 3
         */
        transpose(matrix, n, m);
    }

    static void swapRows(int[][] matrix, int fromRow, int toRow, int col) {
        int temp = matrix[fromRow][col];
        matrix[fromRow][col] = matrix[toRow][col];
        matrix[toRow][col] = temp;
    }

    static void transpose(int[][] matrix, int n, int m) {
        for(int i=0; i<n; i++) { // n*n
            for(int j=i; j<m; j++) {
                swapElement(matrix, i, j);
            }
        }
    }

    static void swapElement(int[][] matrix, int row, int col) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }
    
}
