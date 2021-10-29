package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huangchunchen
 * @date 2021/10/27 9:44
 * @description
 * 301. 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 *
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 *
 * 输入：s = ")("
 * 输出：[""]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */
public class removeInvalidParentheses {
    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(removeInvalidParentheses1(s));
    }

    public static List<String> res = new ArrayList<>();

    public static List<String> removeInvalidParentheses1(String s) {
        //记录需要删除的左右括号数量
        int lremove = 0;
        int rremove = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '('){
                lremove++;
            }else if (s.charAt(i) == ')'){
                if (lremove ==0){
                    rremove++;
                }else {
                    lremove--;
                }
            }
        }
        dfs(s, 0, lremove, rremove);
        return res;
    }

    public static void dfs(String s, int start, int lremove, int rremove){
        //只有当需要移除的左右括号数量都为0,且当前字符串满足条件加人res
        if (lremove == 0 && rremove==0){
            if (isValid(s)){
                res.add(s);
            }
            return;
        }

        for (int i=start;i<s.length();i++){
            //若相邻两个元素相同不处理 因为都是相同的可能会出现重复元素 可以将res改为set解决
            if (i!=start && s.charAt(i) == s.charAt(i-1)){
                continue;
            }
            //若需要移除的数量大于剩余的字符串数量 直接返回
            if (lremove+rremove > s.length()-i){
                return;
            }
            //当前是左括号且需要存在需要移除的左括号 则移除该左括号
            if (lremove>0&&s.charAt(i)=='('){
                dfs(s.substring(0,i)+s.substring(i+1), i, lremove-1, rremove);
            }
            //当前是右括号且需要存在需要移除的右括号 则移除该右括号
            if (rremove>0&&s.charAt(i)==')'){
                dfs(s.substring(0, i)+s.substring(i+1), i, lremove, rremove-1);
            }
        }
    }



    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> cache = new HashSet<>();
        cache.add(s);
        while (true){
            for (String str:cache){
                if (isValid(str)){
                    res.add(str);
                }
            }
            if (res.size()>0){
                return res;
            }
            Set<String> temp = new HashSet<>();
            for (String str:cache){
                for (int i=0;i<str.length();i++){
                    //剪枝 去重重复元素
                    if (i>0 && str.charAt(i) == str.charAt(i-1)){
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) ==')'){
                        temp.add(str.substring(0, i)+ str.substring(i+1));
                    }
                }
            }
            cache = temp;
        }
    }

    public static boolean isValid(String s){
        char[] chars = s.toCharArray();
        int count=0;
        for (int i=0;i<chars.length;i++){
            if (chars[i] == '('){
                count++;
            }else if (chars[i]==')'){
                count--;
                if (count<0){
                    return false;
                }
            }
        }
        return count==0;
    }
}
