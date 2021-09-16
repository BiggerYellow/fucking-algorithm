package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/9/2 11:39
 * @description
 * 55. Jump Game
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class canJump {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
//        int[] nums = {0};
//        int[] nums = {1,0,1,0};
        System.out.println(canJump1(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums[0] ==0 && nums.length !=1){
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0]=true;
        for (int i=0;i<len;i++){
            for (int j=1;j<=nums[i] && i+j<len && dp[i];j++){
                dp[i+j]=true;
            }
        }
        return dp[len-1];
    }


    public static boolean canJump1(int[] nums){
        int max=0;
        for (int i=0;i<nums.length;i++){
            if (i>max){
                return false;
            }
            max = Math.max(max, i+nums[i]);
        }
        return true;
    }


}
