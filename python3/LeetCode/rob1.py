from typing import List

from TreeNode import TreeNode


class Solution:
    def rob(self, root:TreeNode) -> int:
        def dfs(root: TreeNode) -> List[int]:
            if not root:
                return [0] * 2
            temp = [0] * 2
            left = dfs(root.left)
            right = dfs(root.right)

            temp[0] = max(left[0], left[1]) + max(right[0], right[1])
            temp[1] = left[0] + right[0] + root.val
            return temp

        res = dfs(root)
        return max(res[0], res[1])
