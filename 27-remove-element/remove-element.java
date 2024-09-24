class Solution 
{
    public int removeElement(int[] nums, int val) 
    {
        // int a=0,x=Integer.MAX_VALUE;
        // for(int i=0;i<nums.length;i++)
        // {
            // if(nums[i]==val)
            // {
                // nums[i]=x;
            // }
            // else
            // {
                // a++;
            // }
        // }
        // Arrays.sort(nums);
        // return a;

        int l=0,temp=0;
        for(int r=0;r<nums.length;r++)
        {
            if(nums[r]!=val)
            {
                temp = nums[r];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }
        return l;
    }
}