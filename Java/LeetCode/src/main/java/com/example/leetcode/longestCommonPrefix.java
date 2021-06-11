package com.example.leetcode;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author huangchunchen
 * @date 2020/12/7 17:22
 * @description
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class longestCommonPrefix {

    public static void main(String[] args) {
//        String[] strs = new String[]{"flower","flow","flight"};
//        String[] strs = new String[]{"dog","racecar","car"};
        String[] strs = new String[]{"c","ccc","ccc"};
        System.out.println(longestCommonPrefix(strs));
    }

//    public static String longestCommonPrefix(String[] strs){
//        if (strs.length ==0) return "";
//        if (strs.length == 1) return strs[0];
//        String res = "";
//        String temp = strs[0];
//        for (int i=1;i<strs.length;i++){
//            StringBuilder sb = new StringBuilder();
//            for (int j=0;j<strs[i].length();j++){
//                if (j < temp.length() && temp.charAt(j) == strs[i].charAt(j)){
//                    sb.append(strs[i].charAt(j));
//                }else {
//                    break;
//                }
//            }
//            if (res.equals("") || res.length() > sb.toString().length()) res = sb.toString();
//            temp = res;
//        }
//        return res;
//    }

    public static String longestCommonPrefix(String[] strs){
        if (strs.length ==0) return "";
        if (strs.length == 1) return strs[0];
        String res = "";
        String temp = strs[0];
        for (int i=1;i<strs.length;i++){
            String prefix = getPrefix(temp, strs[i]);
            if (res.equals("") || res.length() > prefix.length()) res = prefix;
            temp = res;
        }
        return res;
    }

    public static String getPrefix(String str1, String str2){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str1.length();i++){
            if (i<str2.length() && str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }
}
