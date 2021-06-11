package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/5/25 11:26
 * @description
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxProfit4 {
    public static void main(String[] args) {

    }

    //动态规划
    //有三种状态
    //  0--目前持有一支股票，对应的累计最大收益记为 dp[i][0]
    //  1--目前不持有任何股票，并且处于冷冻期，对应的累计最大收益记为dp[i][1]
    //  2--目前不持有任何股票，并且不处于冷冻期中，对应的累计最大收益记为dp[i][2]
    //dp方程: dp[i][j] 代表 第i天 状态为j 的最大利润  j从0-2
    //转移方程：
    // 1.对于dp[i][0],这一支股票可以是在第i-1天就已经持有的，对应的状态为 dp[i-1][0];
    //      或者是第i天买入的，那么第 i-1天就不能持有股票并且不不处于冷冻期中，对应的状态为dp[i-1][2]加上买入股票的负收益prices[i]，状态转移方程为
    //          dp[i][0] = max(dp[i-1][0], dp[i-1][2] - prices[i])
    // 2.对于dp[i][1],在第i天结束之后处于冷冻期的原因是在当天卖出了股票，那么说明第i-1天我们必须持有股票，对应的状态为dp[i-1][0]加上卖出股票的正收益prices[i]
    //          dp[i][1] = dp[i-1][0] + prices[i]
    // 3.对于dp[i][2]，在第i天结束之后不持有任何股票并且不处于冷冻期，说明当天没有进行任何操作，即第i-1天时不持有任何股票：
    //                  如果处于冷冻期，对应的状态为f[i-1][1];如果不处于冷冻期，对应的状态为dp[i-1][2]
    //          dp[i][2] = max(dp[i-1][1], dp[i-1][2])
    //初始化： dp[0][0] = -prices[0]、 dp[0][1]= 0  、 dp[0][2] = 0
    //结果：max(dp[n-1][1], dp[n-1][2])
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0]=-prices[0];
        for (int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
