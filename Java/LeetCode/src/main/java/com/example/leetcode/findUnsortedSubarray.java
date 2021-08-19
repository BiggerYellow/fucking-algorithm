package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/8/3 11:14
 * @description
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
//        int[] nums = {1,3,2,2,2};
//        int[] nums = {1,2,3,3,3};
//        int[] nums = {1,3,2,3,3};
//        int[] nums = {1,3,2,4,5};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int max=0;
        int left=0;
        for (;left<nums.length-1;left++){
            max = Math.max(nums[left], nums[left+1]);
            if (nums[left]>nums[left+1]){
                break;
            }
        }
        if (left == nums.length-1){
            return 0;
        }

        int right=nums.length-1;
        for (;right>=left;right--){
           if (max <= nums[right]){
//               max = Math.max(max, nums[right]);
           }else {
               break;
           }
        }
        return right-left+1;
    }
}
