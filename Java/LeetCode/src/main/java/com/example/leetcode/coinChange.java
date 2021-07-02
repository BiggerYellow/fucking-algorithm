package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/6/24 10:10
 * @description
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class coinChange {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
        int[] coins = { 2};
        System.out.println(coinChange(coins, 3));
    }

    //dp[j] 代表凑成总金额j的最少硬币数
    //转移方程:  每次有选或不选两种情况，取两者最小值
    //           若不选 dp[j] = dp[j]
    //           若选   dp[j] = dp[j-coins[i]]+1
    //          综上: dp[j] = min(dp[j], dp[j-coins[i]]+1)
    //初始化: dp[0]=0 因为求最小值 数值所有值直接赋最大值,最大值即是商品价值
    //结果 dp[amount]
    public static int coinChange(int[] coins, int amount) {
        int max =amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0]=0;
        for (int coin:coins){
            for (int j=coin;j<=amount;j++){
                dp[j] = Math.min(dp[j], dp[j-coin]+1);
            }
        }
        return dp[amount] == max ?-1:dp[amount];
    }
}
