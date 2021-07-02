package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/6/22 10:24
 * @description
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 *
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 *
 * 任何的工作至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 *
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 *
 * 示例 1：
 *
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 *
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class profitableSchemes {
    public static void main(String[] args) {
        int[] group = {2,3,5};
        int[] profit = {6,7,8};
        System.out.println(profitableSchemes(10,5,group, profit));
    }

    //动态方程:dp[i][n][m] 代表前i项工作由n个人完成最小利润为m的计划数
    //转移方程:dp[i][n][m] 当前工作有两种情况 完成或者不完成
    //              1.当不能够完成时 dp[i-1][n][m]   n<group[i]
    //              2.当能够完成时也可以选择不完成
    //                  2.1.完成 dp[i-1][n-group[i]][m-profit[i]]
    //                  2.2.不完成 dp[i-1][n][m]
    //                  取和 dp[i][n][m] = dp[i-1][n][m] + dp[i-1][n-group[i]][max(0,m-profit[i])]
    //              综上:
    //                     n < group[i]  -> dp[i][n][m] = dp[i-1][n][m]
    //                     n >= group[i] -> dp[i][n][m] = dp[i-1][n][m] + dp[i-1][n-group[i]][max(0,m-profit[i])]+1
    //初始化: dp[0][0][0]=1
    //结果:  sum += dp[len][i][minProfit] (0<=i<=n)
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = profit.length;
        int MOD = (int)1e9 + 7;
        int[][][] dp = new int[len+1][n+1][minProfit+1];
//        dp[0][0][0]=1;
        for (int i=1;i<=len;i++){
            int tempGroup = group[i-1];
            int tempProfit= profit[i-1];
            for (int j=0;j<=n;j++){
                for (int m=0;m<=minProfit;m++){
                    if (j<tempGroup ){
                        dp[i][n][m] = dp[i-1][n][m];
                    }else {
                        dp[i][n][m] = (dp[i-1][n][m]+dp[i-1][n-tempGroup][Math.max(0,m-tempProfit)])%MOD ;
                    }
                }
            }
        }
        int sum=0;
        for (int j=0;j<=n;j++){
            sum= (sum+dp[len][j][minProfit])%MOD;
        }
        return sum;
    }
}
