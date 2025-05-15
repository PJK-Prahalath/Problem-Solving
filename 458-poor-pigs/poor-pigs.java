class Solution
{
    public int poorPigs(int balti, int die_time, int test_time)
    {
        int rez = test_time/die_time;
        int i=0;
        while(Math.pow(rez+1,i)< balti)
        {
            i++;
        }
        return i;
    }
}