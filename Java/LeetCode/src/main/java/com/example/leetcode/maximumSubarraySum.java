package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :huangchunchen
 * @date :Created in 2022/11/6 11:32
 * @description:
 */
public class maximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
//        int[] nums = {9,9,9,1,2,3};
        int[] nums = {5,3,3,1,1};
        System.out.println(maximumSubarraySum(nums, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        long sum = 0;
        int left = 0;
        int right = 0;
        int len = nums.length;
        Set<Integer> cache = new HashSet<>();
        while(left <= right && right < len){
            if(right-left <= k-1){
                if(cache.contains(nums[right])){
                    left = right;
                    sum = 0;
                    cache.clear();
                }
                sum+=nums[right];
                cache.add(nums[right]);
                right++;
            }else{
                sum -= nums[left];
                cache.remove(nums[left]);
                left++;
            }
            if(cache.size() == k){
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
