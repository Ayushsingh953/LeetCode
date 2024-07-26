// https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75

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
    int count=0;
    public int goodNodes(TreeNode root) {
        int max = root.val;
        findGoodNodes(root,max);
        return count;
    }
    public void findGoodNodes(TreeNode root,int max){
        if(root==null) return;

        if(root.val>=max){
            System.out.println(root.val);
            count++;
            max = root.val;
        }
        findGoodNodes(root.left,max);
        findGoodNodes(root.right,max);
    }
}