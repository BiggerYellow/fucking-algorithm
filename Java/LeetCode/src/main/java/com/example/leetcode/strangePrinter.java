package com.example.leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author huangchunchen
 * @date 2021/5/24 9:12
 * @description
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2：
 *
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class strangePrinter {
    public static void main(String[] args) {
//        System.out.println(strangePrinter("abcabcabc"));
        System.out.println(strangePrinter("tbgtgb"));
//        System.out.println(strangePrinter("aba"));
    }

    //dp[i][j]代表 完成区间 [i,j] 的最少打印次数
    //转移方程： 当s[i] == s[j] 时  dp[i][j] = dp[i][j-1]
    //          当s[i] != s[j] 时  dp[i][j] = min(dp[i][k] + dp[k+1][j])

    public static int strangePrinter(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i=length-1;i>=0;i--){
            dp[i][i] = 1;
            for (int j=i+1;j<length;j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                }else {
                    int min = Integer.MAX_VALUE;
                    for (int k=i;k<j;k++){
                        min = Math.min(min, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][length-1];
    }
}
