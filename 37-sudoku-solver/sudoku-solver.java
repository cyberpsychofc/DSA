class Solution {
    public static boolean solve(char[][] board) {
        // board traversal
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // if this position is empty
                if (board[row][col] == '.') {
                    // check for possible digits
                    for (char c = '1'; c <= '9'; c++) {
                        // check if this is already present
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;

                            if (solve(board) == true)   // if valid
                                return true;
                            // else backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == c)
                return false;
            // check col
            if (board[i][col] == c)
                return false;
            // check indv. grid of 3
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}