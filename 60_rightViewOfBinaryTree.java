// https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=leetcode-75

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

 // BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.offer(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            
            while(size-- >0){
                TreeNode node = nodes.poll();
                if(size==0){
                    rightView.add(node.val);
                }
                if(node.left!=null){
                    nodes.offer(node.left);
                }
                if(node.right!=null){
                    nodes.offer(node.right);
                }
            }
        }
        return rightView;
    }
}

// DFS
class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> rightView = new ArrayList<>();
        dfs(root,1,rightView);
        return rightView;
    }
    public void dfs(TreeNode node,int level,List<Integer> rightView){
        if(node==null) return;

        if(rightView.size()<level){
            rightView.add(node.val);
        }

        dfs(node.right,level+1,rightView);
        dfs(node.left,level+1,rightView);
    }
}