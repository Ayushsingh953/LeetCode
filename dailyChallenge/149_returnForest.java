// https://leetcode.com/problems/delete-nodes-and-return-forest/

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> roots = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int value:to_delete){
           toDelete.add(value);
        }
        root=helper(root,toDelete,roots);
        if(root!=null) roots.add(root);
        return roots;
    }
    public TreeNode helper(TreeNode node,Set<Integer> toDelete,List<TreeNode> roots){
        if(node==null) return null;
        node.left=helper(node.left,toDelete,roots);
        node.right=helper(node.right,toDelete,roots);
        
        if(toDelete.contains(node.val)){
            if(node.left!=null) roots.add(node.left);
            if(node.right!=null) roots.add(node.right);
            return null;
        }
        return node;
    }
}