package com.example.leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/7/14 11:22
 * @description
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 *
 * |x| 定义为：
 *
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * 示例 2：
 *
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * 示例 3：
 *
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *  
 *
 * 提示：
 *
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minAbsoluteSumDiff {
    public static void main(String[] args) {
        int[] nums1 = {1,10,4,4,2,7};
        int[] nums2 = {9,3,5,1,7,4};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1000000007;
        int len = nums1.length;
        int[] temp = new int[len];
        System.arraycopy(nums1, 0, temp, 0,len);
        Arrays.sort(temp);

        int sum=0;
        int max=0;
        for (int i=0;i<len;i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            sum = (sum+diff)%MOD;
            int j = binarySearch(temp, nums2[i]);
            if (j < len){
                max = Math.max(max, diff - (temp[j]-nums2[i]));
            }
            if (j>0){
                max = Math.max(max, diff - (nums2[i]-temp[j-1]));
            }
        }
        return (sum-max + MOD)%MOD;
    }

    public static int binarySearch(int[] arr, int target){
        int start =0, end = arr.length-1;
        if (arr[end] < target){
            return end+1;
        }
        while (start<end){
            int mid = start + (end-start)/2;
            if (arr[mid] < target){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;
    }

}
