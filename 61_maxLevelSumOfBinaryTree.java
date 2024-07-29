// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75

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
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int level = 1;
        int maxLevelSum = 1;
        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.offer(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            int sum = 0;
            while(size-->0){
                TreeNode node = nodes.poll();
                sum+=node.val;
                if(node.left!=null) nodes.offer(node.left);
                if(node.right!=null) nodes.offer(node.right);
            }
            if(max<sum){
                max = sum;
                maxLevelSum = level;
            }
            level++;
        }
        return maxLevelSum;
    }
}