package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/6/30 9:12
 * @description
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *  
 *
 * 示例：
 *
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec {

    public static String res ="";

    // Encodes a tree to a single string.
    //深度优先
    public String serialize(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode treeNode){
        if (treeNode == null){
            res += "null,";
        }else {
            res+=treeNode.val + ",";
            dfs(treeNode.left);
            dfs(treeNode.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(strings));
        return redfs(queue);
    }

    public TreeNode redfs(Queue<String> queue){
        String str = queue.poll();
        if (str.contains("null")){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(str));
        treeNode.left = redfs(queue);
        treeNode.right = redfs(queue);
        return treeNode;
    }



    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        String ans = "";
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node!=null){
                ans+=node.val+",";
                queue.add(node.left);
                queue.add(node.right);
            }else {
                ans+="null,";
            }
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data.equals("")) return null;
        String[] strings = data.split(",");

        TreeNode node = new TreeNode(Integer.valueOf(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int i=1;
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if (!strings[i].equals("null")){
                treeNode.left = new TreeNode(Integer.valueOf(strings[i]));
                queue.add(treeNode.left);
            }
            i++;
            if (!strings[i].equals("null")){
                treeNode.right = new TreeNode(Integer.valueOf(strings[i]));
                queue.add(treeNode.right);
            }
            i++;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        Codec codec = new Codec();
//        TreeNode deserialize = codec.deserialize1(codec.serialize1(treeNode1));
        TreeNode deserialize = codec.deserialize1(codec.serialize1(null));
        System.out.println(deserialize);
//        TreeNode deserialize = codec.deserialize(codec.serialize(treeNode1));
//        System.out.println(deserialize);
    }
}
