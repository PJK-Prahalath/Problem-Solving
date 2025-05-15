class Solution {
    static int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        return find(grid, m-1, n-1, memo);
    }
    
    private int find(int[][] grid, int m, int n, int[][] memo){
        if(m==0 && n==0)
            return grid[0][0];
        else if(m<0 || n<0)
            return Integer.MAX_VALUE;
        else if(memo[m][n]!=0)
           return memo[m][n];
        return memo[m][n] = grid[m][n] + Math.min(find(grid, m-1, n, memo), find(grid, m, n-1, memo));
    }
}