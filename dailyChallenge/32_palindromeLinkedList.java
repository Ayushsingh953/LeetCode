// https://leetcode.com/problems/palindrome-linked-list/

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

//Using stack
class Solution1 {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s=new Stack<Integer>();
        ListNode temp=head;
        while(temp!=null){
            s.push(temp.val);
            temp=temp.next;
        }
        while(head!=null){
            if(head.val!=s.pop()){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}

//Using recursion
class Solution2 {
    ListNode cur;
    public boolean isPalindrome(ListNode head) {
        cur=head;
        return check(head);
    }
    public boolean check(ListNode head){
        if(head==null){
            return true;
        }
        boolean ans=check(head.next) && head.val==cur.val;
        cur=cur.next;
        return ans;
    }
}

//Reversing the middle half of list
class Solution3 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rev=reverse(slow.next);
        while(rev!=null){
            if(head.val!=rev.val){
                return false;
            }
            rev=rev.next;
            head=head.next;
        }
        return true;

    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}