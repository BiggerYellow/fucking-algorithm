package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/5/31 9:07
 * @description
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x  x=log4 n
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 00010000
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 00000101
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 * 00000001
 *
 * 123456789
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isPowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(7));
    }

    //为4的幂次方 即也为2^2的幂次方 即 二进制上有且只能有奇位数为1
    //使用一个偶数位全为1的做与操作，只要为0代表没有奇位数为1
    public static boolean isPowerOfFour(int n) {
       int M = 0xaaaaaaaa;
       return n>0 && (n&(n-1))==0 && (n&M) == 0;
    }


}
