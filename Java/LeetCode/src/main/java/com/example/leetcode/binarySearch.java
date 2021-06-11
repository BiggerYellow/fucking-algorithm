package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/6 9:34
 * @description
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5,7,9};
        System.out.println(binarySearch(nums, 11));
    }

    public static int binarySearch(int[] nums, int target){
        int start =0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start+end)/2;
            if (nums[mid] < target){
                start = mid +1;
            }else if (nums[mid] > target){
                end = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
