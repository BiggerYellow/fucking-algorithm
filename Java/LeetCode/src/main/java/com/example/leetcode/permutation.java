package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/6/22 3:48
 * @description
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class permutation {
    public static void main(String[] args) {
//        String s = "abc";
        String s = "aab";
        System.out.println(permutation(s));
    }
    public static List<String> res = new ArrayList<>();
    public static boolean[] vis;

    public static String[] permutation(String s) {
        StringBuilder sb = new StringBuilder();
        vis=new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars,0, sb);
        String[] ress=new String[res.size()];
        for (int i=0;i<res.size();i++){
            ress[i]=res.get(i);
        }
        return ress;
    }

    public static void dfs(char[] chars, int index, StringBuilder track){
        if (chars.length==track.length()){
            res.add(track.toString());
        }
        for (int i=0;i<chars.length;i++){
            //两种情况直接跳过
            //1.当前位置遍历过
            //2.当前位置没有遍历过，就看上一个位置没有遍历过，且相邻两个字母相同
            if (vis[i] || (i>0 && !vis[i-1]&&chars[i-1]==chars[i])){
                continue;
            }
            vis[i]=true;
            track.append(chars[i]);
            dfs(chars,index+1, track);
            track.deleteCharAt(track.length()-1);
            vis[i]=false;
        }
    }
}
