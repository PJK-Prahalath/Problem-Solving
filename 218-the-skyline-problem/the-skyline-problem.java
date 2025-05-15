class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int max=0,right=0,prev=-1;
        for(int i=0;i<buildings.length;i++){
            while(!pq.isEmpty() && buildings[i][0]>right){
                pq.poll();
                if(pq.isEmpty()){
                    ans.add(new ArrayList<>(Arrays.asList(right,0)));
                    prev=0;
                    break;
                }
                max=pq.peek()[0];
                if(max!=prev && right<pq.peek()[1]){
                    ans.add(new ArrayList<>(Arrays.asList(right,max)));
                    prev=max;
                }
                right=Math.max(right,pq.peek()[1]);
            }

            pq.add(new int[]{buildings[i][2],buildings[i][1]});
            max=pq.peek()[0];
            right=pq.peek()[1];

            if(i<buildings.length-1 && buildings[i+1][0]==buildings[i][0]){
                continue;
            }

            if(max!=prev){
                ans.add(new ArrayList<>(Arrays.asList(buildings[i][0],max)));
                prev=max;
            }
        }

        
        while(!pq.isEmpty()){
            pq.poll();
            if(pq.isEmpty()){
                ans.add(new ArrayList<>(Arrays.asList(right,0)));
                break;
            }
            max=pq.peek()[0];
            if(max!=prev && right<pq.peek()[1]){
                ans.add(new ArrayList<>(Arrays.asList(right,max)));
                prev=max;
            }
            right=Math.max(right,pq.peek()[1]);
        }
        return ans;
    }
}