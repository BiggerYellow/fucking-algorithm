package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/6/16 9:09
 * @description
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 *  
 *
 * 示例：
 *
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class stoneGame {
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
//        int[] piles = {3,7,4,3};
        System.out.println(stoneGame1(piles));
    }

    //递归
    public static boolean stoneGame(int[] piles) {
        return rec(0,piles.length-1, piles)>0;
    }

    //当 i=j 时, 即只有一个堆时 直接取当前堆
    //若取第i堆 即开头第一个, 则需要减去[i+1,j]堆中的最大值
    //若取第j堆 即最后一个,  则需要减去[i,j-1]堆中的最大值
    public static int rec(int i, int j, int[] piles){
        if (i==j) return piles[i];
        return Math.max(piles[i]-rec(i+1, j, piles), piles[j]-rec(i, j-1, piles));
    }


    //使用动态规划替换递归
    //动态方程:dp[i][j] 代表从第i堆到第j堆中，先手玩家和后手玩家的石子数量之差
    //转移方程: 每次只能取最前面i或者最后面j,这两者的最大值
    //         先手玩家取前面piles[i],那么dp[i+1][j]表示后手玩家在这个区间内比先手玩家多的最大石子数,取反表示先手玩家的最多的石子数: dp[i][j] = piles[i]+(-dp[i+1][j])
    //         先手玩家取后面piles[j],那么dp[i][j-1]表示后手玩家在这个区间内比先手玩家多的最大石子数,取反表示先手玩家的最多的石子数: dp[i][j] = piles[j]+(-dp[i][j-1])
    //          dp[i][j] = max(piles[i]-dp[i+1][j], piles[j]-dp[i][j+1])
    //初始化:当i=j时，即只有一个堆 直接取即可 dp[i][i] = piles[i]
    //结果: dp[0][piles.length-1] > 0 即最后的差值大于0
    public static boolean stoneGame1(int[] piles){
        int n=piles.length;
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++){
            dp[i][i] = piles[i];
        }

        for (int i=n-1;i>=0;i--){
            for (int j=i+1;j<n;j++){
                dp[i][j] = Math.max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1]>0;
    }
}
