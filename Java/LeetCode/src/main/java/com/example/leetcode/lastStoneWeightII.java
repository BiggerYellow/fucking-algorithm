package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

import static com.example.leetcode.partition.temp;

/**
 * @author huangchunchen
 * @date 2021/6/8 9:05
 * @description
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 *
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 *
 * 输入：stones = [1,2]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = new int[]{31,26,33,21,40};
//        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeightII2(stones));
    }

    public static int res = Integer.MAX_VALUE;

    public static int lastStoneWeightII1(int[] stones) {
        dfs(stones, 0, 0);
        return res;
    }

    public static void dfs(int[] stones, int index, int sum){
        if (index == stones.length ){
            if (sum>=0){
                res = Math.min(res, sum);
            }
        }else {
            dfs(stones, index+1, sum+stones[index]);
            dfs(stones, index+1, sum-stones[index]);
        }
    }

    //动态规划  01背包
    //仔细读题，该题和昨天的题目类似，即加上随机数量的减号使得总和最小
    //即 指定数量的两个集合  使得他们的差值最小  理想情况就是 sum/2
    //dp方程: dp[i][j] 代表在前 i 个石头中，容量为j的背包所能存放的最大值
    //转移方程:     先遍历石头i，在遍历容量j
    //             当j<stones[i]时 石头不能放进背包只能跳过  dp[i][j] = dp[i-1][j]
    //             当j>=stones[i]时 取可以放入石头和不放入石头的最大值  放入石头  dp[i][j]=dp[i-1][j-stones[i]]+stones[i]  不放入石头 dp[i][j]=dp[i-1][j] --> dp[i][j] = max(dp[i-1][j], dp[i-1][j-stones[i]]+stones[i])
    //无需初始化
    //结果: sum-dp[n][sum/2]*2 取 所有石头下重量为总重量的一半 再乘2 在用总重量减去 即为最后的差值
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num:stones){
            sum+=num;
        }
        int cap = sum/2;
        int[][] dp = new int[stones.length+1][cap+1];
        for (int i=1;i<=stones.length;i++){
            for (int j=0;j<=cap;j++){
                if (j<stones[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i-1]]+stones[i-1]);
                }
            }
        }
        return sum-dp[stones.length][cap]*2;
    }

    //空间优化
    //因为每一个状态只和前一个有关dp[i][]=dp[i-1][]，可以使用滚动数组
    //但是在内层需要倒叙遍历
    public static int lastStoneWeightII2(int[] stones) {
        int sum=0;
        for (int num:stones){
            sum+=num;
        }
        int cap=sum/2;
        int[] dp=new int[cap+1];
        for (int num:stones){
            for (int j=cap;j>=num;j--){
                dp[j] = Math.max(dp[j], dp[j-num]+num);
            }
        }
        return sum-dp[cap]*2;
    }


    }
