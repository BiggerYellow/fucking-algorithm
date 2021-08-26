package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author huangchunchen
 * @date 2021/8/22 11:00
 * @description
 * 给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。
 *
 * 从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。
 *
 * 返回 最小的绝对差 。
 *
 * a 和 b 两数字的 绝对差 是 a - b 的绝对值。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
 * 输出：0
 * 解释：一种可能的最优选择方案是：
 * - 第一行选出 1
 * - 第二行选出 5
 * - 第三行选出 7
 * 所选元素的和是 13 ，等于目标值，所以绝对差是 0 。
 * 示例 2：
 *
 *
 *
 * 输入：mat = [[1],[2],[3]], target = 100
 * 输出：94
 * 解释：唯一一种选择方案是：
 * - 第一行选出 1
 * - 第二行选出 2
 * - 第三行选出 3
 * 所选元素的和是 6 ，绝对差是 94 。
 * 示例 3：
 *
 *
 *
 * 输入：mat = [[1,2,9,8,7]], target = 6
 * 输出：1
 * 解释：最优的选择方案是选出第一行的 7 。
 * 绝对差是 1 。
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 70
 * 1 <= mat[i][j] <= 70
 * 1 <= target <= 800
 */
public class minimizeTheDifference {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minimizeTheDifference(mat, 13));
    }

    public static int res=Integer.MAX_VALUE;

    public static Set<Integer> cache = new HashSet<>();

    public static int minimizeTheDifference(int[][] mat, int target) {

        dfs(mat, 1, 0, target);
        for (int num: mat[0]){
            for (int ca:cache){
                res = Math.min(res, Math.abs(target-num-ca));
            }
        }
        return res;
    }

    public static void dfs(int[][] mat, int track, int count, int target){
        if (track == mat.length){
            cache.add(count);
            return;
        }
        for (int j=0;j<mat[track].length;j++){
            count+=mat[track][j];
            dfs(mat, track+1, count, target);
            count-=mat[track][j];
        }

    }
}
