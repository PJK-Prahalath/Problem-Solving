class Solution 
{
    public int countPairs(List<Integer> nums, int target) 
    {
        int c=0;
        for(int i=0;i<nums.size();i++)
        {
            for(int j=i+1;j<nums.size();j++)
            {
                int a = nums.get(i);
                if(a+nums.get(j)<target)
                {
                    c++;
                }
            }
        }
        return c;
    }
}