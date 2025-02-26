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
class FindElements {
    TreeNode root;
    Set<Integer> hash;

    private void inorder(TreeNode root) {
        if(root == null) return;

        hash.add(root.val);
        if(root.left != null) root.left.val = 2 * root.val + 1;
        if(root.right != null) root.right.val = 2 * root.val + 2;

        inorder(root.left);
        inorder(root.right);
    }

    public FindElements(TreeNode root) {
        hash = new HashSet<>();
        if(root != null) {
            root.val = 0;
        }
        inorder(root);
        this.root = root;
    }

    public boolean find(int target) {
        return hash.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */