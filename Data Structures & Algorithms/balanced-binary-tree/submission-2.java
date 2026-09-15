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
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return balanced;
    }

    public int depth(TreeNode n) {
        if (n == null) return 0;
        
        int ld = depth(n.left);
        int rd = depth(n.right);


        if (Math.abs(ld - rd) > 1) balanced = false;

        return 1 + Math.max(ld, rd);
    }
    /*
    1 - 2 - 8 
    |.   \7
    3 - 6 
    |
    5
    */

}
