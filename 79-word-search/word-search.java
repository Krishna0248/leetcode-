
class Solution {
    static boolean solve(char[][] board, String word, int i, int j, int index) {

        // Base case: saare characters match ho gaye
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        // Character match nahi hua
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // Current cell ko visited mark karo
        char ch = board[i][j];
        board[i][j] = '#';

        // 4 directions mein recursion
        boolean ans =
            solve(board, word, i + 1, j, index + 1) ||
            solve(board, word, i - 1, j, index + 1) ||
            solve(board, word, i, j + 1, index + 1) ||
            solve(board, word, i, j - 1, index + 1);

        // Backtracking: original character restore karo
        board[i][j] = ch;

        return ans;
    }

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (solve(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
