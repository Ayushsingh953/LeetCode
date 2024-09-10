// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null) return head;

        ListNode firstNode = head;
        ListNode secNode = head.next;
        while(secNode!=null){
            int gcd = findGcd(firstNode.val,secNode.val);
            ListNode newNode = new ListNode(gcd);
            firstNode.next = newNode;
            newNode.next = secNode;
            firstNode = secNode;
            secNode = secNode.next;
        }

        return head;
    }

    public int findGcd(int a,int b){
        if(a<b){
            a = a^b;
            b = a^b;
            a = a^b;
        }
        if(b==0) return a;
        return findGcd(b,a%b);
    }
}