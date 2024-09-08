// https://leetcode.com/problems/split-linked-list-in-parts/

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;
        }

        ListNode[] res = new ListNode[k];
        int i = 0;
        if(n<k){
            while(n>0){
                res[i++] = new ListNode(head.val);
                head = head.next;
                n--;
            }
            while(i<k){
                res[i++] = null;
            }
        }else{
            int parts = n/k;
            int rem = n%k;

            while(i<k){
                int size = parts;
                if(rem>0){
                    rem--;
                    size++;
                }
                ListNode newNode = new ListNode(0);
                ListNode node = newNode;
                while(size-->0){
                    newNode.next = new ListNode(head.val);
                    head = head.next;
                    newNode = newNode.next;
                }
                res[i++] = node.next;
            }
        }
        return res;
    }
}