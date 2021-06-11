package com.example.leetcode;

import java.util.regex.Pattern;

/**
 * @author huangchunchen
 * @date 2021/4/15 9:04
 * @description
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *
 * 动态方程：dp[i][j]  代表 第 i 间房屋 且第一间偷过状态 j 的最高金额  j=0代表没偷  j=1代表偷了
 * 转移方程：dp[i][0]  max(dp[i-2][0]+nums[i], dp[i-1][0])
 *          dp[i][1]  if (i == n-1)  dp[i-1][1]
 * 初始化：dp[0][0] = 0
 *        dp[0][1] = nums[0]
 *        dp[1][0] = nums[1]
 *        dp[1][1] = nums[0]
 * 结果： max(dp[n-1][0],dp[n-1][1])
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class rob1 {

    /**
     * 动态方程：dp[i][j]  代表 第 i 间房屋 且第一间偷过状态 j 的最高金额  j=0代表没偷  j=1代表偷了
     * 转移方程：dp[i][0]  max(dp[i-2][0]+nums[i], dp[i-1][0])
     *          dp[i][1]  if (i == n-1)  dp[i-1][1]  else max(dp[i-2][1], dp[i-1][1])
     * 初始化：dp[0][0] = 0
     *        dp[0][1] = nums[0]
     *        dp[1][0] = nums[1]
     *        dp[1][1] = nums[0]
     * 结果： max(dp[n-1][0],dp[n-1][1])
     */
    public static int rob1(int[] nums){
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];
        for (int i=2;i<n;i++){
            dp[i][0] = Math.max(dp[i-2][0] + nums[i], dp[i-1][0]);
            if (i==n-1){
                dp[i][1] = dp[i-1][1];
            }else {
                dp[i][1] = Math.max(dp[i-2][1]+nums[i], dp[i-1][1]);
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
//        int[] nums = new int[]{4,1,2,7,5,3,1};
//        int[] nums = new int[]{1,3,1,3,100};
//        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob1(nums));
        System.out.println(rob(nums));
    }

    //动态规划
    //状态转移方程为: dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1])
    //边界条件为:    只有一间房时，dp[start] = nums[start]
    //              只有两间房时，dp[start=1] = Math.max(nums[start], nums[start+1])
    public static int rob(int[] nums) {
        if (nums.length == 1)  return nums[0];
        if (nums.length == 2)  return Math.max(nums[0], nums[1]);
        return Math.max(doRob(nums, 0,nums.length-2), doRob(nums, 1, nums.length-1));
    }

    public static int doRob(int[] nums, int start, int end){
        int first = nums[start];
        int second = Math.max(first, nums[start+1]);
        for (int i=start+2;i<=end;i++){
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
