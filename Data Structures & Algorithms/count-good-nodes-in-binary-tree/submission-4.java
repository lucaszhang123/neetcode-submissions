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
    Integer counter = 0;
    public int goodNodes(TreeNode root) {
        recurse(root, -101);
        return counter;
    }

    public void recurse(TreeNode n, int currMax) {
        if (n == null) return;

        if (n.val >= currMax) {
            counter++;
            currMax = n.val;
        }
        recurse(n.left, currMax);
        recurse(n.right, currMax);
    }
}
