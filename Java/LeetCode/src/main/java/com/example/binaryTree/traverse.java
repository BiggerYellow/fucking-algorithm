package com.example.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangchunchen
 * @date 2021/8/26 11:37
 * @description
 */
public class traverse {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right  =treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        bfs(treeNode1);
        System.out.println(res);
    }

    public static List<Integer> res = new ArrayList<>();

    public static void dfs(TreeNode node){
        if (node != null){
            //1.先序遍历
            res.add(node.val);
            dfs(node.left);
            //2.中序遍历
            res.add(node.val);
            dfs(node.right);
            //3.后序遍历
            res.add(node.val);
        }
    }

    public static void bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
    }
}
