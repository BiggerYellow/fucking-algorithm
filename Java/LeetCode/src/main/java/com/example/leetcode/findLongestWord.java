package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/9/14 9:24
 * @description
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * "abce"
 * ["abe","abc"]
 *
 * "bab"
 * ["ba","ab","a","b"]
 *
 * "wordgoodgoodgoodbestword"
 * ["word","good","best","good"]
 */
public class findLongestWord {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("word");
        dictionary.add("good");
        dictionary.add("best");
        dictionary.add("good");
        System.out.println(findLongestWord("wordgoodgoodgoodbestword", dictionary));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort(((o1, o2) -> {
            if (o1.length()>o2.length()){
                return -1;
            }else if (o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else {
                return 1;
            }
        }));

        for (int i=0;i<dictionary.size();i++){
            int left=0;
            int right=0;
            while (left<dictionary.get(i).length() && right<s.length()){
                if (dictionary.get(i).charAt(left) == s.charAt(right)){
                    left++;
                    right++;
                }else {
                    right++;
                }
            }
            if (left==dictionary.get(i).length()){
                return dictionary.get(i);
            }
        }
        return "";
    }
}
