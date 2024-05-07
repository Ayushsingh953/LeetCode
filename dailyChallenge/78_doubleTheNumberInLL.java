// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/

import java.util.Stack;

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


 public class Solution {
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> values = new Stack<>();
        int val = 0;
        while (head != null) {
            values.push(head.val);
            head = head.next;
        }

        ListNode newTail = null;

       
        while (!values.isEmpty() || val != 0) {
     
            newTail = new ListNode(0, newTail);
            if (!values.isEmpty()) {
                val += values.pop() * 2;
            }
            newTail.val = val % 10;
            val /= 10;
        }

        return newTail;
    }
}
 

public class Solution2 {
    public ListNode doubleIt(ListNode head) {
        // If the value of the head node is greater than 4, 
        // insert a new node at the beginning
        if (head.val > 4) {
            head = new ListNode(0, head);
        }
        
        // Traverse the linked list
        for (ListNode node = head; node != null; node = node.next) {
            // Double the value of the current node 
            // and update it with the units digit
            node.val = (node.val * 2) % 10;
            
            // If the current node has a next node 
            // and the next node's value is greater than 4,
            // increment the current node's value to handle carry
            if (node.next != null && node.next.val > 4) {
                node.val++;
            }
        }
        
        return head;
    }
}