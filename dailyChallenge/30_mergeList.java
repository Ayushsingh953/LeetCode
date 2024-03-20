// https://leetcode.com/problems/merge-in-between-linked-lists/

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy=new ListNode(),temp=list1;
        dummy.next=list1;
        int counter=0;
        while(counter<b){
            temp=temp.next;
            counter++;
        }
        counter=1;
        while(counter<a){
            list1=list1.next;
            counter++;
        }
        list1.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=temp.next;
        
        return dummy.next;
    }
}