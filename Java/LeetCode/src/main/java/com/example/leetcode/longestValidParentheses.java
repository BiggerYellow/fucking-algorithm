package com.example.leetcode;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2021/1/4 10:50
 * @description
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestValidParentheses {
    public static void main(String[] args) {
//        String s = "()(()";
        String s = ")()())";
        int i = longestValidParentheses1(s);
        System.out.println(i);

    }

    //借用栈
    public static int longestValidParentheses(String s) {
        Stack<Integer> opt = new Stack<Integer>();
        opt.push(-1);
        //结果
        int res=0;
        //遍历字符串
        for (int i=0; i<s.length();i++){
            //当字符等于 ( 压栈
            if (s.charAt(i) == '('){
                opt.push(i);
            }else {
                //当字符等于 ) 出栈
                opt.pop();
                //如果此时栈为空说明匹配已经结束 将当前值压栈  不为空说明可以继续匹配
                if (opt.isEmpty()){
                    opt.push(i);
                }else {
                    res = Math.max(res, i - opt.peek());
                }
            }
        }
        return res;
    }

    //双指针法
    public static int longestValidParentheses1(String s) {
        // ( 出现次数
        int left=0;
        // ) 出现次数
        int right=0;
        int res=0;
        //正向遍历
        for (int i=0;i<s.length();i++){
            //每个字符计数
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            //如果 左括号和右括号出现的次数相等表明成对出现了两者之和，如果右括号数量大于左括号说明不可能成对 将left和right置为0
            if (left==right){
                res = Math.max(res, left+right);
            }else if (right > left){
                left=right=0;
            }
        }
        //正向遍历结束 将 left和right置为0
        left = right = 0;
        //开始逆向遍历 同正向流程逻辑
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left==right){
                res = Math.max(res, left+right);
            }else if (left > right){
                left=right=0;
            }
        }
        return res;
    }
}
