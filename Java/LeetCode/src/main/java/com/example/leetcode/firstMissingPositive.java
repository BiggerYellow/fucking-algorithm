package com.example.leetcode;

import java.util.HashSet;

/**
 * @author huangchunchen
 * @date 2021/1/18 9:06
 * @description
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class firstMissingPositive {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        int i = firstMissingPositive2(nums);
        System.out.println(i);
    }

    public static int firstMissingPositive(int[] nums) {
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }

    public static void bubbleSort(int[] nums){
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int temp = nums[j];
                if (temp < nums[i]){
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    //hash表
    public static int firstMissingPositive1(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        //将数组中的数放在hash表中
        for (int num:nums){
            hashSet.add(num);
        }
        //从1遍历到nums.length  如果i不在hash表中直接返回i 如果都在则返回 nums.length+1
        for (int i=1;i<=nums.length;i++){
            if (!hashSet.contains(i)){
                return i;
            }
        }
        return nums.length +1 ;
    }

    public static int firstMissingPositive2(int[] nums) {
       int n = nums.length;
       //首先将数组中的负数都赋值为n+1
       for (int i=0;i<n;i++){
           if (nums[i] <= 0){
               nums[i] = n+1;
           }
       }
        //找到数组中数小于n的  并将num位置上的数置为负数
       for (int i=0;i<n;i++){
           int num = Math.abs(nums[i]);
           if (num <=n){
               nums[num-1] = -Math.abs(nums[num-1]);
           }
       }
        //遍历处理过的数组 当遇到第一个大于0的数时直接返回i+1 没有则返回n+1
       for (int i=0;i<n;i++){
           if (nums[i] >0){
               return i+1;
           }
       }
       return n+1;
    }
}
