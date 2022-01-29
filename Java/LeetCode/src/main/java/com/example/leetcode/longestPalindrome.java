package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :huangchunchen
 * @date :Created in 2022/1/8 23:14
 * @description:
 * 5962. 连接两字母单词得到的最长回文串 显示英文描述
 * User Accepted:939
 * User Tried:1343
 * Total Accepted:946
 * Total Submissions:2556
 * Difficulty:Medium
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 *
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 *
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 *
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 * 示例 2：
 *
 * 输入：words = ["ab","ty","yt","lc","cl","ab"]
 * 输出：8
 * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
 * "lcyttycl" 是另一个可以得到的最长回文串。
 * 示例 3：
 *
 * 输入：words = ["cc","ll","xx"]
 * 输出：2
 * 解释：最长回文串是 "cc" ，长度为 2 。
 * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 105
 * words[i].length == 2
 * words[i] 仅包含小写英文字母
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String[] words = {"em","pe","mp","ee","pp","me","ep","em","em","me"};
        System.out.println(longestPalindrome(words));
    }

    public static int longestPalindrome(String[] words) {
        int res = 0;
        boolean[] cache = new boolean[words.length];
        Set<String> temp = new HashSet<>();
        for (int i=0;i<words.length;i++){
            if (words[i].charAt(0) == words[i].charAt(1)){
                cache[i]=true;
                if (temp.contains(words[i])){
                    res+=4;
                    temp.remove(words[i]);
                }else {
                    temp.add(words[i]);
                }
                continue;
            }
            for (int j=i+1;j<words.length ;j++){
                if (!cache[i] && !cache[j] && (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0))){
                    cache[i]=true;
                    cache[j]=true;
                    res+=4;
                    break;
                }
            }
        }
        if (!temp.isEmpty()){
            res+=2;
        }
        return res;
    }
}
