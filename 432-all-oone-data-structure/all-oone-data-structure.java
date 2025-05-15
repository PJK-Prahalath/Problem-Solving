class Node {
    int freq;
    Set<String> keySet;
    Node prev, next;
    public Node(int freq, Set<String> keySet) {
        this.freq= freq;
        this.keySet = keySet;
    }
}

class AllOne {
    Node head = new Node(0,new HashSet<>());
    Node tail = new Node(0,new HashSet<>());
    
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }
    

    private void addNewNode(Node newNode, Node prevNode, Node nextNode) {
        prevNode.next = newNode;
        nextNode.prev = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
    }


    public void inc(String key) {
        // fetch the node from the map for the key
        // if exists then go the node and remove the key from the set and add the key to the next node set
        if(map.containsKey(key)) {
            Node node = map.get(key);
            int freq = node.freq;
            node.keySet.remove(key);
            map.remove(key);
            Node nextNode = node.next;
            if(nextNode.freq != freq+1) {
                // case when the node is not present with the freq
                Node newNode = new Node(freq+1, new HashSet<>());
                newNode.keySet.add(key);
                addNewNode(newNode, node, nextNode);
                map.put(key, newNode);
            }
            else {
                nextNode.keySet.add(key);
                map.put(key, nextNode);
            }

            if(node.keySet.size() == 0) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

        }
        //if not exists, then
            // check for the head next node with the freq 1
            // if not exists then create the node with freq 1 and add the key to the set
        else {
            if(head.next.freq != 1) {
                Node newNode  = new Node(1, new HashSet<>());
                newNode.keySet.add(key);
                addNewNode(newNode, head, head.next);
                map.put(key, newNode);
            }
            // if exists then add the key to the node set
            else {
                Node headNext = head.next;
                headNext.keySet.add(key);
                map.put(key, headNext);
            }
        }
        
    }
    
    public void dec(String key) {
         if(map.containsKey(key)) {
            Node node = map.get(key);
            int freq = node.freq;
            node.keySet.remove(key);
            map.remove(key);

            Node prevNode = node.prev;
            if(freq == 1) {
                node.keySet.remove(key);
            }
            else if(prevNode.freq != freq-1) {
                Node newNode = new Node(freq-1, new HashSet<>());
                newNode.keySet.add(key);
                addNewNode(newNode, prevNode, node);
                map.put(key, newNode);
            }
            else {
                prevNode.keySet.add(key);
                map.put(key, prevNode);
            }

            if(node.keySet.size() == 0) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    
    }
    
    public String getMaxKey() {
        // get any value from the node set which is the prev to the tail of the deque
        return tail.prev.keySet.iterator().hasNext() ? tail.prev.keySet.iterator().next() : "";
    }
    
    public String getMinKey() {
        // get any value from the node set which is the next to the head of the deque
        return head.next.keySet.iterator().hasNext() ? head.next.keySet.iterator().next() : "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */