package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/9/11 10:54
 * @description:6177. 子字符串的最优划分 显示英文描述
 * 通过的用户数796
 * 尝试过的用户数894
 * 用户总通过次数796
 * 用户总提交次数932
 * 题目难度Medium
 * 给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。也就是说，在单个子字符串中，字母的出现次数都不超过 一次 。
 *
 * 满足题目要求的情况下，返回 最少 需要划分多少个子字符串。
 *
 * 注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abacaba"
 * 输出：4
 * 解释：
 * 两种可行的划分方法分别是 ("a","ba","cab","a") 和 ("ab","a","ca","ba") 。
 * 可以证明最少需要划分 4 个子字符串。
 * 示例 2：
 *
 * 输入：s = "ssssss"
 * 输出：6
 * 解释：
 * 只存在一种可行的划分方法 ("s","s","s","s","s","s") 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 仅由小写英文字母组成
 */
public class partitionString {

    public static void main(String[] args) {
        String s = "cuieokbs";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        List<Character> cache = new ArrayList<>();
        char[] arrs = s.toCharArray();
        int res = 0;
        for(Character c:arrs){
            if(cache.contains(c)){
                res++;
                cache.clear();
            }
            cache.add(c);
        }

        int left = cache.size() == 0?0:1;
        return res + left;
    }
}
