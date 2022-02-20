package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/2/19 22:50
 * @description:
 * 5997. 找到和为给定整数的三个连续整数 显示英文描述
 * 通过的用户数2500
 * 尝试过的用户数2640
 * 用户总通过次数2506
 * 用户总提交次数3309
 * 题目难度Medium
 * 给你一个整数 num ，请你返回三个连续的整数，它们的 和 为 num 。如果 num 无法被表示成三个连续整数的和，请你返回一个 空 数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 33
 * 输出：[10,11,12]
 * 解释：33 可以表示为 10 + 11 + 12 = 33 。
 * 10, 11, 12 是 3 个连续整数，所以返回 [10, 11, 12] 。
 * 示例 2：
 *
 * 输入：num = 4
 * 输出：[]
 * 解释：没有办法将 4 表示成 3 个连续整数的和。
 *
 *
 * 提示：
 *
 * 0 <= num <= 1015
 */
public class sumOfThree {
    public static void main(String[] args) {
        System.out.println(sumOfThree(4));
    }

    public static long[] sumOfThree(long num) {
        long[] res = new long[3];
        if (num%3 != 0){
            return new long[0];
        }
        res[0] = num/3-1;
        res[1] = num/3;
        res[2] = num/3+1;
        return res;
    }
}
