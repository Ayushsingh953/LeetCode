// https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>  numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        while(numSet.contains(head.val)){
            head = head.next;
        }
        ListNode temp = head;
        while(temp!=null && temp.next!=null){
            if(numSet.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}