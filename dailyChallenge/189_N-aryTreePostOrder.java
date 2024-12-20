// https://leetcode.com/problems/n-ary-tree-postorder-traversal/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();

        postOrder(root,ans);
        return ans;
    }
    public void postOrder(Node root,List<Integer> ans){
        if(root==null) return;
        List<Node> children = root.children;
        for(Node child:children){
            postOrder(child,ans);
        }
        ans.add(root.val);
    }
}