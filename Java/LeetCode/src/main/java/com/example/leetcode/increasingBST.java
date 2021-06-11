package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/4/25 9:04
 * @description
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 *
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class increasingBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        System.out.println(increasingBST(node));
    }

    public static TreeNode res;

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        res = dummy;
        BST(root);
        return dummy.right;
    }

    private static void BST(TreeNode root){
        if (root != null){
            BST(root.left);
            //中序遍历的过程中 修改节点指向
            res.right = root;
            root.left = null;
            res = root;
            BST(root.right);
        }
    }
}
