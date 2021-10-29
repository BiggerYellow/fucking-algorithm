package com.example.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author huangchunchen
 * @date 2021/10/9 9:48
 * @description
 * 352. 将数据流变为多个不相交区间
 *  给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 实现 SummaryRanges 类：
 *
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 *
 *
 * 示例：
 *
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 *
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 *
 *
 * 提示：
 *
 * 0 <= val <= 104
 * 最多调用 addNum 和 getIntervals 方法 3 * 104 次
 */
public class SummaryRanges {
    public static void main(String[] args) {

    }

    TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);

        if (interval0 != null && interval0.getKey()<=val && interval0.getValue() >= val){
            return;
        }else {
            boolean leftSide = interval0 != null && interval0.getValue()+1 ==val;
            boolean rightSide = interval1 != null && interval1.getKey()-1 == val;
            if (leftSide && rightSide){
                int left = interval0.getKey(), right = interval1.getValue();
                intervals.remove(interval0.getKey());
                intervals.remove(interval1.getKey());
                intervals.put(left, right);
            }else if (leftSide){
                intervals.put(interval0.getKey(), interval0.getValue()+1);
            }else if (rightSide){
                int right = interval1.getValue();
                intervals.remove(interval1.getKey());
                intervals.put(val, right);
            }else{
                intervals.put(val, val);
            }
        }
    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] res = new int[size][2];
        int index=0;
        for (Map.Entry<Integer, Integer> entry:intervals.entrySet()){
            res[index][0] = entry.getKey();
            res[index][1] = entry.getValue();
            index++;
        }
        return res;
    }
}
