package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/7 9:21
 * @description
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class searchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
//        int[] nums = new int[]{1,3};
        System.out.println(searchInsert1(nums,5));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int start=0;
        int end = length-1;
        if (nums[start] > target) return 0;
        if (nums[end] < target) return length;
        while (start<=end){
            int mid = (start+end)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return nums[start] <target ? start+1:start;
    }

    public static int searchInsert1(int[] nums, int target){
        int length = nums.length;
        int start=0;
        int end = length-1;
        while (start <=end){
            int mid = start + (end-start)/2;
            if (nums[mid] > target){
                end = mid-1;
            }else {
                start = mid+1;
            }
            if (nums[mid] == target){
                return mid;
            }
        }
        return start;
    }
}
