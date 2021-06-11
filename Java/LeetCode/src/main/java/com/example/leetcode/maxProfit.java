package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/5/18 11:00
 * @description
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 *       -6,4,-2,3,-2
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxProfit {
    public static void main(String[] args) {
//        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices = new int[]{1,2};
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        int res=0;
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[j] > prices[i]){
                    res = Math.max(res, prices[j] - prices[i]);
                }
            }
        }
        return res;
    }

    //动态规划
    //dp[i] 代表 第i天的最大利润
    //动态方程 dp[i] = max(dp[i-1], prices[i] - minprice)
    public static int maxProfit1(int[] prices){
        int minprice = prices[0];
        int[] dp = new int[prices.length+1];
        dp[0] = 0;
        for (int i=1;i<prices.length;i++){
            minprice = Math.min(minprice, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - minprice);
        }
        return dp[prices.length-1];
    }

    //动态规划
    //dp[i][j] 代表 下标为i 这一天结束的时候，手上持股状态为 j 时，我们持有的现金数
    //      j==0 表示当前不持股   j==1 表示当前持股
    //状态转移方程：  dp[i][0] 规定了今天不持股，有以下两种情况
    //                       昨天不持股，今天什么都不做
    //                       昨天持股，今天卖出股票（现金增加）
    //              dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
    //              dp[i][1] 规定了今天持股，有以下两种情况
    //                       昨天持股，今天什么都不做
    //                       昨天不持股，今天买入股票,手上的现金就是今天股票的相反数
    //              dp[i][1] = max(dp[i-1][1], -prices[i])
    public static int maxProfit2(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[i][0] 代表 下标为i这天结束的时候，不持股，手上的现金数
        //dp[i][1] 代表 下标为i这天结束的时候，持股，手上的现金数
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];
    }
}
