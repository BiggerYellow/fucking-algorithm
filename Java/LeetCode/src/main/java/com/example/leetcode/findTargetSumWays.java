package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/6/7 9:10
 * @description
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findTargetSumWays {
    public static void main(String[] args) {
//        int[] nums = {1,0};
        int[] nums = {7,9,3,8,0,2,4,8,3,9};
        System.out.println(findTargetSumWays1(nums, 0));
    }

    public static int res=0;

    //回溯
    //维护一个全局的变量  统计 当索引位置到nums末尾且 总和==target时 即count++
    //递归遍历每个元素
    public static int findTargetSumWays(int[] nums, int target) {
        dfs(nums,  target, 0 ,0);
        return res;
    }

    public static void dfs(int[] nums, int target, int index, int sum){
        if (index == nums.length){
            if (sum == target){
                res++;
            }
        }else {
            dfs(nums, target, index+1,sum+nums[index]);
            dfs(nums, target, index+1,sum-nums[index]);
        }
    }

    //动态规划
    //由题意得，假设sum为nums的总和，因为只会有加减符号，所以sum肯定是大于等于target的
    //所有以减号开头的总和设为 mins, 以加号开头的总和为 sum-mins
    //      (sum-mins)-mins = sum-2*mins = target
    //          mins = (sum-target)/2
    //该题可以转换为在nums中找到 和为 (sum-target)/2 的方案个数
    //定义动态方程:  dp[i][j] 代表在nums中的前i个数中找到元素之和等于j的方案数
    //转移方程:     对于1<=i<=n时，对于数组nums中的第i个元素num,遍历0<=j<=mins,计算dp[i][j]的值
    //             如果j < num，则不能取num， dp[i][j] = dp[i-1][j]
    //             如果j >=num, 若取num, dp[i][j] = dp[i-1][j-num] 若不取num,dp[i][j]=dp[i-1][j] --> dp[i][j] = dp[i-1][j]+dp[i-1][j-num]
    //初始化: dp[0][0] = 1
    //最终结果: dp[n][mins]
    public static int findTargetSumWays1(int[] nums, int target) {
        int n = nums.length;
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=nums[i];
        }
        int diff = sum - target;
        if (diff == 0 || diff %2 !=0){
            return 0;
        }
        int mins = diff/2;
        int[][] dp = new int[n+1][mins+1];
        dp[0][0] = 1;
        for (int i=1;i<=n;i++){
            int num = nums[i-1];
            for (int j=0;j<=mins;j++){
                if (j < num){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
                }
            }
        }
        return dp[n][mins];
    }

    //动态规划 空间优化
    //由于dp的每一行只与上一行有关，因此可以使用滚动数组的方式，去掉dp的一个维度，将空间优化到O(mins)
    //内层循环使用倒叙遍历的方式，保证转移来的是 dp[i-1][]中的元素值
    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num:nums){
            sum+=num;
        }
        int diff = sum-target;
        if (diff<0 || diff%2 !=0){
            return 0;
        }
        int mins=(sum-target)/2;
        int[] dp = new int[mins+1];
        dp[0]=1;
        for (int num:nums){
            for (int j=mins;j>=num;j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[mins];
    }
}
