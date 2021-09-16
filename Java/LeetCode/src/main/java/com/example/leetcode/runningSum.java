package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/8/28 20:39
 * @description
 */
public class runningSum {
    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]+nums[i];
        }
        return res;
    }
}
