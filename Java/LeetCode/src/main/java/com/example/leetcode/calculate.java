package com.example.leetcode;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2021/3/10 9:03
 * @description
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class calculate {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
//        String s = "-2+ 1";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
       Stack<Integer> val = new Stack<>();
       int sign = 1;
       int res = 0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c = chars[i];
            if (Character.isDigit(c)){
                int temp = c-'0';
                while (i+1 < chars.length && Character.isDigit(chars[i+1])){
                    temp = temp*10 + (chars[++i]-'0');
                }
                res = res + sign*temp;

            }else if (c == '+'){
                sign=1;
            }else if (c == '-'){
                sign=-1;
            }else if (c == '('){
                val.push(res);
                res =0;
                val.push(sign);
                sign=1;
            }else if (c==')'){
                res = val.pop() * res + val.pop();
            }
        }
        return res;
    }
}
