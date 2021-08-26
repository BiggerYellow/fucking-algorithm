package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/23 11:08
 * @description
 */
public class shellSort {
    public static void main(String[] args) {
        int[] nums = {7,1,5,9,2,4};
        shellSort(nums);
        System.out.println(nums);
    }

    public static void shellSort(int[] nums){
        int len = nums.length;
        int factor = 2;
        int h=1;
        while (h<len/factor){
            h = h*factor+1;
        }
        while (h>=1){
            for (int i=h;i<len;i++){
                for (int j=i;j>=h && nums[j]<nums[j-h];j-=h){
                    swap(nums, j, j-h);
                }
            }
            h/=factor;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
