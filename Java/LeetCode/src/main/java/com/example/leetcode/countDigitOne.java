package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/8/13 9:21
 * @description
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 13
 * Output: 6
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 *  
 *
 * Constraints:
 *
 * 0 <= n <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countDigitOne {
    public static void main(String[] args) {

    }

    public static int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
