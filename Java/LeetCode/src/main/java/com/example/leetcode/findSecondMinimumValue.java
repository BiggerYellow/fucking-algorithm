package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/7/27 0:04
 * @description
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 *
 *
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findSecondMinimumValue {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

//        TreeNode treeNode1 = new TreeNode(5);
//        TreeNode treeNode2 = new TreeNode(8);
//        TreeNode treeNode3 = new TreeNode(5);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
        System.out.println(findSecondMinimumValue1(treeNode1));
    }

    public static PriorityQueue<Integer> list = new PriorityQueue<>((o1, o2) -> {
        if (o1 > o2){
            return 1;
        }else {
            return -1;
        }
    });

    public static int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (list.size() <=1){
            return -1;
        }
        list.poll();
        return list.poll();
    }

    public static void dfs(TreeNode root){
        if (root != null){
            if (!list.contains(root.val)){
                list.add(root.val);
            }
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static int res;
    public static int pre;

    public static int findSecondMinimumValue1(TreeNode root) {
        res=-1;
        pre = root.val;
        dfs1(root);
        return res;
    }

    public static void dfs1(TreeNode root){
        if (root!= null){
            if (res !=-1 && root.val>=res){
                return;
            }
            if (root.val > pre){
                res = root.val;
            }
            dfs1(root.left);
            dfs1(root.right);
        }
    }
    }
