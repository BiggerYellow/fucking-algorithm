package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/4 8:47
 * @description
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 *
 * 1 2 3 4
 * 1 2 4 3
 * 1 3 2 4
 * 1 3 4 2
 * 1 4 2 3
 * 1 4 3 2
 * 2 1 3 4
 * 2 1 4 3
 * 2 3 1 4
 * 2 3 4 1
 * ...
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class nextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        System.out.println(nums);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到数组从后往前找到降序排列的第一个位置i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //找到比nums[i]大一点点的位置j 并交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //将i+1 到nums.lenght排序
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
