package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/5/26 11:26
 * @description
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * dp[i]即为 第i天的最高金额
 * dp[i] = max(dp[i-2]+nums[i], dp[i-1])
 * 初始化： dp[0] = 1
 *         dp[1] = max(nums[0], nums[1])
 * 结果： dp[n-1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class rob {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }

    /**
     * dp[i]即为 第i天的最高金额
     * dp[i] = max(dp[i-2]+nums[i], dp[i-1])
     * 初始化： dp[0] = 1
     *         dp[1] = max(nums[0], nums[1])
     * 结果： dp[n-1]
     */
    public static int rob(int[] nums){
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[n-1];
    }

    //空间优化
    //dp[i]只依赖 dp[i-1]和dp[i-2]两个值
    public static int rob1(int[] nums){
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        int prev = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i=2;i<n;i++){
            int temp = Math.max(prev + nums[i], cur);
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}
