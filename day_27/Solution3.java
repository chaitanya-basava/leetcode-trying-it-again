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
class Solution3 {
    private Map<Integer, Integer> m;

    private TreeNode build(int[] pre, int[] post, int i1, int j1, int i2, int j2) {
        if(i1 > j1) return null;

        // System.out.println(i1 + " " + j1 + " -- " + i2 + " " + j2);

        TreeNode root = new TreeNode(pre[i1]);
        if(i1+1 > j1) return root;

        int postIdx = this.m.get(pre[i1+1]);

        root.left = this.build(pre, post, i1+1, i1 + postIdx - i2 + 1, i2, postIdx);
        // System.out.println("------------------");
        root.right = this.build(pre, post, i1 + postIdx - i2 + 2, j1, postIdx+1, j2-1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.m = new HashMap<>();
        for(int i = 0; i < preorder.length; i++) this.m.put(postorder[i], i);

        return this.build(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }
}
