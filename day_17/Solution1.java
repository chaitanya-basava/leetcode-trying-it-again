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
class Solution1 {
    int ans;

    private void inOrder(TreeNode root, int count) {
        if(root == null) return;

        count++;
        if(root.left == null && root.right == null) {
            ans = Math.max(count, ans);
        }

        inOrder(root.left, count);
        inOrder(root.right, count);
    }

    public int maxDepth(TreeNode root) {
        ans = 0;
        this.inOrder(root, 0);
        return ans;
    }
}