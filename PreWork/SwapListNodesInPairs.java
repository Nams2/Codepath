/*

Swap List Nodes in pairs
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode a) {
        if(a==null || a.next==null) {
            return a;
        }
        
        ListNode result = new ListNode(0);
        result.next = a;
        ListNode p = result;
        
        while(p.next!=null && p.next.next!=null) {
            ListNode temp1 = p;
            p = p.next;
            temp1.next = p.next;
            
            ListNode temp2 = p.next.next;
            p.next.next = p;
            p.next = temp2;
        }
        
        return result.next;
    }
}
