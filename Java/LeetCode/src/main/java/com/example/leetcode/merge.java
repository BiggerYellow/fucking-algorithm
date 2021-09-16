package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/9/7 9:52
 * @description
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class merge {
    public static void main(String[] args) {
        int[][] intervals = {{15,18},{1,3},{2,6},{8,10}};
//        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
//        int[][] intervals = {{1,4},{0,4}};
//        int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] merge = merge(intervals);
        System.out.println(merge);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            return o1[0]-o2[0];
        }));
        List<int[]> res = new ArrayList<>();
        int end = intervals[0][1];
        int[] temp =intervals[0];
        for (int i=1;i<intervals.length;i++){
            if (intervals[i][1]<=end){
                continue;
            }else if (intervals[i][0] <= end && intervals[i][1]>=end) {
                temp[1] = intervals[i][1];
                end = intervals[i][1];
            }else if (intervals[i][0]>end){
                res.add(temp);
                end = intervals[i][1];
                temp = intervals[i];
            }
        }
        res.add(temp);
        int[][] arr = new int[res.size()][2];
        for (int i=0;i<res.size();i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
