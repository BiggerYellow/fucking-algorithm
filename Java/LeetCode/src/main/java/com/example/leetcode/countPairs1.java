package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :huangchunchen
 * @date :Created in 2022/2/19 22:40
 * @description:5996. 统计数组中相等且可以被整除的数对 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,1,2,2,2,1,3], k = 2
 * 输出：4
 * 解释：
 * 总共有 4 对数符合所有要求：
 * - nums[0] == nums[6] 且 0 * 6 == 0 ，能被 2 整除。
 * - nums[2] == nums[3] 且 2 * 3 == 6 ，能被 2 整除。
 * - nums[2] == nums[4] 且 2 * 4 == 8 ，能被 2 整除。
 * - nums[3] == nums[4] 且 3 * 4 == 12 ，能被 2 整除。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4], k = 1
 * 输出：0
 * 解释：由于数组中没有重复数值，所以没有数对 (i,j) 符合所有要求。
 */
public class countPairs1 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,2,2,1,3};
        System.out.println(countPairs(nums, 2));
    }

    public static int countPairs(int[] nums, int k) {
        HashMap<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
        for (int i=0;i<nums.length;i++){
            if (cache.containsKey(nums[i])){
                List<Integer> list = cache.get(nums[i]);
                list.add(i);
                cache.put(nums[i], list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                cache.put(nums[i], list);
            }
        }
        int res=0;
        for(Map.Entry<Integer, List<Integer>> ca:cache.entrySet()){
            if (ca.getValue().size() == 1){
                continue;
            }
            for (int i=0;i<ca.getValue().size();i++){
                for (int j = i+1;j<ca.getValue().size();j++){
                    if (ca.getValue().get(i)*ca.getValue().get(j)%k==0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
