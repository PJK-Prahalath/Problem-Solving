class Solution {
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        int n1=ransomNote.length();
        int n2=magazine.length();
        char a[] = ransomNote.toCharArray();
        char b[] = magazine.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n2;i++)
        {
            if(map.containsKey(b[i]))
            {
                map.put(b[i],map.get(b[i])+1);
            }
            else
            {
                map.put(b[i],1);
            }
        }
        
        for(int i=0;i<n1;i++)
        {
            if(!map.containsKey(a[i])||map.get(a[i])==0)
            {
                return false;
            }
            map.put(a[i],map.get(a[i])-1);
        }
        
        return true;
    }
}