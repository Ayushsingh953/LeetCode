// https://leetcode.com/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75

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

// Brute Force
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null ) return count;
        long sum = targetSum;
        findPath(root,sum);
        pathSum(root.left,(int)sum);
        pathSum(root.right,(int)sum);
        return count;
    }
    public void findPath(TreeNode root,long sum){
        if(root==null) return;

        if(root.val==sum) {
            count++;
        }
        findPath(root.left,sum-root.val);
        findPath(root.right,sum-root.val);
    }
}

// Using HashMap
class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
       Map<Long,Integer> preSum = new HashMap<>();
       preSum.put(0L,1);
       return dfs(root,0,targetSum,preSum);
    }
    public int dfs(TreeNode root, long curSum, int targetSum,Map<Long,Integer> preSum) {
        if (root == null) return 0;
        curSum += root.val;
        int res = preSum.getOrDefault(curSum-targetSum,0);
        preSum.put(curSum,preSum.getOrDefault(curSum,0)+1);

        res+=dfs(root.left,curSum,targetSum,preSum)+dfs(root.right,curSum,targetSum,preSum);
        preSum.put(curSum,preSum.get(curSum)-1);
        return res;
  }
}
