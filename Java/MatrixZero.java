import java.util.ArrayList;
import java.util.Arrays;

public class MatrixZero {
    
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] arrMatrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.get(0).add(1);
        matrix.get(0).add(1);
        matrix.get(0).add(1);
        matrix.get(1).add(1);
        matrix.get(1).add(0);
        matrix.get(1).add(1);
        matrix.get(2).add(1);
        matrix.get(2).add(1);
        matrix.get(2).add(1);

        for(int[] data : setZero(arrMatrix, n, m)) {
            System.out.println(Arrays.toString(data));
        }
        System.out.println(setZero(matrix, n, m)); 

    }

    /**
     * O(n+m) space, O(n*m) time
     * **/
    static int[][] setZero(int[][] matrix, int n, int m) {
        int nRow = matrix.length;
        int mCol = matrix[0].length;
        int[] row = new int[nRow];
        int[] col = new int[mCol];

        for(int i=0; i<nRow; i++) {
            for(int j=0; j<mCol; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0; i<nRow; i++) {
            if(row[i] != 0) {
                for(int j=0; j<mCol; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0; i<mCol; i++) {
            if(col[i] != 0) {
                for(int j=0; j<nRow; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
    }


    /**
     * O(1) space, O(n*m) time
     * **/
    static ArrayList<ArrayList<Integer>> setZero(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Boolean variable isColZero will tell us the same for the entire 1st column.
        boolean isColZero = false;
        for (int i = 0; i < n; i++) {
            /*
            If MATRIX[0][i] is 0, then isColZero = true. Because we have found a 0 in,
            the 1st column so we have to set the entire 1st column to be 0.
            */
            if (matrix.get(i).get(0) == 0) {
                isColZero = true;
            }
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // We have to set that entire row to be 0
                    matrix.get(i).set(0, 0);
                    // We have to set that entire column to be 0
                    matrix.get(0).set(j, 0);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                /*
                If starting cell of row or starting cell of column is zero,
                then set entry at i,j to 0.
                */
                if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        // If MATRIX[0][0] is 0, then we have to set the entire 1st row to be 0
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        // If isColZero is true, then we have to set the entire 1st column to be 0
        if (isColZero) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }


}
