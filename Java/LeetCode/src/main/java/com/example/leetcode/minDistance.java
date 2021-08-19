package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/7/5 11:01
 * @description
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance2(word1, word2));
    }


    //递归遍历
    //双指针i,j从左往右遍历
    //退出条件: 1.i先遍历到尾部   返回word2.length-j
    //         2.j先遍历到尾部   返回word1.length-i
    //1.当两个位置的字符相等时,直接将i和j继续往后移动
    //2.不相等时,新增、删除、替换三种情况都需要试下,最后需要将操作步数加1
    //  2.1 替换 即i和j的都需要往后移动一位
    //  2.2 新增 即在word2中添加一位元素,需要将j向后移动一位
    //  2.3 删除 即在word1中删除一位元素,需要将i向后移动一位
    public static int minDistance(String word1, String word2) {
        return dfs(word1, 0, word2, 0);
    }

    public static int dfs(String word1, int i, String word2, int j){
        if (i==word1.length()){
            return word2.length()-j;
        }
        if (j==word2.length()){
            return word1.length()-i;
        }
        if (word1.charAt(i) == word2.charAt(j)){
            return dfs(word1, i+1, word2, j+1);
        }
        return Math.min(dfs(word1, i+1, word2,j+1), Math.min(dfs(word1, i, word2, j+1), dfs(word1, i+1, word2, j)))+1;
    }



    //递归+备忘录  从上往下
    public static int minDistance1(String word1, String word2){
        int[][] temp = new int[word1.length()+1][word2.length()+1];
        for (int i=0;i<word1.length()+1;i++){
            Arrays.fill(temp[i], -1);
        }
        return dfs1(word1, 0, word2, 0,temp);
    }

    public static int dfs1(String word1, int i, String word2, int j, int[][] temp){
        if (temp[i][j] != -1){
            return temp[i][j];
        }
        if (i==word1.length()){
            return temp[i][j] = word2.length()-j;
        }
        if (j == word2.length()){
            return temp[i][j] = word1.length()-i;
        }
        if (word1.charAt(i) == word2.charAt(j)){
            return dfs1(word1, i+1, word2, j+1, temp);
        }
        return Math.min(dfs1(word1, i+1, word2, j+1, temp), Math.min(dfs1(word1, i+1, word2, j, temp), dfs1(word1, i, word2, j+1, temp)))+1;
    }


    //动态规划  从下往上
    //dp[i][j] 从word1和word2开始的最小编辑距离,
    //动态方程:     word1[i] == word2[j]  -> dp[i][j] = dp[i+1][j+1]
    //             word1[i] != word2[j]  -> dp[i][j] = min(dp[i+1][j+1], dp[i][j+1], dp[i+1][j])+1
    //初始化:  dp[i][word2.length]
    //        dp[word1.length][j]
    //结果: dp[0][0]
    public static int minDistance2(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0;i<=word1.length();i++){
            dp[i][word2.length()] = word1.length()-i;
        }
        for (int j=0;j<=word2.length();j++){
            dp[word1.length()][j] = word2.length()-j;
        }
        for (int i=word1.length()-1;i>=0;i--){
            for (int j=word2.length()-1;j>=0;j--){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]))+1;
                }
            }
        }
        return dp[0][0];
    }
}
