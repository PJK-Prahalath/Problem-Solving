// Trie + Memoization
// Beats 94%
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> list= new ArrayList<String>();
        Trie trie = new Trie();
        for(String x:words){
            insert(x,trie);
        }
        for(String x:words){
            if(solve(x,trie,0,1,new Boolean[x.length()],0))
                list.add(x);
        }
        return list;
    }


    private boolean solve(String s,Trie trie,int i,int j,Boolean[] memo,int c){
        if(i==s.length()){
            return c>1; // more than 1 string
        }
        if(memo[i]!=null){
            return memo[i];
        }
        Trie dict = trie;
        for(int k=i;k<s.length();k++){
            dict = dict.a[s.charAt(k)-'a'];
            if(dict==null){
                return memo[i] = false;
            }
            if(dict.stop){
                if(solve(s,trie,k+1,k+2,memo,c+1))
                   return true;
            }
        }
        return memo[i] = false;
    } 
    
    private void insert(String s,Trie trie){
        for(char ch:s.toCharArray()){
            if(trie.a[ch-'a']==null) {
                trie.a[ch-'a'] = new Trie();
            }
            trie=trie.a[ch-'a'];
        }
        trie.stop=true;
    }
}

class Trie{
    Trie[] a;
    boolean stop;

    public Trie(){
        a=new Trie[26];
        stop=false;
    } 
}