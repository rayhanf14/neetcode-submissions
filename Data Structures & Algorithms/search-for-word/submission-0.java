class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, String word, int r, int c, int idx) {
        // Out of bounds
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        // Entire word matched
        if (idx == word.length() - 1) {
            return true;
        }

        // Mark as visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore all four directions
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (dfs(board, word, nr, nc, idx + 1)) {
                board[r][c] = temp; // Restore before returning
                return true;
            }
        }

        // Backtrack
        board[r][c] = temp;
        return false;
    }
}