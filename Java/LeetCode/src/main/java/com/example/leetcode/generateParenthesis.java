package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2020/12/22 9:08
 * @description
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class generateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n==0) return res;
        DFS("", n,n,res);
        return res;
    }

    public static void DFS(String curStr, int left, int right, List<String> res){
        if (left == 0 && right == 0){
            res.add(curStr);
            return;
        }

        if (left > right){
            return;
        }

        if (left > 0){
            DFS(curStr+"(", left-1, right, res);
        }

        if (right > 0){
            DFS(curStr + ")", left, right-1,res);
        }
    }

}
