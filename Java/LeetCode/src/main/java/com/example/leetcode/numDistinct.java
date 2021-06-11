package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/3/17 9:12
 * @description
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 示例 1：
 *
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2：
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *  
 * 提示：
 *
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numDistinct {
    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        System.out.println(numDistinct1(s, t));
    }

    //dp方程 从前往后
    //dp[i][j] 代表 T前i字符串可以由S j字符串组成最多个数
    //s[i] == t[j]  dp[i][j] = dp[i-1][j-1] + dp[i][j-1] 元素相等时有两种情况 s和t都向前进位 或 t保持不动 s向前前进一位
    //s[i] != t[j]  dp[i][j] = dp[i][j-1] 元素不相等的话直接将 t保持不动s向前进位
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int j=0;j<s.length()+1;j++) dp[0][j] = 1;
        for (int i=1;i<t.length()+1;i++){
            char tc = t.charAt(i-1);
            for (int j=1;j<s.length()+1;j++){
                char cs = s.charAt(j-1);
                if (cs == tc){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    //dp方程 从后往前
    //dp[i][j] 代表s从i到末尾的子序列中在t从j到末尾的出现此时
    //当s[i] == t[j]  dp[i][j]=dp[i+1][j+1] + dp[i+1][j]
    //当s[i] != t[j]  dp[i][j]=dp[i+1][j]
    public static int numDistinct1(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i=0;i<=s.length();i++){
            dp[i][t.length()] = 1;
        }
        for (int i=s.length()-1;i>=0;i--){
            for (int j=t.length()-1;j>=0;j--){
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
