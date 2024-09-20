class Solution {
    public boolean isPalindrome(String s) 
    {
        int n=s.length(),j=0,c=0;
        s=s.toLowerCase();
        List<Character> a = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9'))
            {
                a.add(s.charAt(i));
                j++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='0'&&s.charAt(i)<='9')
            {
                if(s.charAt(i)==a.get(j-1))
                {
                    j--;
                    c++;
                }
            }
        }
        n=a.size();
        return(c==n);
    }
}