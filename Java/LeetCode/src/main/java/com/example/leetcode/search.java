package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/6 9:26
 * @description
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class search {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search1(nums,0));
    }

    public static int search(int[] nums, int target) {
        int res=-1;
        for (int i=0;i<nums.length;i++){
            if (nums[i] == target){
                return i;
            }
        }
        return res;
    }

    public static int search1(int nums[], int target){
        int length = nums.length;
        if (length==0) return -1;
        if (length == 1) return nums[0] == target?0:-1;
        int start =0;
        int end=length-1;
        while (start <=end){
            int mid = (start+end)/2;
            //当中间值等于target时返回
            if (nums[mid] == target) return mid;
            // 先根据 nums[mid] 与 nums[0] 的关系判断 mid 是在左段还是右段
            if (nums[0] <= nums[mid]){
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 start 和 end
                if (nums[0] <= target && nums[mid] > target){
                    end = mid-1;
                }else {
                    start = mid+1;

                }
            }else {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 start 和 end
                if (nums[mid] < target && nums[length-1] >= target){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
