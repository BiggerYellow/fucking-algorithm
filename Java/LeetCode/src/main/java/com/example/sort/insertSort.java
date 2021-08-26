package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/22 22:38
 * @description
 */
public class insertSort {
    public static void main(String[] args) {
        int[] nums = {5,2,4,8,1};
        insertSort(nums);
        System.out.println(nums);
    }

    public static void insertSort(int[] nums){
        int len = nums.length;
        for (int i=1;i<len;i++){
            for (int j=i;j>0 && nums[j]<nums[j-1];j--){
                swap(nums, j, j-1);
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
