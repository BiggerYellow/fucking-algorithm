package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/2/10 9:54
 * @description
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class checkInclusion {
    public static void main(String[] args) {
//        String s1 = "ab";
//        String s2 = "eidboaoo";
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1, s2));
    }

    //滑动窗口
    public static boolean checkInclusion(String s1, String s2) {
        int[] array = new int[26];
        int[] winFreq = new int[26];
        //存放s1的所有字母及出现次数
        for (char c: s1.toCharArray()){
            array[c-'a']++;
        }
        //s1中不同字母的出现次数
        int s1Count = 0;
        for (int i=0;i<26;i++){
            if (array[i] >0){
                s1Count++;
            }
        }
        //左右指针
        int left=0, right =0 ;
        //s2中不同字母的出现次数
        int count=0;
        //结束条件为右指针到达s2最右侧
        while (right<s2.length()){
            //当s2中的字母在s1数组中出现多次时
            if (array[s2.charAt(right)-'a'] > 0){
                //在窗口中将这个字母的出现次数+1
                winFreq[s2.charAt(right)-'a']++;
                //当两个数组中字母的出现次数相同时 count++
                if (array[s2.charAt(right)-'a'] == winFreq[s2.charAt(right)-'a']){
                    count++;
                }
            }
            //窗口扩张
            right++;
            //当不同的字母相同时 进一步处理出现次数
            while (count == s1Count){
                //当左右指针的长度等于s1的长度时返回
                if (right-left==s1.length()){
                    return true;
                }
                //当左指针的字母在s1中出现多次时
                if (array[s2.charAt(left)-'a']>0){
                    //将窗口对应的字母出现次数减1
                    winFreq[s2.charAt(left)-'a']--;
                    //当左指针字母在窗口中出现次数小于在array中出现的次数时 count--
                    if (array[s2.charAt(left)-'a'] > winFreq[s2.charAt(left)-'a']){
                        count--;
                    }
                }
                left++;
            }
        }

        return false;
    }


    //def backtrack(路径， 选择列表){
    //      if满足条件：
    //          res.add
    //          return
    //      for 选择 in 选择列表
    //          做选择
    //          backtrack(路径，选择列表)
    //          撤销选择
    // }
    public static void backtrack(char[] array, List<String> track, List<String> res){
        if (array.length == track.size()){
            StringBuilder sb = new StringBuilder();
            for (String s:track){
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }
        for (int i=0;i<array.length;i++){
            if (track.contains(String.valueOf(array[i]))){
                continue;
            }
            track.add(String.valueOf(array[i]));
            backtrack(array, track,res);
            track.remove(track.size()-1);
        }
    }

    //借用额外数组
    public static boolean checkInclusion1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m){
            return false;
        }

        //临时数组 存放 s1和s2的从0到s1.length长度的字母及出现次数
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for (int i=0;i<n;i++){
            ++array1[s1.charAt(i)-'a'];
            ++array2[s2.charAt(i)-'a'];
        }

        //当两个数组相同时直接返回true
        if (Arrays.equals(array1, array2)){
            return true;
        }
        //从n开始遍历s2直到结尾
        for (int i=n;i<m;i++){
            //添加当前位置到arrays2中
            ++array2[s2.charAt(i)-'a'];
            //删除i-n位置从array2中
            --array2[s2.charAt(i-n)-'a'];
            if (Arrays.equals(array1, array2)){
                return true;
            }
        }
        return false;
    }

    }
