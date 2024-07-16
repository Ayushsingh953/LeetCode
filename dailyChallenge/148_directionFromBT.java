// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = findLCA(root,startValue,destValue);

        StringBuilder LCA_start = new StringBuilder();
        StringBuilder LCA_dest = new StringBuilder();

        findPath(LCA,startValue,LCA_start);
        findPath(LCA,destValue,LCA_dest);

        StringBuilder direction = new StringBuilder();
        direction.append("U".repeat(LCA_start.length()));
        direction.append(LCA_dest);

        return direction.toString();
    }
    public TreeNode findLCA(TreeNode node,int val1,int val2){
        if(node==null){
            return null;
        }
        if(node.val==val1 || node.val==val2){
            return node;
        }
        TreeNode left = findLCA(node.left,val1,val2);
        TreeNode right = findLCA(node.right,val1,val2);

        if(left==null) return right;
        else if(right==null) return left;

        return node;
    }

    public boolean findPath(TreeNode node,int val,StringBuilder path){
        if(node==null){
            return false;
        }
        if(node.val==val){
            return true;
        }
        path.append("L");
        if(findPath(node.left,val,path)) return true;
        path.setLength(path.length()-1);

        path.append("R");
        if(findPath(node.right,val,path)) return true;
        path.setLength(path.length()-1);

        return false;
    }
}