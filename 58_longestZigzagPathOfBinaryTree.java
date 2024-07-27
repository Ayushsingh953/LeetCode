// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75

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
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
        zigzag(root,true,0);
        zigzag(root,false,0);

        return maxLength;
    }

    public void zigzag(TreeNode root,boolean goLeft,int steps){
        if(root==null) return ;

        maxLength = Math.max(maxLength,steps);
        if(goLeft){
            zigzag(root.left,false,steps+1);
            zigzag(root.right,true,1);
        }else{
        zigzag(root.left,false,1);
        zigzag(root.right,true,steps+1);
        }
    }
}