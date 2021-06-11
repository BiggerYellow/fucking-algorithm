package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/9/7 19:54
 * @description
 *
        给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
        请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
        你可以假设 nums1 和 nums2 不会同时为空。

        示例 1:
        nums1 = [1, 3]
        nums2 = [2]
        则中位数是 2.0
        示例 2:
        nums1 = [1, 2]
        nums2 = [3, 4]
        则中位数是 (2 + 3)/2 = 2.5

        思路1
        1.整合两个数组并排序
        2.当数组为奇数时直接取中间的数，若为偶数直接取中间两个数之和除以2
 */
public class four {
    public static void main(String[] args) {
        int[] num1 = new int[]{};
        int[] num2 = new int[]{2,3};
        System.out.println(getMid(num1, num2));
    }

    public static double getMid(int[] num1, int[] num2){
        int[] all = sort(num1, num2);
        //偶数个直接取中间两数之和除以2
        if (all.length%2 == 0){
            return (all[all.length/2 -1] + all[all.length/2])/2.0;
        }else {
            //奇数个直接取中间值
            return all[(all.length-1)/2];
        }
    }

    public static int[] sort(int[] num1, int[] num2){
        int[] all = new int[num1.length + num2.length];
        int i=0;
        int j=0;
        int k=0;
        //当num1和num2都有值时
        while (i<num1.length && j<num2.length){
            if (num1[i] >num2[j]){
                all[k++] = num2[j++];
            }else {
                all[k++] = num1[i++];
            }
        }
        //当num1还有值时
        while (i<num1.length){
            all[k++] = num1[i++];
        }
        //当num2还有值时
        while (j<num2.length){
            all[k++] = num2[j++];
        }
        return all;
    }
}
