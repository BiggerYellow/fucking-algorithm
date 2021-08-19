package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/7/7 10:51
 * @description
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *  
 *
 * 提示：
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    //dp[i][j] 代表text1的前i个字符和text2的前j个字符 的最长公共子序列长度
    //转移方程: 需要遍历两个字符串 使用双指针
    //          1.当两个字符相等时,直接取i和j的上一个位置并加上当前的长度1  ->  dp[i][j] = dp[i-1][j-1]+1
    //          2.当两个字符不相等是,有三种方案并取最大值:
    //                                      2.1 取i的上一个位置并保持j不动 dp[i][j] = dp[i-1][j]
    //                                      2.2 取j的上一个位置并保持i不动 dp[i][j] = dp[i][j-1]
    //                                      2.3 同时取i和j的上一个位置的值 dp[i][j] = dp[i-1][j-1] 因为此方案肯定最小 所以可以忽略
    //                          ==> dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    //初始化: dp[0][...]=0
    //       dp[...][0]=0
    //结果: dp[text1.len][text2.len]
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i=1;i<len1+1;i++){
            for (int j=1;j<len2+1;j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
