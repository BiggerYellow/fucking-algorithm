from typing import List

from TreeNode import TreeNode


class Solution:
    def traverse(self, node:TreeNode) -> List[int]:
        res = list()
        def dfs(node:TreeNode):
            if node:
                #1.先序遍历
                #res.append(node.val)
                dfs(node.left)
                #2.中序遍历
                res.append(node.val)
                dfs(node.right)
                #3.后序遍历
                #res.append(node.val)
        dfs(node)
        return res

    def traverseBSF(self,node:TreeNode) -> List[int]:
        res = list()
        queue = list()
        queue.append(node)
        while len(queue) != 0:
            size = len(queue)
            for i in range(size):
                temp = queue.pop(0)
                res.append(temp.val)
                if temp.left:
                    queue.append(temp.left)
                if temp.right:
                    queue.append(temp.right)
        return res


if __name__ == '__main__':
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node4 = TreeNode(4)
    node5 = TreeNode(5)
    node6 = TreeNode(6)
    node7 = TreeNode(7)
    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7
    print(Solution().traverseBSF(node1))
