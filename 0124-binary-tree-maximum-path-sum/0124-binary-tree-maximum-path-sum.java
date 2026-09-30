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
    int maxi = Integer.MIN_VALUE;

    public int solve(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));

        // path jo is node par "bend" hota hai (left + node + right)
        maxi = Math.max(maxi, left + right + root.val);

        // parent ko sirf ek side ka path de sakte ho
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxi;
    }
}