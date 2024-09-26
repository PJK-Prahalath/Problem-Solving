class Solution 
{
    public int[] singleNumber(int[] nums) 
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
        }
        int j=0;
        int a[] = new int[2];
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue()==1)
            {
                a[j] = entry.getKey();
                j++;
            }
        }
        return a;
    }
}