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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        int cnt = 0;

        while (root != null || s.size() != 0) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            cnt++;

            if (cnt == k) return root.val;

            root = root.right;
        }
        return -1;
    }
    /*
          10
        8   12
       4 9 11 13
      1 5       17

    in order traversal

    run to left untill null
    go up
    go right & repeat 

    10
    8
    4
    1X
    4X

    recurse(n, cnt) {

    return 

    //node:
    check left
    up
    check right

    }
    */
}
