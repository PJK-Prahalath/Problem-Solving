class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        int n = numbers.length;
        int a[] = new int[2];
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(numbers[i]+numbers[j]==target)
                {
                    a[0] = i+1;
                    a[1] = j+1;
                    Arrays.sort(a);
                    return a;
                }
            }
        }
        return a;
        
    }
}