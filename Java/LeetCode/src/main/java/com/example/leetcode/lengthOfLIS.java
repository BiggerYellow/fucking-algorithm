package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/7/26 11:22
 * @description
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS2(nums));

    }
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res =1;
        Arrays.fill(dp,1);
        for (int i=1;i<len;i++){
            for (int j=i;j>=0;j--){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int lengthOfLIS1(int[] nums){
        int len = nums.length;
        int[] temp = new int[len+1];
        int res=1;
        temp[res] = nums[0];
        for (int i=1;i<len;i++){
            if (nums[i] > temp[res]){
                temp[++res] = nums[i];
            }else {
                int l=1,r=res,pos=0;
                while (l<=r){
                    int mid = (l+r)>>1;
                    if (temp[mid] < nums[i]){
                        pos = mid;
                        l = mid+1;
                    }else {
                        r=mid-1;
                    }
                    temp[pos+1] = nums[i];
                }
            }
        }
        return res;
    }

    public static int lengthOfLIS2(int[] nums){
        int len = nums.length;
        int[] tail = new int[len+1];
        int res=0;
        for (int num:nums){
            int i=0,j=res;
            while (i<j){
                int mid = (i+j)/2;
                if (tail[mid] < num){
                    i=mid+1;
                }else {
                    j=mid;
                }
            }
            tail[i] = num;
            if (res==j){
                res++;
            }
        }
        return res;
    }
}
