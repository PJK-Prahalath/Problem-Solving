class Solution {

    static int[] dp;

    static int canReach(int[] nums, int currentIndex) {

        if (currentIndex >= nums.length - 1) {
            return 0;
        }

        if(dp[currentIndex]!=-1){
            return dp[currentIndex];
        }

        int maxJump = nums[currentIndex];

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= maxJump; i++) {

            int rec = canReach(nums, i + currentIndex);

            if (rec != Integer.MAX_VALUE) {
                rec = rec + 1;
            }

            ans = Math.min(ans, rec);

        }

        return dp[currentIndex]=ans;

    }

    public int jump(int[] nums) {

        dp= new int[nums.length+1];

        for(int i=0;i<=nums.length;i++){
            dp[i]=-1;
        }

        return canReach(nums, 0);

    }
}