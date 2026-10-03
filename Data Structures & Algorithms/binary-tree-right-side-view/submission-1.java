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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        traverse(root, 0, sol);
        return sol;
    }  

    public void traverse(TreeNode n, int d, List<Integer> sol) {
        if (n == null) return;
        if (sol.size() < d + 1) {
            sol.add(n.val);
        }
        traverse(n.right, d + 1, sol);
        traverse(n.left, d + 1, sol);
    }

    /*
    recurse right as possible before left
    track layers where seen alr

    */
}
