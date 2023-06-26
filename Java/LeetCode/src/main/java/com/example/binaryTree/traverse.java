package com.example.binaryTree;

import java.util.*;

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
//        bfs(treeNode1);
        System.out.println(postOrder(treeNode1));
        System.out.println(res);
    }

    /**
     * 先序、中序遍历  迭代的方式 使用栈
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            //当前节点一直向左遍历,直到没有左节点
            while(root != null){
                //先序遍历
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //弹出最近的左节点
            root = stack.pop();
            //中序遍历
//            res.add(root.val);
            //即左节点遍历完开始遍历右节点
            root = root.right;
        }
        return res;
    }

    /**
     * 后序遍历 迭代方式
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //用于记录上一次遍历的节点,保证右节点遍历完后可以回到根节点
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null){
            //一直向左遍历直到没有节点
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //弹出最近遍历的节点
            root = stack.pop();
            //若当前节点的右节点为null(说明此节点是子节点无须继续遍历) 或 当前的节点的右节点指向pre节点(说明刚遍历完右子节点回到了根节点)
            if(root.right == null || root.right == pre){
                //将值加入集合中,并将当前节点赋值给pre节点说明已经遍历过了,并置为null，方便后续继续弹出他的根节点遍历
                res.add(root.val);
                pre = root;
                root = null;
            }else{
                //若不满足上面两种情况说明右节点还没到头，压栈继续遍历右节点
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }


    public static List<Integer> res = new ArrayList<>();

    /**
     * 中序遍历  递归
     * @param node
     */
    public static void dfs(TreeNode node){
        if (node != null){
            //1.先序遍历
//            res.add(node.val);
            dfs(node.left);
            //2.中序遍历
//            res.add(node.val);
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
