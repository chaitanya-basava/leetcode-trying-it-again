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
    public TreeNode recoverFromPreorder(String S) {
        int level;
        String num;
        Stack<TreeNode> stack = new Stack<>();

        int i = 0;
        while(i < S.length()) {
            for(level = 0; S.charAt(i) == '-'; i++) level++;
            while(stack.size() > level) stack.pop();

            for(num = ""; i < S.length() && S.charAt(i) != '-'; i++) num += S.charAt(i);
            TreeNode node = new TreeNode(Integer.parseInt(num));

            if(!stack.isEmpty()) {
                if(stack.peek().left == null) stack.peek().left = node;
                else stack.peek().right = node;
            }
            stack.add(node);
        }
        while(stack.size() > 1) stack.pop();

        return stack.pop();
    }
}
