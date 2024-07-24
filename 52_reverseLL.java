// https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75

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

 // Using recursion
class Solution {
    ListNode newHead;
    public ListNode reverseList(ListNode head) {
       if(head==null){
        return head;
       }
       reverseHelper(head);
       return newHead;
    }
    public ListNode reverseHelper(ListNode head){
        if(head.next==null){
            return newHead=head;
        }
        ListNode nextNode=reverseHelper(head.next);
        nextNode.next=head;
        head.next=null;
        return head;
    }
}

// Iterative
class Solution2 {
    ListNode newHead;
    public ListNode reverseList(ListNode head) {
       if(head==null || head.next==null){
        return head;
       }
       ListNode prev = null;
       ListNode cur = head;

       while(cur!=null){
       ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
       } 
       return prev;
    }
}