class Solution {
    public int lengthOfLastWord(String s) {
        char a[] = s.toCharArray();
        int n = a.length;
        int k=0,c=0;
        for(int i=n-1;i>=0;i--)
        {
            if(a[i]>='a'&&a[i]<='z'||a[i]>='A'&&a[i]<='Z')
            {
                k=i;
                break;
            }
        }
        for(int i=k;i>=0;i--)
        {
            if(a[i]==' ')
            {
                break;
            }
            else
            {
                c++;
            }
        }
        return c;
    }
}