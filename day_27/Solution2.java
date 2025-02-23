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
class Solution2 {
    int K;

    private TreeNode inorder(TreeNode root) {
        if(root == null) return null;

        TreeNode l = inorder(root.left);
        if(l != null) return l;
        K--;
        if(K == 0) return root;
        return inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        TreeNode res = inorder(root);

        return res == null ? -1 : res.val;
    }
}
