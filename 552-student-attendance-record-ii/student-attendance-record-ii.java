class Solution {
    int ans = 0, mod = 1000000007;
    Integer[][][] dp;
    public int checkRecord(int n) {
        dp = new Integer[100001][2][3];
        return solve(n, 0, 0);
    }
    private int solve(int n, int ac, int clc){
        if(n == 0){
            return 1;
        }
        if(dp[n][ac][clc] != null) return dp[n][ac][clc];
        int ans = 0;
        ans = (ans + solve(n-1, ac, 0))%mod;
        if(ac < 1)
            ans = (ans + solve(n-1, ac+1, 0))%mod;
        if(clc < 2)
            ans = (ans + solve(n-1, ac, clc + 1))%mod;
        return dp[n][ac][clc] = ans%mod;
    }
}