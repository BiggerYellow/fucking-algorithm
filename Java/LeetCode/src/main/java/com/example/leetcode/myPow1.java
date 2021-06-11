package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/3/23 9:10
 * @description
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class myPow1 {
    public static void main(String[] args) {
        System.out.println(myPow1(2.00000, 10));
    }

    //递归 二分法
    public static double myPow(double x, int n) {
        long N = n;
        return N>=0?quickMul(x, N):1.0/quickMul(x,-N);
    }

    public static double quickMul(double x, long N){
        if (N == 0){
            return 1.0;
        }
        double v = quickMul(x, N / 2);
        return N%2 == 0?v*v:v*v*x;
    }

    //迭代 借用二进制
    public static double myPow1(double x, int n) {
        long N = n;
        return N>0?quickMul1(x,N):1.0/quickMul1(x,-N);
    }

    public static double quickMul1(double x, long N){
        double res = 1.0;
        double y = x;
        while (N>0){
            if (N%2 == 1){
                res *=y;
            }
            y*=y;
            N/=2;
        }
        return res;
    }

}
