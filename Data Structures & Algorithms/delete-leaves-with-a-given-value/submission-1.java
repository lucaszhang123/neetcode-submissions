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
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return recurse(root, target);
    }

    public TreeNode recurse(TreeNode n, int tgt) {
        if (n == null) return null;
        n.left = recurse(n.left, tgt);
        n.right = recurse(n.right, tgt);
        
        if (n.left == null && n.right == null && n.val == tgt) return null;
        
        return n;
    }
}