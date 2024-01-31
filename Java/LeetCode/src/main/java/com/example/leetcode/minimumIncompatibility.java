package com.example.leetcode;

import java.util.Arrays;

/**
 * @author chunchen.huang
 * @description https://leetcode.cn/problems/minimum-incompatibility/
 * 给你一个整数数组 nums​​​ 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
 *
 * 一个子集的 不兼容性 是该子集里面最大值和最小值的差。
 *
 * 请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
 *
 * 子集的定义是数组中一些数字的集合，对数字顺序没有要求。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,4], k = 2
 * 输出：4
 * 解释：最优的分配是 [1,2] 和 [1,4] 。
 * 不兼容性和为 (2-1) + (4-1) = 4 。
 * 注意到 [1,1] 和 [2,4] 可以得到更小的和，但是第一个集合有 2 个相同的元素，所以不可行。
 * 示例 2：
 *
 * 输入：nums = [6,3,8,1,3,1,2,2], k = 4
 * 输出：6
 * 解释：最优的子集分配为 [1,2]，[2,3]，[6,8] 和 [1,3] 。
 * 不兼容性和为 (2-1) + (3-2) + (8-6) + (3-1) = 6 。
 * 示例 3：
 *
 * 输入：nums = [5,3,3,6,3,3], k = 3
 * 输出：-1
 * 解释：没办法将这些数字分配到 3 个子集且满足每个子集里没有相同数字。
 *  
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 16
 * nums.length 能被 k 整除。
 * 1 <= nums[i] <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-incompatibility
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023-06-28 20:03:28
 */
public class minimumIncompatibility {

    public static void main(String[] args) {

    }

    public static int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] index = new int[n+1];
        return 0;
    }
}
