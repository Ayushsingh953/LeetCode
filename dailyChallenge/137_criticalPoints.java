// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1,-1};
        int minDistance = Integer.MAX_VALUE;

        ListNode preNode = head;
        ListNode curNode = head.next;
        int firstCriticalIdx = 0;
        int preCriticalIdx = 0;
        int curIdx = 1;

        while(curNode.next!=null){
            if((curNode.val<preNode.val && curNode.val<curNode.next.val) || (curNode.val>preNode.val &&
            curNode.val>curNode.next.val)){
                if(firstCriticalIdx==0){
                    firstCriticalIdx=curIdx;
                }else{
                    minDistance = Math.min(minDistance,curIdx-preCriticalIdx);
                }
                preCriticalIdx=curIdx;
            }
            curIdx++;
            preNode=curNode;
            curNode=curNode.next;
        }
        if(minDistance!=Integer.MAX_VALUE){
            int maxDistance=preCriticalIdx-firstCriticalIdx;
            result = new int[]{minDistance,maxDistance};
        }
        return result;
    }
}