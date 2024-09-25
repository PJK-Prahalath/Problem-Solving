class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int n = nums.length;
        int a = n*(n+1)/2;
        int b = 0;
        for (int i : nums) 
        {
            b = b + i;
        }
        return a-b;
    }
}
