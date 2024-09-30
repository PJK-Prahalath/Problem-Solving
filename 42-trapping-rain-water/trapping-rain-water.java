class Solution {
    public int trap(int[] height) 
    {
        int left=0;
        int right=height.length-1;
        int leftmax=height[0];
        int rightmax=height[height.length-1];
        int sum=0;
        while(left<right)
        {
            if(leftmax<rightmax)
            {
                left++;
                leftmax=Math.max(leftmax,height[left]);
                sum=sum+(leftmax-height[left]);
            }
            else
            {
                right--;
                rightmax=Math.max(rightmax,height[right]);
                sum=sum+(rightmax-height[right]);
            }
        }
        return sum;
    }
}