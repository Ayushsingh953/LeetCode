// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> map=new HashMap<Integer,ListNode>();
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        map.put(0,dummy);
        int preSum=0;

        while(head!=null){
            preSum+=head.val;
            if(map.containsKey(preSum)){
                ListNode start=map.get(preSum);
                ListNode temp=start;
                int sum=preSum;
                while(temp!=head){
                    temp=temp.next;
                    sum+=temp.val;
                    if(temp!=head){
                        map.remove(sum);
                    }
                }
                start.next=head.next;
            }else{
                map.put(preSum,head);
            }
            head=head.next;
        }
        return dummy.next;
    }
}