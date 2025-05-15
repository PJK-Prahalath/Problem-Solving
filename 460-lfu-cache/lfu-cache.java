class LFUCache {
    // map to store what keys we have, along with its node
    private Map<Integer, Node> cache;
    // map to store the nodes (in a doubly linked list) 
    // mapped to the number of times (frequency) they've been used
    private Map<Integer, List> freqMap;
    // globally storing the assigned capacity, current cache size 
    // and the minimum frequency so far that ad node has been used for
    private int capacity, currSize, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {  // if not present
            return -1;       // return -1
        }
        updateNode(node);    // frequency increases
        return node.value;   // return the value
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {    // if capacity is 0, can't add any key 
            return;            
        }
        // if key is already present
        if (cache.containsKey(key)) {
            Node node = cache.get(key); // get that node
            node.value = value;         // update the value with new value
            updateNode(node);    // this node now becomes most recently used, so update it
        } else {
            currSize++;
            // evict the LFU node, if multiple exists, remove the LRU
            if (currSize > capacity) {  
                // get the LFU list
                List minFreqList = freqMap.get(minFreq);
                // Remove the LRU from it, if multiple exists
                // the LRU node is the 2nd last node in the list, so remove the key from cache
                Node LRU_Node = minFreqList.tail.prev;
                cache.remove(LRU_Node.key);
                // now remove the node itself from the list
                minFreqList.removeFromList(LRU_Node);
                currSize--;     // we are ready to accomodate now
            }

            // as a new key has been passed, it's frequency will be 1 
            // So mininum frequency will be reset to 1
            minFreq = 1;
            Node newNode = new Node(key, value);    // create a new node for this new key
            // we will add it to list of frequency 1, if frequency 1 exists in freqMap
            List minFreqList = freqMap.getOrDefault(1, new List());
            minFreqList.addToList(newNode);
            freqMap.put(1, minFreqList);    // put this list back to freqMap
            cache.put(key, newNode);        // also put it in cache
        }
    }

    private void updateNode(Node node) {
        int currFreq = node.freq;       // get node's current frequency
        List currList = freqMap.get(currFreq);  // get the list of that particular frequency
        currList.removeFromList(node);  // remove this node from that list as the frequency has changed

        // in case this node's frequnecy is minimum frequency 
        // and it was the only node the in list of its frequency
        // minimum frequency will increment by 1
        if (currFreq == minFreq && currList.size == 0) {
            minFreq++;  
        }

        node.freq++;    // node's frequency increments
        // we will get the list (if exists) of this frequency
        List newList = freqMap.getOrDefault(node.freq, new List());
        newList.addToList(node);            // add the node to that list
        freqMap.put(node.freq, newList);    // and put the list back to the freqMap
    }

    // Node class
    private class Node {
        int key, value, freq; // freq is the number of times this node has been used for
        Node next, prev;      // next and previous nodes
        // constructor
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;    // when we create a new node, its frequency is 1
        }
    }

    // Doubly Linked List class
    private class List {
        int size;           // to store the size of the list
        Node head, tail;    // head and tail nodes
        // constructor
        private List() {
            this.size = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        // method to add new node to the list
        private void addToList(Node node) {
            Node headNext = head.next;
            head.next = node;
            node.next = headNext;
            headNext.prev = node;
            node.prev = head;
            size++;     // size increments when a new node is added
        }

        // method to remove a node from the list
        private void removeFromList(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;     // size decrements when a node is removed
        }
    }
}