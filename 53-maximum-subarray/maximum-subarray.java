class Solution {
    public int maxSubArray(int[] nums) 
    {
        int n = nums.length;
        int sum=0,max=0;
        if(n==1)
        {
            return nums[0];
        }
        int pos = 0;
        for(int i=0;i<n;i++)
        {
            if(nums[i] > 0)
            {
                pos = 1;
            }
        }
        if(pos == 1)
        {
            for(int i=0;i<n;i++)
            {
                sum = sum + nums[i];
                if(sum<0)
                {
                    sum=0;
                }
                if(sum>=max)
                {
                    max=sum;
                }
                
            }
            return max;
        }
        else
        {
            int ans = nums[0];
            for(int i=0;i<n;i++)
            {
                if(nums[i] > ans)
                {
                    ans = nums[i];
                }
            }
            return ans;
        }
    }
}