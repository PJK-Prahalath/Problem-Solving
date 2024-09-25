class Solution {
    public int addDigits(int num) 
    {
        int sum=0;
        int rem=0;
        while(num>9)
        {
            sum=0;
            while(num!=0)
            {
                rem=num%10;
                sum=sum+rem;
                num=num/10;
            }
            num=sum;
        }
        return num;
    }
}