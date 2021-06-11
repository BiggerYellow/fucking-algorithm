package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/4/23 10:13
 * @description
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class largestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,8,9,27};
        System.out.println(largestDivisibleSubset(nums));
    }

    //前提：1.整除具有传递性 即 a%b=0, b%c=0, => a%c=0 举例 (1,2,4,8) 遍历到4的时候最大整除子集为(1,2,4) 因为8能被4整除所以 8的最大整除子集 应该为4的最大整除子集+1 即(1,2,4,8)
    //      2.数组要有序
    //动态规划
    //dp[i]代表前i个元素中的最大的整除子集
    //动态方程为: dp[i]= Math.max(dp[i], dp[j]+1) 最后该dp[i]只能找到最大的整数子集的元素个数
    //想要获取最大整数子集：prev需要记录每次最大整除子集的前一个位置  回头遍历prev即是我们要找的集合
    //                   max代表最大整除子集数
    //                   maxIndex代表最大整除子集中最后一个元素的位置
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        //dp数组
        int[] dp = new int[nums.length];
        //最大整除子集中的前一个位置
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        //最大整除子集的个数
        int max=0;
        //最大整除子集的最后一个元素
        int maxIndex=0;
        //从i为1开始遍历
        for (int i=1;i<nums.length;i++){
            //j从0到i进行遍历取最大的整除子集数
            for (int j=0;j<i;j++){
                //当满足条件时
                if (nums[i]%nums[j]==0 && dp[i] < dp[j]+1){
                    //记录最大整除子集数
                    dp[i] = dp[j]+1;
                    //记录最大子集数的最大数的前一个位置
                    prev[i]=j;
                }
            }
            //取最大的整除子集数和最大整除子集中的最后一个位置
            if (dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        //获取结果
        List<Integer> res = new ArrayList<>();
        //倒叙遍历prev
        while (maxIndex !=-1){
            res.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return res;
    }
}
