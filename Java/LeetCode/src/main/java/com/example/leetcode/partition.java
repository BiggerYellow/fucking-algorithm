package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/3/8 9:34
 * @description
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class partition {
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(partition(s));
    }

    public static boolean[][] dp;

    public static int len;

    public static List<String> temp = new ArrayList<>();

    public static List<List<String>> res = new ArrayList<>();

    /**
     * 令dp(i,j) 表示数组s从i到j的子串是否回文
     * 当aba为回文，即aabaa也是回文，可见公式为 dp[i][j] = dp[i+1][j-1] 范围条件为： (j-1) - (i+1) + 1 < 2 => j-i <3
     * 1.如果单个字母 即长度l=0,i,j=i+l时 也为回文串 dp[i][j] = true
     * 2.如果是两个字母  即长度l为1,i,j=i+1时，所有的dp[i,j] = s(i) == s(j)
     * 3.如果是多个字母 即要 s(i) == s(j) && dp[i][j] = dp[i+1][j-1]
     * @param s
     * @return
     */
    public static void isPalindromic(String s) {
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
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }

            }
        }
    }

    /**
     * 回溯算法
     *  def backtrack(路径,选择列表) {
 *          if(满足结束条件){
 *              res.add
 *              return
 *          }
     *      for 选择 in 选择列表 {
     *          做选择
     *          backtrack(路径, 选择列表)
     *          撤销选择
     *      }
     *  }
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        isPalindromic(s);
        backtrack(s, 0);
        return res;
    }

    public static void backtrack(String s, int i){
        if (i==len){
            res.add(new ArrayList<>(temp));
        }
        for (int j=i;j<len;j++){
            if (dp[i][j]){
                temp.add(s.substring(i,j+1));
                backtrack(s, j+1);
                temp.remove(temp.size()-1);
            }
        }
    }


}
