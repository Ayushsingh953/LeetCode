// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root,p,q);
    }

    public TreeNode LCA(TreeNode node,TreeNode p,TreeNode q){
        if(node==null) return null;

        if(node.val==p.val || node.val==q.val) return node;

        TreeNode left = LCA(node.left,p,q);
        TreeNode right = LCA(node.right,p,q);

        if(left == null) return right;
        else if(right == null) return left;

        return node;
    }
}