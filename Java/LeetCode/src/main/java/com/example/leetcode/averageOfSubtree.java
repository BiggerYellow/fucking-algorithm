package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :huangchunchen
 * @date :Created in 2022/5/8 10:56
 * @description:
 * 6057. 统计值等于子树平均值的节点数 显示英文描述
 * 通过的用户数1732
 * 尝试过的用户数1785
 * 用户总通过次数1733
 * 用户总提交次数1841
 * 题目难度Medium
 * 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
 *
 * 注意：
 *
 * n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
 * root 的 子树 由 root 和它的所有后代组成。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,8,5,0,1,null,6]
 * 输出：5
 * 解释：
 * 对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
 * 对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
 * 对值为 0 的节点：子树的平均值 0 / 1 = 0 。
 * 对值为 1 的节点：子树的平均值 1 / 1 = 1 。
 * 对值为 6 的节点：子树的平均值 6 / 1 = 6 。
 * 示例 2：
 *
 *
 * 输入：root = [1]
 * 输出：1
 * 解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 */
public class averageOfSubtree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root1.left = root2;
        root1.right = root5;
        root2.left = root3;
        root2.right = root4;
        root5.right = root6;
        System.out.println(averageOfSubtree(root1));
    }

    public static int averageOfSubtree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                dfs(poll);
                if (poll.val == total/count){
                    res++;
                }
                total = 0;
                count = 0;
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }

        }
        return res;
    }

    public static int res = 0;
    public static int total = 0;
    public static int count = 0;

    public static void dfs(TreeNode root){
        if (root != null){
            if (root.left != null){
                dfs(root.left);
            }
            if (root.right != null){
                dfs(root.right);
            }
            total+=root.val;
            count++;
        }
    }
}
