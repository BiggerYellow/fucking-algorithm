package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/6/10 9:16
 * @description
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class change {
    public static void main(String[] args) {
        int[] coins = {1, 4, 9};
        System.out.println(change(13, coins));
    }

    //动态规划 完全背包问题
    //动态方程dp[i]: 代表 金额为i的组合数
    //转移方程: 外层遍历coins  内层遍历 coin到amount  更新 dp[j]+=dp[j-coin]
    //初始化: dp[0]=1
    //结果: dp[amount]
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for (int coin:coins){
            for (int j=coin;j<=amount;j++){
                dp[j] +=dp[j-coin];
            }
        }
        return dp[amount];
    }


}
