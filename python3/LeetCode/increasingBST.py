from TreeNode import TreeNode


class Solution(object):
    def increasingBST(self, root):
        dummy = TreeNode(-1)
        self.res = dummy
        self.BST(root);
        return dummy.right

    def BST(self, root):
        if root != None:
            self.BST(root.left)
            self.res.right = root
            root.left = None
            self.res = root
            self.BST(root.right)

if __name__ == '__main__':
    node1 = TreeNode(5)
    node2 = TreeNode(1)
    node3 = TreeNode(7)
    node1.left = node2
    node1.right = node3
    print(Solution().increasingBST(node1))