package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/11/6 10:48
 * @description:https://leetcode.cn/contest/weekly-contest-318/problems/apply-operations-to-an-array/
 */
public class applyOperations {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,0};
        System.out.println(applyOperations(nums));
    }


    public static int[] applyOperations(int[] nums) {
        int len = nums.length;
        int right = len-1;
        for(int i=0;i<len-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
            if(nums[i] == 0){
                while(right > 0 && nums[right] == 0){
                    right--;
                }
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }
}
