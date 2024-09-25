class Solution {
    public int findDuplicate(int[] nums) 
    {
        HashMap <Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
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
        for(HashMap.Entry<Integer,Integer> key : map.entrySet())
        {
            if(key.getValue()>1)
            {
                return key.getKey();
            }
        }
        return 0;
    }
}