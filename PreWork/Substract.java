package com.namrata;

/**
 * 
 *

 SUBTRACT

 Given a singly linked list, modify the value of first half nodes such that :

 1st node’s new value = the last node’s value - first node’s current value
 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 and so on …

 NOTE :
 * If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 * If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
 Example :

 Given linked list 1 -> 2 -> 3 -> 4 -> 5,

 You should return 4 -> 2 -> 3 -> 4 -> 5
 as

 for first node, 5 - 1 = 4
 for second node, 4 - 2 = 2
 Try to solve the problem using constant extra space.

 */
public class Substract {

    public ListNode subtract(ListNode A) {

        ListNode curr1 = A;
        ListNode slow = A;
        ListNode fast = slow.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        ListNode temp = reverseList(slow.next);
        ListNode secondHalf = temp;
        while(curr1 != null && secondHalf != null) {
            curr1.val = secondHalf.val - curr1.val;
            curr1 = curr1.next;
            secondHalf = secondHalf.next;
        }
        reverseList(temp);

        return A;
    }

    public ListNode reverseList(ListNode slow) {
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        slow = prev;

        return slow;
    }

}

 //Definition for singly-linked list.
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) {
          val = x; next = null;
      }
}


