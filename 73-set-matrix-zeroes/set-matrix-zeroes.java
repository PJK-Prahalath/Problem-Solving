import java.util.HashSet;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Sets to track rows and columns that need to be zeroed
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();

        // First pass: Identify which rows and columns need to be zeroed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // Second pass: Zero out rows
        for (int row : zeroRows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }

        // Third pass: Zero out columns
        for (int col : zeroCols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}