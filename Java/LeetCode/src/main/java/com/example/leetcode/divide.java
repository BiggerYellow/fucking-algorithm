package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/12/29 9:56
 * @description
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class divide {

    public static void main(String[] args) {
//        System.out.println(divide(7,-3));
//        System.out.println(divide(10,3));
//        System.out.println(divide(1,1));
//        System.out.println(divide(-2147483648,-1));
//        System.out.println(divide(-2147483648,2));
        long l = System.currentTimeMillis();
        System.out.println(divide(-2147483648
                , -3));
        System.out.println(System.currentTimeMillis() - l);
//        System.out.println(divide(2147483647,2));
    }

    public static int divide(int dividend, int divisor) {
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        boolean flag = false;
        if ((dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0)) {
            flag = true;
        }
        if (dividend <= Integer.MIN_VALUE && absDivisor == 1) return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        if (dividend > Integer.MAX_VALUE) return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int res = 0;
        if (absDividend >= 0 && absDivisor >= 0) {
            while (absDividend >= absDivisor) {
                res++;
                absDividend -= absDivisor;
            }
        } else {
            while (absDividend <= -absDivisor) {
                res++;
                absDividend -= -absDivisor;
            }
        }

        return flag ? -res : res;
    }

    public static int divide1(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = div(a, b);
        int ree = (int) res;
        if (sign > 0) return ree > Integer.MAX_VALUE ? Integer.MAX_VALUE : ree;
        return -ree;
    }

    public static long div(long a, long b) {  // 似乎精髓和难点就在于下面这几句
        if (a < b) return 0;
        long count = 1;
        long tb = b; // 在后面的代码中不更新b
        while ((tb + tb) <= a) {
            count = count + count; // 最小解翻倍
            tb = tb + tb; // 当前测试的值也翻倍
        }
        return count + div(a - tb, b);
    }
}
