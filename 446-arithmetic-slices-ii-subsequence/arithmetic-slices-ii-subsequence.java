class Solution {
    public int arr[];
    Map<String, Long> dp;
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        dp = new HashMap<>();
        long ans = 0;
        arr = nums;
        for(int i = 0; i < n ; i++){
            for(int j = i+1; j < n; j++){
                ans +=  findDiff(j, (long)nums[j]-nums[i]);
            }
        }
        return (int)ans;
    }
    public long findDiff(int ind, long diff){

        // base case
        if(ind == arr.length) return 0;
        String str = ind + "-" + diff;
        if(dp.containsKey(str)) return dp.get(str);
        long count = 0;
        for(int i = ind+1; i < arr.length; i++){
             if((long)arr[i]-arr[ind] == diff){
                 count += 1 + findDiff(i, diff);
             }
        }
        dp.put(str, count);
        return count;
    }
}