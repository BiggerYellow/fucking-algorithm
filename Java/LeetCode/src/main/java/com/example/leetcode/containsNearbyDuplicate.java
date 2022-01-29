package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :huangchunchen
 * @date :Created in 2022/1/19 10:28
 * @description:
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 *
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
public class containsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            int temp = cache.getOrDefault(nums[i], -1);
            if (temp == -1){
                cache.put(nums[i], i);
            }else {
                if (Math.abs(i-temp) <= k){
                    return true;
                }
            }
        }
        return false;
    }
}
