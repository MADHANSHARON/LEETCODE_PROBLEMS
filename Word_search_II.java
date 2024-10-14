class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (depthFirstSearch(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean depthFirstSearch(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '*'; // Mark the cell as visited

        // Explore the four neighboring directions: right, down, left, up
        int[][] offsets = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int[] offset : offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            if (depthFirstSearch(board, word, newRow, newCol, index + 1)) {
                return true;
            }
        }

        board[row][col] = temp; // Restore the cell's original value
        return false;
    }
}
