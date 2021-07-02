package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/6/18 11:07
 * @description
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class canPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
//        int[] nums = {1,2,3,5};
//        int[] nums = {9,1,2,4,10};
//        int[] nums = {1,5,10,6};
        System.out.println(canPartition(nums));
    }

    //即 nums的总和一定是偶数
    //转换为 从nums中取出总和恰好的sum/2的背包
    //动态方程:dp[i][j]  代表前i个数字是否可以装满容量为j的背包 装满为true、不满为false  注意 j=cap+1,需要考虑容量为0的情况
    //转移方程: 双层遍历 第一层遍历数组nums，第二层遍历容量cap
    //          当 nums[i] > 容量j 即无法放入背包
    //          当 nums[i] == 容量j 即当前数刚刚好等于背包重量  dp[i][j] = true
    //          当 nums[i] < 容量j 需要考虑当前数放不放 不放则取前一个容量为j的 dp[i-1][j] 放则取前一个容量为j-nums[i]的 两种情况有一个成立即可 dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]]
    //          nums[i] > j -> dp[i][j]=false
    //          nums[i] == j -> dp[i][j]=true
    //          nums[i] < j -> dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]]
    //初始化: 在nums[0] <= cap时，将dp[0][nums[0]] =true
    //结果: dp[n-1][sum/2] 即取nums中 容量为sum/2的存在与否
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2==1) return false;
        int cap = sum/2;
        boolean[][] dp = new boolean[nums.length][cap+1];

        if (nums[0] <= cap) {
            dp[0][nums[0]] = true;
        }
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<=cap;j++){
                dp[i][j] = dp[i - 1][j];

                if (nums[i]<j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }

                if (nums[i]==j){
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length-1][cap];
    }

    //空间优化 dp[i][j] 只和dp[i-1][j]、dp[i-1][j-nums[i]]有关 所以可以使用一维数组
    //注意：内层遍历需要从cap递减到0
    public static boolean canPartition1(int[] nums){
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2==1)return false;
        int cap=sum/2;
        boolean[] dp = new boolean[cap+1];
        if (nums[0] <= cap) {
            dp[nums[0]] = true;
        }
        for (int i=1;i<nums.length;i++){
            for (int j=cap;j>=nums[i];j--){
                if (nums[i] < j){
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
                if (nums[i]==j){
                    dp[j]=true;
                }
            }
        }
        return dp[cap];
    }
}
