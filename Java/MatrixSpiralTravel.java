public class MatrixSpiralTravel {
    
    char[][] matrix = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}, {'I', 'J', 'K', 'L'}, {'M', 'N', 'O', 'P'}}; //  , {'M', 'N', 'O', 'P'}

    int totalRows = matrix.length;
    int totalColumns = matrix[0].length;
    int loopLen = totalRows * totalColumns;

    public static void main(String[] args) {
        MatrixSpiralTravel obj = new MatrixSpiralTravel();

        /**
         * A B C D  H L P  O N M  I E  F G  K J
         * **/

        for(int i=0; i<obj.loopLen; i++) {
            int row = i / obj.totalColumns;
            int column = i % obj.totalColumns;

            if(column == 0) {
                System.out.println();
            }
            if(row == 0) {
                System.out.print(obj.matrix[row][column] + "\t");
            } else if(row == 1) {
                System.out.print(obj.matrix[column][row] + "\t");
            }
            // System.out.println("[" + row + "," + column + "] : " + obj.matrix[row][column]);
        }

        for(int r=0; r<obj.totalRows; r++) {
            for(int c=0; c<obj.totalColumns; c++) {
                obj.printSpiral(r, c);
            }
        }
    }

    void printSpiral(int r, int c) {
        if(r==0) {
            System.out.println(matrix[r][c]);
        }
        if(r==1) {
            int temp = r;
            r = c;
            c = temp;
            System.out.println(matrix[r][c]);
        }
    }

}
