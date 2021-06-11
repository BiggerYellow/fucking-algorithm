package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/2/1 10:17
 * @description
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
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
public class myPow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow1(x, n));
    }

    //        {a*a^(b-1)    b为奇数}
    //a^b =   {(a^(b/2))^2  b为偶数}
    //快速幂+递归
    public static double myPow(double x, int n) {
        long N = n;
        return n>0?quickpower(x, N):1.0/quickpower(x,-N);
    }

    public static double quickpower(double x, long N){
        if (N == 0) return 1.00;

        if (N%2 == 1){
            return  x*quickpower(x, N-1);
        }else {
            double temp = quickpower(x, N/2);
            return temp*temp;
        }
    }

    //快速幂+迭代
    public static double myPow1(double x, int n) {
        long N = n;
        return n>=0?quickpower1(x, N):1.0/quickpower1(x,-N);
    }

    public static double quickpower1(double x, long N){
        double ans = 1.0;
        //x贡献的初始值为x
        double x_contribute = x;
        //对N进行二进制拆分 奇数需要计入贡献值 然后直接平方
        while (N > 0){
            //判断N是否奇数
            if (N%2 == 1){
                //计入贡献值
                ans *=x_contribute;
            }
            //将贡献直接平方
            x_contribute *= x_contribute;
            //舍弃N的最后一位
            N/=2;
        }
        return ans;
    }
}
