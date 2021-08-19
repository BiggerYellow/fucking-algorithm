package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/7/31 15:38
 * @description
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 *
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 *
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 *
 * 返回二叉树的 垂序遍历 序列。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 *           1 在上面，所以它出现在前面。
 *           5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 *
 *
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class verticalTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        verticalTraversal(treeNode);
        System.out.println(cache);
    }

    public static Map<Integer, List<Integer>> cache = new HashMap<>();

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0);
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1>o2){
                return 1;
            }
            return -1;
        });
        for (Integer key:cache.keySet()){
            queue.offer(key);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> list = cache.get(queue.poll());
            list.sort(((o1, o2) -> {
                if (o1>o2){
                    return 1;
                }
                return -1;
            }));
            res.add(list);
        }
        return res;
    }

    public static void dfs(TreeNode root, int height){
        if (root != null){
            List<Integer> temp = cache.getOrDefault(height, new ArrayList<>());
            temp.add(root.val);
            cache.put(height, temp);
            dfs(root.left, height-1);
            dfs(root.right, height+1);
        }
    }
}
