import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rotate90Matrix {
    
    public static void main(String[] args) {
        //  {{1,2,3}, {4,5,6}, {7,8,9}}
        //  {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int n = matrix.length;
        
        // for(int i=0; i<n; i++) {
        //     System.out.println(Arrays.toString(matrix[i]));
        // }

        // System.out.println("----");
        // rotateby90(matrix, n);
        // System.out.println("----");

        // for(int i=0; i<n; i++) {
        //     System.out.println(Arrays.toString(matrix[i]));
        // }
    }

    static void rotateby90(int matrix[][], int n) {

        // for(int i=0; i<n/2; i++) {
        //     for (int j=0; j<n; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][n-1-i];
        //         matrix[j][n-1-i] = temp;
        //     }
        // }



        
        /**
         *  Using ''NO'' Extra Space
         * **/
        int temp=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=temp;
            }
           
        }
        




        // /**
        //  *  Using String
        //  * **/
        // String dontShift = new String();
        
        // for(int row = 0; row < n; row++) {
        //     for(int col = 0; col < n; col++) {
        //         int newCol = row;
        //         int newRow = n-1-col;
                
        //         // System.out.println( row + "," + col + " --> " + newRow + "," + newCol );
                
        //         String checkPos = "" + row + col;
        //         if(dontShift.contains(checkPos)) {
        //             continue;
        //         } else {
        //             int temp = matrix[row][col];
        //             matrix[row][col] = matrix[newRow][newCol];
        //             matrix[newRow][newCol] = temp;
                    
        //             dontShift += " " + newRow + newCol;
        //         }
        //     }
        // }


        // /**
        //  *  Using ArrayList
        //  * **/
        // ArrayList<String> list = new ArrayList<>();
        
        // for(int row = 0; row < n; row++) {
        //     for(int col = 0; col < n; col++) {
        //         int newCol = row;
        //         int newRow = n-1-col;
                
        //         // System.out.println( row + "," + col + " --> " + newRow + "," + newCol );
                
        //         String checkPos = "" + row + col;
        //         if(list.contains(checkPos)) {
        //             continue;
        //         } else {
        //             int temp = matrix[row][col];
        //             matrix[row][col] = matrix[newRow][newCol];
        //             matrix[newRow][newCol] = temp;
                    
        //             String addPos = "" + newRow + newCol;
        //             list.add(addPos);
        //         }
        //     }
        // }


    }

}
