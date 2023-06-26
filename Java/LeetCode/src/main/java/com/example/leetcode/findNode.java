package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/10/25 12:41
 * @description:
 */
public class findNode {
    public static void main(String[] args) {
        System.out.println(Double.valueOf(Math.pow(2,2)).intValue());
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        List<TreeNode> track = new ArrayList<>();
        dfs(node1, track, node5);
        System.out.println(track);
    }

    public static void dfs(TreeNode root, List<TreeNode> track, TreeNode node){
        if(root.val == node.val){
            return;
        }
        track.add(root);
        if(root.left != null){
            dfs(root.left, track, node);
        }
        if(root.right != null){
            dfs(root.right, track, node);
        }
        track.remove(track.size()-1);
    }
}
