class Solution {
    
    private int[] dr = new int[]{0, 1};
    private int[] dc = new int[]{1, 0};
    
    public int calculateMinimumHP(int[][] dungeon) {
        
        int M = dungeon.length, N = dungeon[0].length;
        int[][] maxHealthSum = new int[M][N]; // maxHealthSum[i][j] means the max health sum at (i, j)
        
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                maxHealthSum[i][j] = Integer.MIN_VALUE;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[3] - a[3]); // [x, y, sum value on the path, min sum]
        
        pq.offer(new int[]{0, 0, dungeon[0][0], dungeon[0][0]});
        
        while (!pq.isEmpty())
        {
            int[] vals = pq.poll();
            int x = vals[0], y = vals[1], sum = vals[2], minSum = vals[3];
            
            if (sum < maxHealthSum[x][y])
                continue;
            else
                maxHealthSum[x][y] = sum;
            
            if (x == M-1 && y == N-1)
            {
                if (minSum < 0)
                    return 1 - minSum;
                else
                    return 1;
            }
            
            for (int k = 0; k < 2; k++)
            {
                int r = x + dr[k], c = y + dc[k];
                
                if (r >= 0 && r < M && c >= 0 && c < N)
                    pq.offer(new int[]{r, c, sum + dungeon[r][c], Math.min(minSum, sum + dungeon[r][c])});
            }
        }
        
        return 1;
    }
}