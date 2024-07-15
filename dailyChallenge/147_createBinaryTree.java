// https://leetcode.com/problems/create-binary-tree-from-descriptions/

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children = new HashSet<>(), parents = new HashSet<>();
        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();

        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], isLeft = d[2];
            parents.add(parent);
            parents.add(child);
            children.add(child);
            parentToChildren
                .computeIfAbsent(parent, l -> new ArrayList<>())
                .add(new int[] { child, isLeft });
        }
        parents.removeAll(children);
        int rootVal= parents.iterator().next();
         return dfs(parentToChildren, rootVal);
    }
    private TreeNode dfs(Map<Integer, List<int[]>> parentToChildren, int val) {
        TreeNode node = new TreeNode(val);

        if (parentToChildren.containsKey(val)) {
            for (int[] childInfo : parentToChildren.get(val)) {
                int child = childInfo[0];
                int isLeft = childInfo[1];

                if (isLeft == 1) {
                    node.left = dfs(parentToChildren, child);
                } else {
                    node.right = dfs(parentToChildren, child);
                }
            }
        }

        return node;
    }
}