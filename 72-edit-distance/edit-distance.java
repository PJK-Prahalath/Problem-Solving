class Solution {
    // //Recurrsion
    // public int minDistance(String s1, String s2) {
    //     int n= s1.length();
    //     int m= s2.length();
    //     return f(s1, s2, n-1, m-1);
    // }

    // public int f(String s1, String s2, int ind1, int ind2){
    //     if(ind1 < 0) return ind2+1; // base case, here we will be deleting the remaining elements to match the other string
    //     if(ind2 < 0) return ind1+1;

    //     if(s1.charAt(ind1) == s2.charAt(ind2)){  // if matched then no operation needed
    //         return 0 + f(s1, s2, ind1-1, ind2-1);
    //     }else{
    //         int insert=  f(s1, s2, ind1, ind2-1); //hypostetically inserting so just imagine the it was added and stay ind1 on same posi
    //         int delete=  f(s1, s2, ind1-1, ind2); // deleted so move ind1 - 1
    //         int replace=  f(s1, s2, ind1-1, ind2-1); // replaced so moved voth ind by -1
    //         return  1 + Math.min(insert, Math.min(delete, replace));
    //     }
    // }


    //Memoization
    // public int minDistance(String s1, String s2) {
    //     int n= s1.length();
    //     int m= s2.length();
    //     int[][] dp= new int[n][m];
    //     for(int[] rows : dp){
    //         Arrays.fill(rows, -1);
    //     }
    //     return f(s1, s2, n-1, m-1, dp);
    // }

    // public int f(String s1, String s2, int ind1, int ind2, int[][] dp){
    //     if(ind1 < 0) return ind2+1;
    //     if(ind2 < 0) return ind1+1;

    //     if(dp[ind1][ind2] != -1){
    //         return dp[ind1][ind2];
    //     }

    //     if(s1.charAt(ind1) == s2.charAt(ind2)){
    //         return dp[ind1][ind2]= 0 + f(s1, s2, ind1-1, ind2-1, dp);
    //     }else{
            // int insert=  f(s1, s2, ind1, ind2-1, dp);
            // int delete=  f(s1, s2, ind1-1, ind2, dp);
            // int replace=  f(s1, s2, ind1-1, ind2-1, dp);
    //         return dp[ind1][ind2]= 1 + Math.min(insert, Math.min(delete, replace));
    //     }
    // }

     //Tabulation
    public int minDistance(String s1, String s2) {
        int n= s1.length();
        int m= s2.length();
        int[][] dp= new int[n+1][m+1];
        
        for(int i=0; i<= m; i++){  // adding base case, and as we have done shifting of indexes, 1 index has been shifted to left side, so we are taking  dp[0][i]= i and not i+1
            dp[0][i]= i;
        }

        for(int i=0; i<=n; i++){
            dp[i][0]= i;
        }

        for(int i= 1; i<=n; i++){
           for(int j=1; j<=m; j++){
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j]= 0 + dp[i-1][j-1];
               }else{
                int insert = dp[i][j-1];
                int delete = dp[i-1][j];
                int replace = dp[i-1][j-1];
                dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
               }
           }
        }
        return dp[n][m];
    }
}