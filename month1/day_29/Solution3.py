# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """

        def postorder(_root):
            if not _root:
                return [float("-inf"), 0]

            l = postorder(_root.left)
            r = postorder(_root.right)

            # no use to propagate negative sums, they will be less than individual -ve values
            maxSum = max(l[0], r[0], max(0, l[1]) + _root.val + max(0, r[1]))
            turnSum = _root.val + max(0, l[1], r[1])

            return [maxSum, max(_root.val, turnSum)]

        return max(postorder(root))
