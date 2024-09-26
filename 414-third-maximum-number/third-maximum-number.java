class Solution 
{
    public int thirdMax(int[] nums) 
    {
        int n = nums.length;
        if(n<3)
        {
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                if(nums[i]>max)
                {
                    max=nums[i];
                }
            }
            return max;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        int a[] = new int[set.size()];
        int k=0;
        for(int num : set)
        {
            a[k++] = num;
        }
        n = a.length;
        if(n<3)
        {
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                if(a[i]>max)
                {
                    max=a[i];
                }
            }
            return max;
        }
        else
        {
            int max = Integer.MIN_VALUE;
            int index=0;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(a[j]>max)
                    {
                        max=a[j];
                        index = j;
                    }
                }
                if(i<2)
                {
                    a[index] = Integer.MIN_VALUE;
                    max = Integer.MIN_VALUE;
                }
            }
            return max;
        }
    }
}   