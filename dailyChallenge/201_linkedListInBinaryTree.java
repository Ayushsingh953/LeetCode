// https://leetcode.com/problems/linked-list-in-binary-tree/

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return findPath(root,head);
    }

    public boolean findPath(TreeNode root,ListNode head){
        if(root==null) return false;
        if(dfs(root,head)) return true;

        return findPath(root.left,head) || findPath(root.right,head);
    }
    public boolean dfs(TreeNode root,ListNode head){
        if(head == null) return true;
        if(root==null) return false;

        if(root.val != head.val) return false;

        boolean left = dfs(root.left,head.next);
        boolean right = dfs(root.right,head.next);
        return left || right;
    }
}