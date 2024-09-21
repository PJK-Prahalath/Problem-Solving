class Solution {
    public int longestConsecutive(int[] nums) 
    {
        int n = nums.length;
        Arrays.sort(nums);
        int a=0;
        ArrayList<Integer> map = new ArrayList<>();
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                continue;
            }
            else if(nums[i]+1==nums[i+1])
            {
                a++;
            }
            else
            {
                map.add(a);
                a=0;
            }
        }
        map.add(a);
        return Collections.max(map)+1;
    }
}