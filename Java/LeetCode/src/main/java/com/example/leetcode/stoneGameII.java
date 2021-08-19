package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/7/16 11:12
 * @description
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 *
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 *
 * 游戏一直持续到所有石子都被拿走。
 *
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 *
 *  
 *
 * 示例：
 *
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 *  
 *
 * 提示：
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class stoneGameII {
    public static void main(String[] args) {
        int[] piles = {2,7,9,4,4};
//        int[] piles = {9,2,2,8,3,7,9,9};
        System.out.println(stoneGameII(piles));

    }

    public static Map<String, Integer> cache = new HashMap<>();
    public static int stoneGameII(int[] piles) {
        int length = piles.length;
        int[] sum = new int[length+1];
        for (int i=length-1;i>=0;i--){
            sum[i] = sum[i+1]+piles[i];
        }
        return dfs(0,1,length, sum);
    }

    //dfs(i,m) 代表从第i个石子堆开始拿,允许拿1<=x<=2*m,在剩余的石子中所能拿到的最大值
    //筛选条件: 1.如果i>=n 说明石子已经拿完 直接返回0
    //         2.如果i+2*m>=n 说明可以把剩余的石子都拿完,返回剩余的石子数 => 这里需要倒序求出石子的前缀和,即剩余的石子数
    //         3.如果不属于上面两种情况, 遍历1<=i<=2*m,求对手拿的最少的石子dfs(i+x, max(x,m)),因为对手拿最少自己也就拿最多 => temp = max(temp, sum[i]-dfs(i+x, max(i,m)))
    public static int dfs(int i, int m,int length, int[] sum){
        String key = i+"_"+m;
        if (cache.containsKey(key)){
            return cache.get(key);
        }
//        if (i>=length){
//            return 0;
//        }
        if (i+2*m>=length){
            return sum[i];
        }
        int temp=0;
        for (int x=1;x<=2*m;x++){
            temp = Math.max(temp, sum[i] - dfs(i+x,Math.max(x,m), length, sum));
        }
        cache.put(key, temp);
        return temp;
    }

    //dp[i][j] 代表从第i个石子堆开始拿j个石子的最大石子数
    //根据上面的回溯可得转移方程: i+2*m>=len 直接取剩下的石子数  dp[i][m] = sum[i]
    //                         i+2*m <len 遍历所有的1<=x<2*m情况 既然要求第一个拿的最多,那么肯定要求出第二个人拿的最少 即 dp[i][j] = max(dp[i][j], sum[i]- dp[i+x][sum(j,x)])
    //初始化: 默认都为0
    //结果: dp[0][1]
    public static int stoneGameII1(int[] piles) {
        int length = piles.length;
        int sum=0;
        int[][] dp = new int[length][length+1];
        for (int i=length-1;i>=0;i--){
            sum+=piles[i];
            for (int j=1;j<=length;j++){
                if (i+2*j >= length){
                    dp[i][j] = sum;
                }else {
                    for (int x=1;x<=2*j;x++){
                        dp[i][j] = Math.max(dp[i][j], sum-dp[i+x][Math.max(j,x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
    }
