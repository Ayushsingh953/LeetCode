// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75

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
    public int pairSum(ListNode head) {
        int n = 0;
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;

        while(cur!=null){
           s.push(cur.val);
           cur = cur.next;
            n++;
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n/2;i++){
            maxSum = Math.max(maxSum,head.val+s.pop());
            head = head.next;
        }
        return maxSum;
    }
}