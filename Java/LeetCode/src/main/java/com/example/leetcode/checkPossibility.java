package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/2/7 9:04
 * @description
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class checkPossibility {
    public static void main(String[] args) {
//        int[] nums = new int[]{4,2,1};
        int[] nums = new int[]{5,7,1,8};
//        int[] nums = new int[]{4,2,3};
//        int[] nums = new int[]{3,4,2,3};
        System.out.println(checkPossibility(nums));

    }

    public static boolean checkPossibility(int[] nums) {
        int count=0;
        for (int i=0;i<nums.length-1;i++){
            //当nums[i] > nums[i+1] 时才需要处理
            if (nums[i] > nums[i+1]){
                //次数加1
                count++;
                //次数大于1时直接返回false
                if (count >1 ){
                    return false;
                }
                //当num[i+1] < nums[i-1]时， 将nums[i] 赋值给nums[i+1] 保持递增特性
                if (i>0 && nums[i+1] < nums[i-1]){
                    nums[i+1] = nums[i];
                }
            }
        }
        return true;
    }
}
