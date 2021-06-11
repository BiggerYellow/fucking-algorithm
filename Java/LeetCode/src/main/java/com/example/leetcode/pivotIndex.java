package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author huangchunchen
 * @date 2021/1/28 17:20
 * @description
 *
    给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

    数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。

    如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。



    示例 1：

    输入：nums = [1, 7, 3, 6, 5, 6]
    输出：3
    解释：
    索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
    同时, 3 也是第一个符合要求的中心索引。
    示例 2：

    输入：nums = [1, 2, 3]
    输出：-1
    解释：
    数组中不存在满足此条件的中心索引。
 *
 */
public class pivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
//        int[] nums = new int[]{-1,-1,-1,0,1,1};
        System.out.println(pivotIndex1(nums));
    }

    //暴力破解法
    //遍历数组 每次分别求索引左右两侧的和
    public static int pivotIndex(int[] nums) {
        for (int i=0;i<nums.length-1;i++){
            int left = 0;
            for (int l=0;l<i;l++){
                left+=nums[l];
            }
            int right = 0;
            for (int r=i+1;r<nums.length;r++){
                right+=nums[r];
            }
            if (left == right){
                return i;
            }
        }
        return -1;
    }

    //求和法
    //由题意得 总和sum = temp(左和) + temp(右和) + nums[i]
    //       总结的 sum = 2*temp + nums[i]
    public static int pivotIndex1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int temp = 0;
        for (int i=0;i<nums.length;i++){
            if (temp*2 + nums[i] == sum){
                return i;
            }
            temp += nums[i];
        }
        return -1;
    }


    }
