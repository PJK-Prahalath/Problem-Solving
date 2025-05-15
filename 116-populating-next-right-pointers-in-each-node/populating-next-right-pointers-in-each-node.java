class Solution {
    public Node connect(Node root) {
        Node head = root;
         for(head = root; head != null;){
             
             if(head.left == null){                  // if left is null then it means no children nodes to connect now
                 return root;
             }
             Node prev = null;
             Node curr = head;                      //curr always pointing starting node of every level in starting
             
             while(curr != null){
                 
                if(prev != null)                             //  for first node of every level, prev pointing to null
                prev.right.next = curr.left;          //connect prev node right to curr left node
                curr.left.next = curr.right;          // connect same children nodes of parent 
                 
                 prev = curr;                              // move prev and curr node to next node
                 curr = curr.next;
             }
             head = head.left;                        // move head to next level
         }
        return root;
    }
}