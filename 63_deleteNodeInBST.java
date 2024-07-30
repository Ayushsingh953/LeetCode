// https://leetcode.com/problems/delete-node-in-a-bst/?envType=study-plan-v2&envId=leetcode-75

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
    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root,key);
        return root;
    }
    public TreeNode delete(TreeNode cur,int key){
        if(cur==null) return null;

        if(cur.val>key){
            cur.left = delete(cur.left,key);
        }
        else if(cur.val<key){
            cur.right = delete(cur.right,key);
        }else{
            if(cur.left==null && cur.right==null){
                return null;
            }
            else if(cur.left==null){
                return cur.right;
            }
            else if(cur.right==null){
                return cur.left;
            }else{
                TreeNode dummy = new TreeNode(-1);
                cur.right = successor(cur.right,dummy);
                cur.val = dummy.val;
            }
        }
        return cur;
    }
    public TreeNode successor(TreeNode cur,TreeNode dummy){
        if(cur.left==null){
            dummy.val = cur.val;
            return cur.right;
        }
        cur.left = successor(cur.left,dummy);
        return cur;
    }
}