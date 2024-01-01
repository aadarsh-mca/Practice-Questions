import java.util.Arrays;

class MatrixBeautiful {
    
    public static void main(String[] args) {
        
    }   
    
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        int result = 0;
        int largeRow = 0, sum = 0;
        int sorted[][] = new int[N][N];
        
        for(int i=0; i<N; i++) {
            int temp = 0;
            for(int j=0; j<N; j++) {
                temp += matrix[i][j];
                sorted[i][j] = matrix[i][j];
            }
            if(temp > sum) {
                sum = temp;
                largeRow = i;
            }
            
            Arrays.sort(sorted[i]);
            System.out.println(Arrays.toString(sorted[i]));
        }
        System.out.println("largeRow : " + largeRow);
        
        for(int i=0; i<N*N; i++) {
            int row = i / N;
            if(row == largeRow) {
                i += (N-1);
                continue;
            }
            int col = i % N;
            
            result += Math.abs(matrix[largeRow][col] - sorted[row][col]);
        }
        
        return result;
    }
    
}