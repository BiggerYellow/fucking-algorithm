package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/1/25 9:30
 * @description
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * "abcabczzzde"
 * "*abc???de*"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isMatch {
    public static void main(String[] args) {
        String s = "abcabczzzde";
        String p = "*abc???de*";
        System.out.println(isMatch1(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (s.equals("") && p.contains("*")) return true;
        int indexS = 0;
        int indexP = 0;
        boolean flag = false;
        while (indexS < s.length() && indexP < p.length()){
            if (indexS == s.length()-1 && indexP == p.length()-1 && s.charAt(indexS) == p.charAt(indexP)){
                flag = true;
                break;
            }
            if (s.charAt(indexS) == p.charAt(indexP)){
                indexP++;
                indexS++;
            }else if (p.charAt(indexP) == '?'){
                indexP++;
                indexS++;
            }else if (p.charAt(indexP) == '*'){
                int temp = indexP;
                if (indexP == p.length()-1){ //当p的最后一位是*时  直接返回成功
                    flag = true;
                    break;
                }else if (s.charAt(indexS) == p.charAt(++temp)){ //空字符串
                    indexS++;
                    indexP+=2;
                    if (indexS == s.length() && indexP == p.length()){
                        flag = true;
                        break;
                    }
                }else {
                    indexS++;
                }
            }else {
                break;
            }
        }
        return flag;
    }

    public static boolean isMatch1(String s, String p) {
        //构建dp数组
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        //当字符串和模式都为空时 即dp[0][0] = true
        dp[0][0] = true;
        //当字符串为空时 模式中连续出现*的都是true
        for (int i=1;i<=p.length();i++){
            if (p.charAt(i-1) == '*'){
                dp[0][i] = true;
            }else {
                break;
            }
        }
        //开始遍历字符串和模式
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                //当 s[i-1] == p[j-1] 或者 p[j-1] =='?' 时 dp[i][j] = dp[i-1][j-1]
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                //当模式p遇到‘*’时有两种情况
                //1.不匹配，即dp[i][j-1]
                //2.匹配多个字符时，即dp[i-1][j]
                else if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
