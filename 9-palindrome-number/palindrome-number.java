class Solution {
    public boolean isPalindrome(int x) 
    {
        int sum=0;
        int n=x;
        if(x<0)
        {
            return false;
        }
        while(n!=0)
        {
            int rem=n%10;
            sum = (sum*10)+rem;
            n=n/10;
        }
        return sum==x;
    }
}