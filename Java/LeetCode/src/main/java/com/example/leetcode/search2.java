package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/7/16 9:10
 * @description
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class search2 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search(nums, 8));
    }

    public static int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while (i<=j){
            int mid = i + (j-i)/2;
            if (nums[mid] <= target){
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        int right = i;
        if (j>=0&& nums[j]!=target) return 0;
        i=0;
        j=nums.length-1;
        while (i<=j){
            int mid = i + (j-i)/2;
            if (nums[mid] < target){
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        int left = j;
        return right-left-1;
    }

    public static int search1(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
}
