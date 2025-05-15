/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // eliminate **NULLPOINTERERROR**
        if(head==null || k==0){
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while(temp.next!=null){
            temp=temp.next;
            count++;
        }
        // eliminate **Time Limit Excedeed**
        k %= count;
        // convert the right rotation in left rotation
        k=count-k;
        
        while(k>0){
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = null;
            k--;
        }
        return head;
    }
}