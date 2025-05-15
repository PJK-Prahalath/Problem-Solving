class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> obj = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        Arrays.sort(strs);

        for(int i=0; i<strs.length; i++){
            if(visited[i]) continue;

            List<String> obj2 = new ArrayList<>();
            String str1 = strs[i];
            obj2.add(str1);
            visited[i] = true;

            for(int j=i+1; j<strs.length; j++){
                if(visited[j]) continue;

                String str2 = strs[j];

                if(str1.length() == str2.length()){
                    char[] charArray1 = str1.toCharArray();
                    char[] charArray2 = str2.toCharArray();
                    Arrays.sort(charArray1);
                    Arrays.sort(charArray2);

                    if(Arrays.equals(charArray1, charArray2)){
                        obj2.add(str2);
                        visited[j] = true;
                    }
                }
            }
            obj.add(obj2);
        }
        return obj;
    }
}