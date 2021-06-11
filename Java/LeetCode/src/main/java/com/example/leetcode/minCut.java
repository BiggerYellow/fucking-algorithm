package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/3/8 11:24
 * @description
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minCut {

    public static void main(String[] args) {
        String s ="bb";
        System.out.println(minCut(s));
    }

    public static boolean[][] dp;
    public static int len;

    public static int minCut(String s) {
        isPalindromic(s);
        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i=0;i<len;i++){
            if (dp[0][i]){
                f[i]=0;
            }else {
                for (int j=0;j<i;j++){
                    if (dp[j+1][i]){
                        f[i] = Math.min(f[i],f[j]+1);
                    }
                }
            }
        }
        return f[len-1];
    }

    //动态规划 求出dp数组供dfs使用
    public static void isPalindromic(String s){
        len = s.length();
        dp = new boolean[len][len];
        for (int l=0;l<len;l++){
            for (int i=0;i+l<len;i++){
                int j=i+l;
                if (l == 0){
                    dp[i][j] = true;
                }else if (l == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
            }
        }
    }
}
