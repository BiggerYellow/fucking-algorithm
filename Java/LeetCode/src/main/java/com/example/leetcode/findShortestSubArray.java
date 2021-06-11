package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/2/20 9:23
 * @description
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findShortestSubArray {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 2, 3, 1};
        int[] nums = new int[]{1,2,2,3,1,4,2};
//        int[] nums = new int[]{1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        int res=Integer.MAX_VALUE;
        int[] left = new int[Arrays.stream(nums).max().getAsInt()+1];
        Arrays.fill(left,-1);
        int[] right = new int[Arrays.stream(nums).max().getAsInt()+1];
        int[] count = new int[Arrays.stream(nums).max().getAsInt()+1];
        for (int i=0;i<nums.length;i++){
            if ( left[nums[i]] == -1 ){
                left[nums[i]] = i;
            }
            right[nums[i]] =i;
            count[nums[i]] = count[nums[i]]+1;
        }
        int max = Arrays.stream(count).max().getAsInt();
        for (int i=0;i<count.length;i++){
            if (count[i] == max){
                res = Math.min(res, right[i] - left[i] +1);
            }
        }
        return res;
    }
}
