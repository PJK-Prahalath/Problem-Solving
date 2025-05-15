class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map = new HashMap();
        for(List<String> ticket:tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            map.putIfAbsent(source,new PriorityQueue());
            map.get(source).add(destination);
        }
        LinkedList<String> list = new LinkedList();
        depthFirstSearch("JFK",map,list);
        return list;
    }   
    // here s = current source
    void depthFirstSearch(String s,Map<String,PriorityQueue<String>> map,
    LinkedList<String> list){
        PriorityQueue<String> q = map.get(s);
        while(q != null && !q.isEmpty()){
            String nextSource = q.poll();
            depthFirstSearch(nextSource,map,list);
        }
        list.addFirst(s);
    }
}