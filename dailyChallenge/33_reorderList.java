// https://leetcode.com/problems/reorder-list/

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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode temp=head;
        ListNode temp1=head;
        Stack<ListNode> s=new Stack<ListNode>();
        int size=0;
        while(temp!=null){
            s.push(temp);
            size++;
            temp=temp.next;
        }
        for(int i=0;i<size/2;i++){
            ListNode ele=s.pop();
            ele.next=temp1.next;
            temp1.next=ele;
            temp1=temp1.next.next;
        }
        temp1.next=null;
    }
}