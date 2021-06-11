package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/6/4 11:06
 * @description
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 *
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
 * 如果第一枚鸡蛋碎了，可知 f = 0；
 * 如果第二没鸡蛋碎了，但第一枚没碎，可知 f = 1；
 * 否则，当两个鸡蛋都没碎时，可知 f = 2。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：14
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class twoEggDrop {
    public static void main(String[] args) {
        System.out.println(twoEggDrop(2));
    }

    //动态规划
    //动态方程: dp[i][j] 代表 第i层剩余j+1个鸡蛋的最少操作数
    //转移方程: 当j=0时，表明只剩下一个鸡蛋了 那dp[i][0] = i
    //         当j=1时，表明有两个鸡蛋，若第一个鸡蛋在k层丢下(1<=k<=i)，若鸡蛋碎了即验证k-1层需要的次数 即dp[k-1][0]，总次数为dp[k-1][0]+1
    //                                                             若鸡蛋没碎即验证i-k层需要的次数 即dp[j-k][1],总次数为dp[j-k][1]+1
    //                                                             取上面两种情况的最大值
    //初始化:  dp[0][0]=0
    //         dp[i][0] = 1
    //结果:   dp[n][1]
    public static int twoEggDrop(int n) {
       int[][] dp=new int[n+1][2];
       for (int[] array:dp){
           Arrays.fill(array, Integer.MAX_VALUE);
       }
       dp[0][0]=0;
       for (int i=1;i<=n;i++){
           dp[i][0]=i;
       }
       for (int i = 1; i <=n; i++){
           for (int k = 1; k<= i; k++){
               dp[i][1] = Math.min(dp[i][1], Math.max(dp[k-1][0]+1, dp[i -k][1]+1));
           }
       }
       return dp[n][1];
    }

    //空间优化 降为一维数组
    //dp[i][0] = i 可以去掉  dp[i]直接表示为第i层剩余2个鸡蛋的最少操作数
    public static int twoEggDrop2(int n){
        int[] dp= new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for (int i=1;i<=n;i++){
            for (int k=1;k<=i;k++){
                dp[i] = Math.min(dp[i], Math.max(k, dp[i-k]+1));
            }
        }
        return dp[n];
    }

    public static int twoEggDrop1(int n){
        int[][] dp = new int[2][n+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= j; k++) {
                dp[1][j] = Math.min(dp[1][j], Math.max(dp[0][k - 1]+1, dp[1][j - k] + 1));
            }
        }
        return dp[1][n];
    }

}
