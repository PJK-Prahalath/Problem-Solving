class Solution {
    public int minPatches(int[] nums, int n) {
        int minPatch = 0, i = 0;
        long max = 1;

        while(max <= n) {

            if(i < nums.length && nums[i] <= max) max += nums[i++];
            else {
                minPatch++;
                max += max;
            }
        }

        return minPatch;
    }
}
