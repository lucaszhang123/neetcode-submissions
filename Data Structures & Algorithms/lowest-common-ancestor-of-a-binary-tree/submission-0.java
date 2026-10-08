/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q);
        return lca;
    }

    public int recurse(TreeNode n, TreeNode p, TreeNode q) {
        if (n == null) return 0;

        int cnt = 0;
        if (n == p || n == q) cnt++;

        cnt += recurse(n.left, p, q);
        cnt += recurse(n.right, p, q);

        if (cnt == 2 && lca == null) lca = n;
        return cnt;

    }


    /*
    if found p & found q --> done
    otw 
    */
}