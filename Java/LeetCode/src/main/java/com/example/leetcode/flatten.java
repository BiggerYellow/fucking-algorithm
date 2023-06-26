package com.example.leetcode;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2021/9/24 17:22
 * @description
 * 114. Flatten Binary Tree to Linked List
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
public class flatten {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        flattenDFS(node1);
        System.out.println(node1);
    }

    /**
     * 逆先序  使用栈
     * @param root
     */
    public static void flatten(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(pre != null){
                pre.right = temp;
                pre.left = null;
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
            pre = temp;
        }
    }

    /**
     * 使用递归
     * @param root
     */
    public static TreeNode pre = null;
    public static void flattenDFS(TreeNode root){
        if(root == null){
            return;
        }
        flattenDFS(root.right);
        flattenDFS(root.left);
        if(pre != null){
            root.right = pre;
            root.left = null;
        }
        pre = root;
    }

}
