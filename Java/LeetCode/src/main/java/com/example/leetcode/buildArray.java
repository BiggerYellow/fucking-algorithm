package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/7/4 11:37
 * @description
 */
public class buildArray {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        System.out.println(buildArray(nums));
    }

    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
