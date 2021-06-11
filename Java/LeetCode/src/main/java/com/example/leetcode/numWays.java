package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/5/13 9:07
 * @description
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 *
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 *
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numWays {
    public static void main(String[] args) {
        System.out.println(numWays1(27,7));
    }

    //动态规划
    //动态数组 dp[i][j] 代表 第 i 步时当前指针在位置 j 时候的方案数
    //转移方程： 1. dp[0][0] = 1
    //          2.dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]    dp[i][j]只能从上一个位置的左边、原位置、右边获得
    //注意：理论上指定可以达到的最长位置是step/2 + 1 取和arrLen的最小值
    public static int numWays1(int steps, int arrLen) {
        int maxCol = Math.min(steps/2 +1, arrLen-1);
        int[][] dp = new int[steps+1][maxCol+1];
        dp[0][0] = 1;
        for (int i=1;i<=steps;i++){
            for (int j=0;j<=maxCol;j++){
                //位于最左边时，只能从上一步的当前位置或是右边一位转移过来
                if (j==0){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j+1])%1000000007;
                    //位于最右边时，只能从上一步的当前位置或是左边一位转移过来
                }else if (j == maxCol){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%1000000007;
                }else {
                    dp[i][j] = ((dp[i-1][j] + dp[i-1][j-1])%1000000007 + dp[i-1][j+1])%1000000007;
                }
            }
        }
        return dp[steps][0];
    }

    //动态数组优化  二维降一维  因为dp[i][j] 只和上一个位置有关
    public static int numWays2(int steps, int arrLen) {
        int maxCol = Math.min(steps/2+1, arrLen-1);
        int[] dp = new int[maxCol+1];
        dp[0] =1;
        for (int i=1;i<=steps;i++){
            int[] temp = new int[maxCol+1];
            for (int j=0;j<=maxCol;j++){
                //位于最左边时，只能从上一步的当前位置或是右边一位转移过来
                if (j==0){
                    temp[j] = (dp[j] + dp[j+1])%1000000007;
                    //位于最右边时，只能从上一步的当前位置或是左边一位转移过来
                }else if (j == maxCol){
                    temp[j] = (dp[j] + dp[j-1])%1000000007;
                }else {
                    temp[j] = ((dp[j] + dp[j-1])%1000000007 + dp[j+1])%1000000007;
                }
            }
            dp = temp;
        }
        return dp[0];
    }




    public static int res = 0;

    //dfs
    //从步骤0开始算
    //退出条件 步骤递增到steps且当前位置要为0 res++
    //         遍历移动方向 -1,0,1
    //         移动后的位置是否在数组内 不满足则continue 满足则step++
    //          回溯遍历
    //          撤销走的方向
    public static int numWays(int steps, int arrLen) {
        dfs(steps, arrLen, 0,0);
        return res;
    }

    public static void dfs(int steps, int arrLen, int step, int cur){
        if (steps == step && cur == 0){
            res++;
            return;
        }
        for (int i=-1;i<=1;i++){
            int after = cur + i;
            if (after< 0 || after >arrLen){
                continue;
            }
            step++;
            dfs(steps, cur, step, after);
            step--;
        }
    }
}
