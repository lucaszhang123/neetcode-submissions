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
    TreeNode found;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return found;
    }
    public int search(TreeNode n, TreeNode p, TreeNode q) {
        if (n == null) return 0;
        int c = 0;
        if (n.val == p.val || n.val == q.val) c++;

        c += search(n.left, p, q);
        c += search(n.right, p, q);

        if (c == 2 && found == null) found = n; 
        return c;
    }

    /*
    pSeen;
    qSeen;

    recurse(right)
    recurse(let)

    if (pSeen && qSeen) -> that node





    */
}
