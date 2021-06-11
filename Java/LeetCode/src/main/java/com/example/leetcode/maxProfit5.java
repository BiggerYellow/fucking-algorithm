package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/5/25 14:00
 * @description
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxProfit5 {
    public static void main(String[] args) {

    }

    //动态方程
    //状态： 0--代表不持有股票  1--代表持有股票
    //dp[i][j] 代表在第i天时 股票状态为j时的最大利润
    //转移方程： dp[i][0] 即第i天时不持有股票，有两种情况 第i-1天也不持有股票dp[i-1][0] 或 第i-1天持有股票卖出加上第i天的价格再减去手续费 dp[i-1][1]+prices[i]-fee
    //              dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
    //          dp[i][1] 即第i天时持有股票，有两种情况  第i-1天也持有股票dp[i-1][1]   或 第i-1天不持有股票在买入 在减去当天的价格 dp[i-1][0]-prices[i]
    //              dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
    //初始化：dp[0][0] = 0
    //       dp[0][1] = -prices[0]
    //结果： dp[n-1][0]
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    //空间优化
    //每个状态只和前两个状态有关
    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i=1;i<n;i++){
            dp0 = Math.max(dp0, dp1 + prices[i]-fee);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }
}
