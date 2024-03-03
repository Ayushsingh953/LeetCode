// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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

    int length(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = length(head);
        ListNode node = head;
        int pos = 1;
        while (pos < len - n) {
            node = node.next;
            pos++;
        }

        if (len == n)
            head = head.next;

        else if (node.next == null)
            return null;

        else
            node.next = node.next.next;

        return head;
    }
}