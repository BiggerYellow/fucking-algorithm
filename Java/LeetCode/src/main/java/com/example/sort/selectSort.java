package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/22 21:10
 * @description
 */
public class selectSort {
    public static void main(String[] args) {
        int[] nums = {5,1,8,3,6,2};
        selectSort(nums);
        System.out.println(nums);
    }

    public static void selectSort(int[] nums){
        int len = nums.length;
        for (int i=0;i<len;i++){
            int min = i;
            for (int j=i+1;j<len;j++){
                if (nums[min] > nums[j]){
                    min=j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
