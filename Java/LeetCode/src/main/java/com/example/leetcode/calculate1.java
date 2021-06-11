package com.example.leetcode;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2021/3/11 9:03
 * @description
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class calculate1 {
    public static void main(String[] args) {
        String s = "1+2*5/3+6/4*2";
        System.out.println(calculate1(s));
    }

    //双栈
    public static int calculate(String s) {
        Stack<String> val = new Stack<>();
        Stack<String> opt = new Stack<>();

        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i=0;i<len;i++){
            //左括号直接压栈
            if (chars[i] == '('){
                val.push(String.valueOf(chars[i]));
            }else if (Character.isDigit(chars[i])){
                //计算整数
                int temp =0;
                temp = chars[i]-'0';
                while (i+1<len && Character.isDigit(chars[i+1])){
                    temp = temp*10 +  (chars[++i] - '0');
                }
                //当符号栈最上面的为乘除号
                if (!opt.isEmpty() && (opt.peek().equals("*") || opt.peek().equals("/"))){
                    //直接计算压栈
                    val.push(cal(String.valueOf(temp), val.pop(), opt.pop()));
                    //去除空格
                    while (i+1 < len && chars[i+1] == ' ') {
                        i++;
                    }
                    //当前位置后最近的符号不为乘除号 或 遍历结束 直接计算数字栈里的值
                    if (i+1<len && chars[i+1] != '*' && chars[i+1] != '/' || i==len-1){
                        while (!opt.isEmpty()){
                            val.push(cal(val.pop(), val.pop(), opt.pop()));
                        }
                    }
                }else {//当符号栈最上面的为加减号
                    //去除空格
                    while (i+1 < len && chars[i+1] == ' ') {
                        i++;
                    }
                    //当前位置后最近的符号不为乘除 或 遍历到结尾  且 符号栈不为空
                    if (((i+1<len && chars[i+1] != '*' && chars[i+1] != '/') || i==len-1) && !opt.isEmpty()){
                        //计算结果
                        val.push(cal(String.valueOf(temp), val.pop(), opt.pop()));
                    }else {
                        //当数字压栈
                        val.push(String.valueOf(temp));
                    }
                }
                //符号直接压栈
            }else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/'){
                opt.push(String.valueOf(chars[i]));
            }else if (chars[i] == ')'){//如果是右括号 则要计算直到找到数字栈中对应的左括号
                while (!val.isEmpty()){
                    String resTemp = cal(val.pop(), val.pop(), opt.pop());
                    if (val.peek().equals("(")){
                        val.pop();
                    }
                    val.push(resTemp);
                }
            }
        }
        return Integer.valueOf(val.pop());
    }

    //计算加减乘除
    public static String cal(String val2,String val1, String opt){
        if (opt.equals("+")){
            return String.valueOf(Integer.valueOf(val1) + Integer.valueOf(val2));
        }
        if (opt.equals("-")){
            return String.valueOf(Integer.valueOf(val1) - Integer.valueOf(val2));
        }
        if (opt.equals("*")){
            return String.valueOf(Integer.valueOf(val1) * Integer.valueOf(val2));
        }
        if (opt.equals("/")){
            return String.valueOf(Integer.valueOf(val1) / Integer.valueOf(val2));
        }
        return null;
    }

    //单栈
    public static int calculate1(String s) {
        Stack<Integer> val = new Stack<>();
        char preSign = '+';
        char[] chars = s.toCharArray();
        int len  = chars.length;
        int num = 0;
        for (int i=0;i<len;i++){
            if (Character.isDigit(chars[i])){
                num = num*10 + chars[i]-'0';
            }
            if (!Character.isDigit(chars[i]) && s.charAt(i) != ' ' || i == len-1){
                switch (preSign){
                    case '+':
                        val.push(num);
                        break;
                    case '-':
                        val.push(-num);
                        break;
                    case '*':
                        val.push(val.pop()*num);
                        break;
                    case '/':
                        val.push(val.pop()/num);
                        break;
                }
                num = 0;
                preSign = s.charAt(i);
            }
        }
        int res = 0;
        while (!val.isEmpty()){
            res+=val.pop();
        }
        return res;
    }
}
