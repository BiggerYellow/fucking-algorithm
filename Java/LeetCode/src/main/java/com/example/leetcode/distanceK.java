package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/7/28 11:32
 * @description
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 *
 * 提示：
 *
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class distanceK {



    public static void main(String[] args) {
    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(5);
    TreeNode node3 = new TreeNode(6);
    TreeNode node4 = new TreeNode(2);
    TreeNode node5 = new TreeNode(7);
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(1);
    TreeNode node8 = new TreeNode(0);
    TreeNode node9 = new TreeNode(8);
    node1.left = node2;
    node1.right = node7;
    node2.left = node3;
    node2.right = node4;
    node4.left = node5;
    node4.right = node6;
    node7.left = node8;
    node7.right = node9;

//        System.out.println(distanceK(node1));
    }

    public static Map<TreeNode, TreeNode> parent = new HashMap<>();
    public static List<Integer> res = new ArrayList<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root);
        dfs(target, null, 0,k);
        return res;
    }

    //存放每个节点的父节点 供向父节点搜索
    public static void buildParent(TreeNode root){
        if (root != null){
            if (root.left != null){
                parent.put(root.left, root);
            }
            if (root.right != null){
                parent.put(root.right, root);
            }
            buildParent(root.left);
            buildParent(root.right);
        }
    }

    //按照父、左、右的顺序深度遍历 且 记录之前的节点不能重复走 记录走过的路径track  只有track==k时保存结果
    public static void dfs(TreeNode node, TreeNode prev, int track, int k){
        if (node!=null){
            if (track == k){
                res.add(node.val);
                return;
            }
            if (parent.containsKey(node) && parent.get(node) != prev){
                dfs(parent.get(node), node, track+1, k);
            }
            if (node.left != null && node.left != prev){
                dfs(node.left, node, track+1, k);
            }
            if (node.right != null && node.right != prev){
                dfs(node.right, node, track+1, k);
            }
        }
    }

    //广度优先遍历
    public static List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        buildParent(root);
        List<Integer> res = new ArrayList<>();
        //特殊情况:当k==0 直接返回目标节点的值
        if (k == 0){
            res.add(target.val);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> visited =new ArrayList<>();
        queue.offer(target);
        visited.add(target);
        int track = 0;
        while (!queue.isEmpty() && track <k){
            track++;
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                //取出当前节点的邻接节点 父、左、右
                List<TreeNode> temp = new ArrayList<>();
                if (parent.containsKey(node)){
                    temp.add(parent.get(node));
                }
                temp.add(node.left);
                temp.add(node.right);
                //遍历所有邻接节点 要求节点不为null且没有访问过
                for (TreeNode n:temp){
                    if (n!=null && !visited.contains(n)){
                        if (track == k){
                            res.add(n.val);
                        }
                        visited.add(n);
                        queue.offer(n);
                    }
                }
            }
        }
        return res;
    }


    }
