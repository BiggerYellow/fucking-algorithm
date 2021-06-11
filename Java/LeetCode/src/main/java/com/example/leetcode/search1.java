package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/4/7 9:59
 * @description
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class search1 {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,5,6,0,0,1,2};
        int[] nums = new int[]{1,0,1,1,1};
        System.out.println(search(nums, 0));
    }

    public static boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return false;
        if (len == 1) return nums[0] == target?true:false;
        int start = 0;
        int end = len-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (nums[mid] == target) return true;
            //当首尾相同时 将start++直到不相等
            if (nums[start] == nums[end]){
                ++start;
                continue;
            }
            //前半部分有序
            if (nums[start]<= nums[mid]){
                //target在前半部分
                if (nums[start] <=target && nums[mid] >target){
                    end = mid-1;
                }else {//否则去后半部分找
                    start = mid+1;
                }
            }else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] <target && nums[len-1] >=target){
                    start = mid+1;
                }else {//否则去前半部分找
                    end = mid-1;
                }
            }
        }
        return false;
    }
}
