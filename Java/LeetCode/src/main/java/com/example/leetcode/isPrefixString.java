package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/8/8 10:34
 * @description
 * 给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
 *
 * 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
 *
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * 输出：true
 * 解释：
 * s 可以由 "i"、"love" 和 "leetcode" 相连得到。
 * 示例 2：
 *
 * 输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * 输出：false
 * 解释：
 * 数组的前缀相连无法得到 s 。
 */
public class isPrefixString {
    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = {"apples","i","love","leetcode"};
        System.out.println(isPrefixString(s,words));
    }

    public static boolean isPrefixString(String s, String[] words) {
        int length = s.length();
        StringBuilder sb=new StringBuilder();
        for (String word:words){
            length = length-word.length();
            if (length>=0){
                sb.append(word);
            }else {
                break;
            }
        }
        return s.equals(sb.toString());
    }
}
