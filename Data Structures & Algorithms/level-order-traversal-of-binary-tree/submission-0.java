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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        down(root, 0, sol);
        return sol;
    }

    public void down(TreeNode n, int d, List<List<Integer>> sol) {
        if (n == null) return;

        if (sol.size() < d + 1) {
            List<Integer> lvl = new ArrayList<>();
            sol.add(lvl);
        }

        sol.get(d).add(n.val);

        down(n.left, d + 1, sol);
        down(n.right, d + 1, sol);
    }
    /*
        1
       2   3
      4 5 6
    */
}
