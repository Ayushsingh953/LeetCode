// https://leetcode.com/problems/sum-of-left-leaves/

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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        if(root!=null){
            if(isLeaf(root.left)){
                sum+=root.left.val;
            }else{
               sum+= sumOfLeftLeaves(root.left);
            }
            sum+= sumOfLeftLeaves(root.right);
        }
        return sum;
    }
    boolean isLeaf(TreeNode cur){
        if( cur!=null && cur.left==null && cur.right==null){
            return true;
        }
        return false;
    }
}