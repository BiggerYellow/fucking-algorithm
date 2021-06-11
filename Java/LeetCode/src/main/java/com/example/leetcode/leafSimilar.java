package com.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/5/10 9:15
 * @description
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 *
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 *
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leafSimilar {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;

        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        node3.right = node4;

        System.out.println(leafSimilar(node1, node3));

    }

    //深度优先遍历
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        dfs(root1, leaf1);
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    public static void dfs(TreeNode node, List<Integer> leaf){
        if (node!=null){
            if (node.left == null && node.right == null){
                leaf.add(node.val);
            }
            dfs(node.left, leaf);
            dfs(node.right, leaf);
        }
    }

    public static boolean leafSimilar1(TreeNode root1, TreeNode root2){
        List<Integer> leaf1 = new ArrayList<>();
        bfs(root1, leaf1);
        List<Integer> leaf2 = new ArrayList<>();
        bfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    public static void bfs(TreeNode node, List<Integer> leaf){
        Deque<TreeNode> d = new ArrayDeque<>();
        while (node != null || !d.isEmpty()){
            while (node != null){
                d.addLast(node);
                node = node.left;
            }
            node = d.pollLast();
            if (node.left == null && node.right == null){
                leaf.add(node.val);
            }
            node = node.right;
        }
    }
}
