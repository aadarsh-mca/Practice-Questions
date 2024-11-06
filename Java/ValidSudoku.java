public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(isValidSudoku(board));
    }

    static boolean isValidSudoku(char[][] board) {
        int nRow = board.length;
        int nCol = board[0].length;
        int totalCell = nRow * nCol;

        for (int i = 0; i < totalCell; i++) {
            int row = i / nCol;
            int col = i % nCol;

            boolean isRowValid = checkRow(board, row, col, nCol);
            if (!isRowValid)
                return false;

            boolean isColValid = checkCol(board, row, col, nRow);
            if (!isColValid)
                return false;

            boolean is3x3Valid = check3x3(board, row, col);
            if (is3x3Valid == false)
                return false;
        }

        return true;
    }

    static boolean checkRow(char[][] board, int row, int col, int nCol) {
        for (int i = 0; i < nCol; i++) {
            if (i == col || board[row][col] == '.' || board[row][i] == '.')
                continue;
            if (board[row][col] == board[row][i])
                return false;
        }
        return true;
    }

    static boolean checkCol(char[][] board, int row, int col, int nRow) {
        for (int i = 0; i < nRow; i++) {
            if (i == row || board[row][col] == '.' || board[i][col] == '.')
                continue;
            if (board[row][col] == board[i][col])
                return false;
        }
        return true;
    }

    static boolean check3x3(char[][] board, int row, int col) {
        int minRow = getMinRowColFor3x3(row);
        int minCol = getMinRowColFor3x3(col);
        int maxRow = getMaxRowColFor3x3(row);
        int maxCol = getMaxRowColFor3x3(col);

        for (int i = minRow; i < maxRow; i++) {
            for (int j = minCol; j < maxCol; j++) {
                if (i == row && j == col || board[row][col] == '.' || board[i][j] == '.')
                    continue;

                if (board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }

    static int getMinRowColFor3x3(int rowCol) {
        rowCol = rowCol / 3;
        switch (rowCol) {
            case 0:
                return 0;
            case 1:
                return 3;
            default:
                return 6;
        }
    }

    static int getMaxRowColFor3x3(int rowCol) {
        rowCol = rowCol / 3;
        switch (rowCol) {
            case 0:
                return 3;
            case 1:
                return 6;
            default:
                return 9;
        }
    }

}
