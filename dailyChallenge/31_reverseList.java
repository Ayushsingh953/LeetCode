// https://leetcode.com/problems/reverse-linked-list/

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


//using Stack and loop
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
       Stack<ListNode> s=new Stack<>();
       ListNode temp=head;
       while(temp!=null){
        s.push(temp);
        temp=temp.next;
       }
       temp=s.pop();
       head=temp;
       while(!s.empty()){
        temp.next=s.pop();
        temp=temp.next;
       }
       temp.next=null;
       return head;
    }
}


//Using loop only
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;

        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head=prev;
        return head;
    }
}

// Using recursion
class Solution3 {
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