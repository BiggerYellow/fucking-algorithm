package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/4/13 9:00
 * @description
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minDiffInBST {
    public static void main(String[] args) {

    }
    private static int pre = -1;
    private static int res = Integer.MAX_VALUE;

    //二叉搜索树经过中序遍历后就是一个递增的数组
    //即求中序遍历后的每一个相邻的最小值
    //定义pre保存前节点
    public static int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            res = Math.min(res, root.val-pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
