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
    public TreeNode invertTree(TreeNode root) {
        recurse(root);
        return root;
    }
    private void recurse(TreeNode n) {
        if (n == null) return;
        if (n.left == null & n.right == null) {
            return;
        }
        
        TreeNode leftCopy = n.left;
        n.left = n.right;
        n.right = leftCopy;

        recurse(n.left);
        recurse(n.right);
    }

}
