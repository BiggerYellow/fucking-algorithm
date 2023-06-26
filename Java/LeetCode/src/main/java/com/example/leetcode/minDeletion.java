package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/3/27 10:54
 * @description:
 * 5236. 美化数组的最少删除数 显示英文描述
 * 通过的用户数733
 * 尝试过的用户数940
 * 用户总通过次数735
 * 用户总提交次数1151
 * 题目难度Medium
 * 给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
 *
 * nums.length 为偶数
 * 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
 * 注意，空数组同样认为是美丽数组。
 *
 * 你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
 *
 * 返回使 nums 变为美丽数组所需删除的 最少 元素数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,3,5]
 * 输出：1
 * 解释：可以删除 nums[0] 或 nums[1] ，这样得到的 nums = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 1 个元素。
 * 示例 2：
 *
 * 输入：nums = [1,1,2,2,3,3]
 * 输出：2
 * 解释：可以删除 nums[0] 和 nums[5] ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 2 个元素。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class minDeletion {
    public static void main(String[] args) {
//        int[] nums = {1,1,2,2,3,3};
//        int[] nums = {1,1,2,3,5};
//        int[] nums = {3,2,7,6,2,5,8,1,8,4,2,2,6,8,7,7,8};
        int[] nums = {0,1,5,4,2,4,7,2,3,0,3,0,0,9,7,5,9,4,3,9,9,2,1,6,3,1,0,7,6,6,6,0,1,7,1,9,4,9,3,3,4,5,0,3,8,7,1,8,4,5};
        System.out.println(minDeletion(nums));
    }

    public static int minDeletion(int[] nums) {
        int len =  nums.length;
        int res = 0;
        int left = 0;
        int right = 1;
        while (right<len && left<len){
            if (nums[left] == nums[right]){
                res++;
                right++;
            }else {
                right+=2;
                left = right-1;
            }
        }
        if ((len - res)%2 != 0){
            res++;
        }
        return res;
    }

    public static int minDeletion1(int[] nums) {
        int len =  nums.length;
        int res = 0;
        for (int i=0;i<len;i+=2){
            if (i+1<len && nums[i] == nums[i+1]){
                res++;
                i++;
            }
        }
        if ((len-res)%2 != 0) res++;
        return res;
    }
}
