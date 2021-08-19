package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/7/8 10:14
 * @description
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 示例 2：
 *
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numSubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum1(nums, 2));
    }

    public static int numSubarraysWithSum1(int[] nums, int goal){
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int res=0;
        for (int num:nums){
            map.put(sum,map.getOrDefault(sum, 0)+1);
            sum+=num;
            res+=map.getOrDefault(sum-goal, 0);
        }
        return res;
    }

    public static int res=0;
    public static int numSubarraysWithSum(int[] nums, int goal) {
        dfs(nums, 0, goal);
        return res;
    }

    public static void dfs(int[] nums, int track, int goal){
        if (track == goal){
            res++;
            return;
        }
        for (int num:nums){
            if (track+num > goal){
                continue;
            }
            track += num;
            dfs(nums, track, goal);
            track -= num;
        }
    }
}
