package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/2 23:05
 * @description:
 * 6035. 选择建筑的方案数 显示英文描述
 * 通过的用户数436
 * 尝试过的用户数511
 * 用户总通过次数437
 * 用户总提交次数569
 * 题目难度Medium
 * 给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
 *
 * s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
 * s[i] = '1' 表示第 i 栋建筑是一间餐厅。
 * 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
 *
 * 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
 * 请你返回可以选择 3 栋建筑的 有效方案数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "001101"
 * 输出：6
 * 解释：
 * 以下下标集合是合法的：
 * - [0,2,4] ，从 "001101" 得到 "010"
 * - [0,3,4] ，从 "001101" 得到 "010"
 * - [1,2,4] ，从 "001101" 得到 "010"
 * - [1,3,4] ，从 "001101" 得到 "010"
 * - [2,4,5] ，从 "001101" 得到 "101"
 * - [3,4,5] ，从 "001101" 得到 "101"
 * 没有别的合法选择，所以总共有 6 种方法。
 * 示例 2：
 *
 * 输入：s = "11100"
 * 输出：0
 * 解释：没有任何符合题意的选择。
 *
 *
 * 提示：
 *
 * 3 <= s.length <= 105
 * s[i] 要么是 '0' ，要么是 '1' 。
 */
public class numberOfWays {
    public static void main(String[] args) {
        String s = "11100";
        System.out.println(numberOfWays(s));
    }

    public static int res;
    public static long numberOfWays(String s) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0,s);
        return res;
    }

    public static void dfs(StringBuilder sb, int index, String s){
        if (sb.length() == 3){
            res++;
            return;
        }
        for (int i=index; i<s.length();i++){
            if (sb.length() != 0 && sb.charAt(sb.length()-1) == s.charAt(i)){
                continue;
            }
            sb.append(s.charAt(i));
            dfs(sb, i+1, s);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
