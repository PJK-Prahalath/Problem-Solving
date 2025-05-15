class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int l = envelopes.length;
        int max=1;
        Arrays.sort(envelopes, (a,b)-> {
            if(a[0]==b[0]){
                return b[1]-a[1];
               }
                return a[0]-b[0];
            });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0; i< l ;i++){
           Integer ceilingKey = map.ceilingKey(envelopes[i][1]);
                if(ceilingKey==null){
                    map.put(envelopes[i][1], 1);
                }else{
                    map.remove(ceilingKey);    
                    map.put(envelopes[i][1],  1);
                }
            max = Math.max(max, map.size());
        }
        return max;        
    }
}