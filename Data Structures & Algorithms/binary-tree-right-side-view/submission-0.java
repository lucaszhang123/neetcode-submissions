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
        List<Integer> depthSeen = new ArrayList<>();
        traverse(root, 0, sol, depthSeen);
        return sol;
    }  

    public void traverse(TreeNode n, int d, List<Integer> sol, List<Integer> depthSeen) {
        if (n == null) return;
        if (depthSeen.size() < d + 1) {
            sol.add(n.val);
            depthSeen.add(0);
        }
        traverse(n.right, d + 1, sol, depthSeen);
        traverse(n.left, d + 1, sol, depthSeen);
    }

    /*
    recurse right as possible before left
    track layers where seen alr

    */
}
