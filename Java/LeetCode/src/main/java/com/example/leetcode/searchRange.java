package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/6 17:29
 * @description
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class searchRange {
    public static void main(String[] args) {
//        int[] nums = new int[]{5,7,7,8,8,10};
        int[] nums = new int[]{};
        int[] ints = searchRange(nums, 0);
        System.out.println(ints);

    }

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length-1;
        int res =-1;
        while (start <=end){
            int mid = (start + end)/2;
            if (nums[mid] > target){
                end = mid -1;
            }else if (nums[mid] < target){
                start = mid +1;
            }else {
                res = mid;
                break;
            }
        }
        int[] resArray = new int[]{-1,-1};
        if (res ==-1){
            return resArray;
        }else {
            int left = res;
            int right = res;
            while (left >=0 && nums[left] == target){
                left--;
            }
            while (right <=length-1 && nums[right] == target){
                right++;
            }
            resArray[0] = left+1;
            resArray[1] = right-1;
        }
        return resArray;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length-1;
        int[] resArray = new int[]{-1,-1};
        while (start <=end){
            int mid = (start + end)/2;
            if (nums[mid] > target){
                end = mid -1;
            }else if (nums[mid] < target){
                start = mid +1;
            }else {
                int left = mid;
                int right = mid;
                while (left >=0 && nums[left] == target){
                    left--;
                }
                while (right <=length-1 && nums[right] == target){
                    right++;
                }
                resArray[0] = left+1;
                resArray[1] = right-1;
                return resArray;
            }
        }
        return resArray;
    }
}
