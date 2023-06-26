package com.example.leetcode;

/**
 * @author chunchne.huang
 * @description
 * https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
 * @date 2022-11-24 19:47:48
 */
public class numSubarrayBoundedMax {
    public static void main(String[] args) {
        int[] nums = {2,9,2,5,6};
        System.out.println(numSubarrayBoundedMax(nums, 2,8));
    }


    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int len = nums.length;
        int last1 = -1;
        int last2 = -1;
        int res = 0;
        for(int i=0;i<len;i++){
            if(nums[i] >= left && nums[i] <= right){
                last1 = i;
            }
            if(nums[i] > right){
                last2 = i;
                last1 = -1;
            }
            if(last1 != -1){
                res += last1 - last2;
            }
        }
        return res;
    }
}
