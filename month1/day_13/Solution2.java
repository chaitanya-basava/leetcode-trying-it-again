/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        // cut full traversal using BST properties
        TreeNode l = (root.val > p.val || root.val > q.val) ? lowestCommonAncestor(root.left, p, q) : null;
        TreeNode r = (root.val < p.val || root.val < q.val) ? lowestCommonAncestor(root.right, p, q) : null;

        if(l != null && r != null) return root;
        else if(l != null) return l;
        return r;
    }
}
