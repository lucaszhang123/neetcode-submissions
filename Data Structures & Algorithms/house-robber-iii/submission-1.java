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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> m = new HashMap<>();
        return recurse(root, m);
    }
    public int recurse(TreeNode n, Map<TreeNode, Integer> m) {
        if (n == null) return 0;

        if (m.containsKey(n)) return m.get(n); 

        int ll = 0;
        int lr = 0;
        int rl = 0;
        int rr = 0;

        if (n.left != null) {
            ll = recurse(n.left.left, m);
            lr = recurse(n.left.right, m);
        }
        if (n.right != null) {
            rl = recurse(n.right.left, m);
            rr = recurse(n.right.right, m);
        }

        int maxTake = n.val + ll + lr + rl + rr;
        int maxDont = recurse(n.left, m) + recurse(n.right, m);

        int maxProf = Math.max(maxTake, maxDont);
        m.put(n, maxProf);

        return maxProf;
    }
}