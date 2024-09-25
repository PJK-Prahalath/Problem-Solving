class Solution 
{
    public boolean isPerfectSquare(int num) 
    {
        int a = (int)Math.sqrt(num);
        return num==a*a;
    }
}