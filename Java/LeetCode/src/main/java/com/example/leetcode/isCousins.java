package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangchunchen
 * @date 2021/5/17 11:00
 * @description
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isCousins {
    public static void main(String[] args) {

    }

    public static int x_height;
    public static int x_parent;
    public static int y_height;
    public static int y_parent;

    //深度优先遍历  递归
    public static boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, x,y, 1, root.val);
        dfs(root.right, x,y, 1, root.val);
        return (x_height == y_height) && (x_parent != y_parent);
    }

    public static void dfs(TreeNode node, int x, int y, int height, int parent){
        if (node != null){
            if (node.val == x){
                x_height = height;
                x_parent = parent;
            }else if (node.val == y){
                y_height = height;
                y_parent = parent;
            }else {
                dfs(node.left,x,y,height+1, node.val);
                dfs(node.right, x, y,height+1,node.val);
            }
        }
    }

    //广度优先遍历  按层遍历
    public static boolean isCousins1(TreeNode root, int x, int y){
        //队列存放所有遍历的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //队列存放节点对于的值
        Queue<Integer> value = new LinkedList<>();
        //将根节点加入
        queue.offer(root);
        value.offer(root.val);
        //如果队列不为空，代表树的节点没有遍历完，继续遍历
        while (!queue.isEmpty()){
            //BFS是一层层打印的，size表示当前层的节点个数
            int size = queue.size();
            for (int i=0;i<size;i++){
                //节点和节点值同时出列
                TreeNode node = queue.poll();
                value.poll();
                //首先判断x和y是否是兄弟节点，也就是判断他们的父节点是否是同一个
                if (node.left != null && node.right != null){
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)){
                        return false;
                    }
                }

                //左子节点不为空时加入队列
                if (node.left != null){
                    queue.offer(node.left);
                    value.offer(node.left.val);
                }
                //右子节点不为空时加入队列
                if (node.right != null){
                    queue.offer(node.right);
                    value.offer(node.right.val);
                }
            }
            //判断当前层是否包含这两个节点的值，如果包含说明就是堂兄节点
            if (value.contains(x) && value.contains(y)){
                return true;
            }
        }
        return false;
    }
}
