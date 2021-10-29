package com.example.leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/10/2 23:12
 * @description
 * 给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = ["777","7","77","77"], target = "7777"
 * 输出：4
 * 解释：符合要求的下标对包括：
 * - (0, 1)："777" + "7"
 * - (1, 0)："7" + "777"
 * - (2, 3)："77" + "77"
 * - (3, 2)："77" + "77"
 * 示例 2：
 *
 * 输入：nums = ["123","4","12","34"], target = "1234"
 * 输出：2
 * 解释：符合要求的下标对包括
 * - (0, 1)："123" + "4"
 * - (2, 3)："12" + "34"
 * 示例 3：
 *
 * 输入：nums = ["1","1","1"], target = "11"
 * 输出：6
 * 解释：符合要求的下标对包括
 * - (0, 1)："1" + "1"
 * - (1, 0)："1" + "1"
 * - (0, 2)："1" + "1"
 * - (2, 0)："1" + "1"
 * - (1, 2)："1" + "1"
 * - (2, 1)："1" + "1"
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 100
 * 1 <= nums[i].length <= 100
 * 2 <= target.length <= 100
 * nums[i] 和 target 只包含数字。
 * nums[i] 和 target 不含有任何前导 0 。["1","111"]
 * "11"["9","93","9","2","32","32"]
 * "932"
 */
public class numOfPairs {
    public static void main(String[] args) {
        String[] nums = {"9","93","9","2","32","32"};
        System.out.println(numOfPairs(nums, "932"));
    }


    public static int numOfPairs(String[] nums, String target) {
        HashMap<String, Integer> cache = new HashMap<>();
        for (String num:nums){
            cache.put(num, cache.getOrDefault(num, 0)+1);
        }

        int res=0;
        for (String num:nums){
            if (num.length()>target.length()) continue;
            if (!target.substring(0,num.length()).equals(num)) continue;;
            String temp = target.substring(num.length());
            res+=cache.getOrDefault(temp, 0);
            if (temp.equals(num)){
                res--;
            }
        }
        return res;
    }

}
