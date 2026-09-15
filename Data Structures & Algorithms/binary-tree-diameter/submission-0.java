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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLengthDepth(root);
        return maxDiameter;
    }

    public int maxLengthDepth(TreeNode n) {
        if (n == null) return 0;
        int maxLengthLeft;
        int maxLengthRight;

        if (n.left == null) maxLengthLeft = 0;
        else maxLengthLeft = 1 + maxLengthDepth(n.left);

        if (n.right == null) maxLengthRight = 0;
        else maxLengthRight = 1 + maxLengthDepth(n.right);

        if (maxLengthLeft + maxLengthRight > maxDiameter) {
            maxDiameter = maxLengthLeft + maxLengthRight;
        } 

        return Math.max(maxLengthLeft, maxLengthRight);

    }
}

/*
node -- max_d_right
|
max_d_left

l using node = maxd_left + max_d_right


*/

