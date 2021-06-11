package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/4/21 9:13
 * @description
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numDecodings {
    public static void main(String[] args) {
            System.out.println(numDecodings("11106"));
    }

    //动态规划
    //dp方程： dp[i]表示字符串s的前i个字符的解法方法数
    //动态方程： 第一种情况只使用一个字符：前提条件为s[i] != 0,由于前i-1个字符的解码数为dp[i-1]
    //              dp[i] = dp[i-1]
    //          第二种情况使用两个字符：前提条件 s[i-1] ！= 0，且s[i-1]s[i]组成的数字要小于等于26，由于前i-2个字符的解码数为dp[i-2]
    //              dp[i] = dp[i-2]
    //综上所述：     dp[i] = dp[i-1] + dp[i-2]
    //考虑特殊情况：因为首位为0不成立，所以dp数组首位增加一位，字符串s遍历时从1开始遍历到最后
    public static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        for (int i=1;i<=s.length();i++){
            if (s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if (i>1 && s.charAt(i-2) != '0' && ((s.charAt(i-2)-'0')*10 + s.charAt(i-1)-'0') <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }


}
