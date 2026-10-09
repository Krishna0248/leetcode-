
class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    static boolean solve(char[][] board) {

        int n = 9;

        // Find an empty cell
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == '.') {

                    // Try digits 1 to 9
                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isSafe(board, row, col, ch)) {

                            // Place the digit
                            board[row][col] = ch;

                            // Recursive call
                            if (solve(board)) {
                                return true;
                            }

                            // Backtracking
                            board[row][col] = '.';
                        }
                    }

                    // No digit works for this cell
                    return false;
                }
            }
        }

        // No empty cells remain
        return true;
    }

    static boolean isSafe(char[][] board, int row,
                          int col, char ch) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == ch) {
                return false;
            }

            // Check column
            if (board[i][col] == ch) {
                return false;
            }

            // Check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == ch) {
                return false;
            }
        }

        return true;
    }
}