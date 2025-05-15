class Solution {
    private boolean solve(int i, int j, int ind, int m, int n, String word, char[][] board, boolean[][] vis) {
        if (ind == word.length()) return true;

        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || board[i][j] != word.charAt(ind)) return false;

        vis[i][j] = true;

        if (solve(i - 1, j, ind + 1, m, n, word, board, vis)) return true;
        if (solve(i + 1, j, ind + 1, m, n, word, board, vis)) return true;
        if (solve(i, j + 1, ind + 1, m, n, word, board, vis)) return true;
        if (solve(i, j - 1, ind + 1, m, n, word, board, vis)) return true;

        vis[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] vis = new boolean[m][n];
                    if (solve(i, j, 0, m, n, word, board, vis)) return true;
                }
            }
        }
        return false;
    }
}