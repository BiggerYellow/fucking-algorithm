package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/9/9 9:30
 * @description
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *
 *
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */
public class insert {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{6,9}};
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] newInterval = {10,11};
        int[] newInterval = {4,8};
        int[][] insert = insert(intervals, newInterval);
        System.out.println(insert);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean place = false;
        List<int[]> cache = new ArrayList<>();
        for (int[] interval:intervals){
            if (interval[0]>right){
                if (!place){
                    cache.add(new int[]{left,right});
                    place=true;
                }
                cache.add(interval);
            }else if (interval[1]<left){
                cache.add(interval);
            }else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if (!place){
            cache.add(new int[]{left, right});
        }
        int[][] ans = new int[cache.size()][2];
        for (int i = 0; i < cache.size(); ++i) {
            ans[i] = cache.get(i);
        }
        return ans;
    }

}
