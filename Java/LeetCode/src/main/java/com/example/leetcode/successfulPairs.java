package com.example.leetcode;

import java.util.Arrays;

/**
 * @author :huangchunchen
 * @date :Created in 2022/6/11 22:53
 * @description:
 * 6096. 咒语和药水的成功对数 显示英文描述
 * 通过的用户数783
 * 尝试过的用户数1104
 * 用户总通过次数783
 * 用户总提交次数1414
 * 题目难度Medium
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 *
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 *
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * 示例 2：
 *
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 *
 *
 * 提示：
 *
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 105
 * 1 <= spells[i], potions[i] <= 105
 * 1 <= success <= 1010
 */
public class successfulPairs {
    public static void main(String[] args) {
        int[] spells = {3,1,2}, potions = {8,5,8};
        long success = 16;
        int[] res = successfulPairs(spells, potions, success);
        System.out.println(res);
//        int[] p = {1,2,2,2,3,3,3,4,5};
//        System.out.println(find(p, 3));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int len = spells.length;
        int len1 = potions.length;
        int[] res = new int[len];
        for (int i=0;i<len;i++){
            long temp = 0;
            if (success%spells[i] == 0){
                 temp = success/spells[i];

            }else {
                 temp = success/spells[i] + 1;
            }
            if (potions[0] >= temp){
                res[i] = len1-1;
                continue;
            }
            if (potions[len1-1] < temp){
                res[i] = 0;
                continue;
            }
            int index = find(potions, temp);
            res[i] = len1 - index;
        }
        return res;
    }

    public static int find(int[] potions, long num){
        int start = 0;
        int end = potions.length-1;
        while(start<end){
            int mid = start + (end - start)/2;
            if (potions[mid] < num){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        if (potions[start] > num) {
            return start;
        }
        return end;
    }
}
