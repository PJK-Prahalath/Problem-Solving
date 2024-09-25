class Solution {
    public int hammingWeight(int n) 
    {
        String a = "";
        int rem=0;
        while(n>0)
        {
            rem=n%2;
            a=a+(String.valueOf(rem));
            n=n/2;
        }
        n = a.length();
        rem=0;
        for(int i=0;i<n;i++)
        {
            if(a.charAt(i)=='1')
            {
                rem++;
            }
        }
        return rem;
    }
}