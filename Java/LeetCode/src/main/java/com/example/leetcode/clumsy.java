package com.example.leetcode;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2021/4/1 9:29
 * @description
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * 示例 2：
 *
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clumsy-factorial
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class clumsy {
    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int N) {
        Stack<Integer> val = new Stack<>();
        int index =1;
        for (int i=N;i>0;i--){
            if (index%4 == 1){
                if (val.isEmpty()){
                    val.push(i);
                }else {
                    val.push(-i);
                }
            }
            if (index%4 == 2){
                val.push(val.pop() * i);
            }
            if (index%4 == 3){
                val.push(val.pop() / i);
            }
            if (index%4 == 0){
                val.push(val.pop() + i);
            }
            index++;
        }
        while (!(val.size() == 1)){
            val.push(val.pop()+val.pop());
        }
        return val.pop();
    }
}
