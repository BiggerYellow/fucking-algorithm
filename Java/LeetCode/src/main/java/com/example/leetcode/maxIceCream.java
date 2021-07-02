package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/7/2 9:05
 * @description
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 *
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 *
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 *
 * 注意：Tony 可以按任意顺序购买雪糕。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * 示例 2：
 *
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * 示例 3：
 *
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxIceCream {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        System.out.println(maxIceCream3(costs, 7));
    }

    //dp[i] dp[i][j] 代表前i只雪糕 在花费j的情况下能买到的最大数量
    // dp[i][j] = max(dp[i-1][j], dp[i-1][j-cost[i]]+1)
    //dp[0][0]=0
    //dp[n-1][coins]
    public static int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        int[][] dp = new int[n+1][coins+1];
        dp[0][0] = 0;
        for (int i=1;i<=n;i++){
            for (int j=costs[i-1];j<=coins;j++){
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-costs[i-1]]+1);
            }
        }
        return dp[n][coins];
    }

    //空间优化
    public static int maxIceCream1(int[] costs, int coins){
        int[] dp = new int[coins+1];
        for (int cost:costs){
            for (int j=coins;j>=cost;j--){
                dp[j] = Math.max(dp[j], dp[j-cost]+1);
            }
        }
        return dp[coins];
    }

    //排序+贪心
    public static int maxIceCream2(int[] costs, int coins){
        Arrays.sort(costs);
        int res=0;
        for (int cost:costs){
            if (coins-cost>=0){
                res++;
                coins-=cost;
            }else {
                break;
            }
        }
        return res;
    }

    public static int maxIceCream3(int[] costs, int coins){
        int[] temp = new int[100001];
        for (int cost:costs){
            temp[cost]++;
        }
        int res=0;
        for (int i=1;i<100001;i++){
            if (coins>=i){
                int count = Math.min(temp[i], coins/i);
                res+=count;
                coins-=count*i;
            }else {
                break;
            }
        }
        return res;
    }


}
