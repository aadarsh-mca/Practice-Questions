import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSpiralTravel {

    public static void main(String[] args) {
        // // straight forward
        // int[][] matrix = {{1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}, {19,20,21,22,23,24}, {25,26,27,28,29,30}};
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        // int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        // int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        // // spiral
        // int[][] matrix = {{1,2,3,4,5}, {16,17,18,19,6}, {15,24,25,20,7}, {14,23,22,21,8}, {13,12,11,10,9}};


        /**
         * * Spiral Travel
         * **/

        // print(matrix);
        // System.out.println();
        // spiralPrint(matrix);


        

        /**
         * * Spiral Shift
         * **/

        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            mat.add(new ArrayList<>());
            for(int x : matrix[i]) {
                mat.get(i).add(x);
            }
        }

        for(ArrayList<Integer> list : mat) {
            System.out.println(list);
        }
        System.out.println();

        spiralShift(mat);
        
        for(ArrayList<Integer> list : mat) {
            System.out.println(list);
        }

        
    }

    static void spiralShift(ArrayList<ArrayList<Integer>> mat) {
        int m = mat.get(0).size();
        int n = mat.size();

        int left = 0;
        int right = m-1;
        int bottom = n-1;
        int top = 0;

        
        while(left <= right && top <= bottom) {
            int temp1 = mat.get(top).get(left);
            
            for(int l=left; l <= right; l++) {
                int temp2 = mat.get(top).get(l);
                mat.get(top).set(l, temp1);
                temp1 = temp2;
            }
            top++;

            for(int t=top; t <= bottom; t++){
                int temp2 = mat.get(t).get(right);
                mat.get(t).set(right, temp1);
                temp1 = temp2;
            }
            right--;

            if(top <= bottom) {
                for(int r=right; r >= left; r--) {
                    int temp2 = mat.get(bottom).get(r);
                    mat.get(bottom).set(r, temp1);
                    temp1 = temp2;
                }
                bottom--;
            }

            if(left <= right) {
                for(int b=bottom; b >= top; b--) {
                    int temp2 = mat.get(b).get(left);
                    mat.get(b).set(left, temp1);
                    temp1 = temp2;
                }
                mat.get(left).set(left, temp1);
                left++;
            }
        }
    }

    static void spiralPrint(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int top = 0;
        
        while(left <= right && top <= bottom) {
            // System.out.println("left: " + left + ", right: " + right + ", bottom: " + bottom + ", top:" + top);
            
            for(int l=left; l <= right; l++) {
                System.out.print(matrix[top][l] + " ");
                // left++;
            }
            top++;
            
            for(int t=top; t <= bottom; t++) {
                System.out.print(matrix[t][right] + " ");
                // top++;
            }
            right--;
            
            if(top <= bottom) {
                for(int r=right; r >= left; r--) {
                    System.out.print(matrix[bottom][r] + " ");
                    // right--;
                }
                bottom--;
            }

            if(left <= right) {
                for(int b=bottom; b >= top; b--) {
                    System.out.print(matrix[b][left] + " ");
                    // bottom--;
                }
                left++;
            }

        }
    }
    
    static void print(int[][] matrix) {
        for(int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    } 

}
