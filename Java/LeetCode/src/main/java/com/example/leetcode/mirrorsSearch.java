package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/8/17 20:10
 * @description:
 */
public class mirrorsSearch {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;
        morrisPostOrder(node1);
//        morrisPostOrder(node1);
        System.out.println(res);
    }

    public static List<Integer> res = new ArrayList<>();

    public static void mirrors(TreeNode root){
        TreeNode pre = null;
        while (root != null){
            //判断当前节点是否有左子树
            // 1.有则说明左子树未遍历完继续遍历左子树,再根据最右节点进行判断
            // 2.无则说明左子树遍历完,取当前节点值,并继续遍历右子树
            if(root.left != null){
                //pre意在找到当前节点左子树中的最右节点
                pre = root.left;
                //若 pre存在右节点 && pre的右节点不等于当前遍历的根节点 (因为在下一步若pre不存在右节点会将pre的右节点指向当前节点x形成一个环)
                while(pre.right != null && pre.right != root){
                    pre = pre.right;
                }
                //1.若pre最右节点不存在右节点(也可以理解为未指向其根节点形成环),则将pre的右节点指向根节点形成环,并继续遍历根节点的左子树
                //2.若pre最右节点存在右节点(可以理解为已经指向根节点形成环了),取当前root值并将pre最右节点置为null(即将环断开),继续遍历右子树 (若经过步骤1成环了,即变成从子节点回到根节点)
                if (pre.right == null){
                    pre.right = root;
//                    //先序遍历
//                    res.add(root.val);
                    root = root.left;
                }else{
                    //中序遍历
                    res.add(root.val);
                    pre.right = null;
                    root = root.right;
                }

            }else {
                res.add(root.val);
                root = root.right;

            }
        }
    }

    public static void morrisPostOrder(TreeNode root){
        if(root == null){
            return;
        }
        //自定义头结点形成环
        TreeNode node = new TreeNode(-1);
        node.left = root;
        TreeNode pre = node;
        while(pre != null){
            if (pre.left != null){
                TreeNode next = pre.left;
                while(next.right != null && next.right != pre){
                    next = next.right;
                }
                if (next.right == null){
                    next.right = pre;
                    pre = pre.left;
                }else{
                    next.right = null;
                    //使用头插法在断开环时将右节点和根节点加入结果汇总
                    List<Integer> temp = new ArrayList<>();
                    TreeNode cur = pre.left;
                    while (cur != null){
                        temp.add(0, cur.val);
                        cur = cur.right;
                    }
                    res.addAll(temp);
                    pre = pre.right;
                }
            }else{
                pre = pre.right;
            }
        }
    }


}
