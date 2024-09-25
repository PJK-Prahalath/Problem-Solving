class Solution 
{
    public int findNumbers(int[] nums) 
    {
        int c = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            String a = String.valueOf(nums[i]);
            if(a.length()%2==0)
            {
                c++;
            }
        }
        return c;
    }
}