package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangchunchen
 * @date 2021/5/12 11:26
 * @description
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点
 */
public class minDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int res =1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                TreeNode node = q.poll();
                //判断是否达到终点
                if (node.right == null && node.left == null){
                    return res;
                }
                //将相邻节点加入到链表中
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
