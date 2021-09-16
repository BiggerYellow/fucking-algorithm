package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/9/11 15:02
 * @description
 * 1. 无人机方阵
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。 无人机方阵通过两种操作进行颜色图案变换：
 *
 * 调整无人机的位置布局
 * 切换无人机展示的灯光颜色
 * 给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，由于无人机切换灯光颜色的耗能很大，请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。
 *
 * 注意： 调整无人机的位置布局时无人机的位置可以随意变动。
 *
 * 示例 1：
 *
 * 输入：source = [[1,3],[5,4]], target = [[3,1],[6,5]]
 *
 * 输出：1
 *
 * 解释：
 * 最佳方案为
 * 将 [0,1] 处的无人机移动至 [0,0] 处；
 * 将 [0,0] 处的无人机移动至 [0,1] 处；
 * 将 [1,0] 处的无人机移动至 [1,1] 处；
 * 将 [1,1] 处的无人机移动至 [1,0] 处，其灯光颜色切换为颜色编号为 6 的灯光；
 * 因此从source 到 target 所需要的最少灯光切换次数为 1。
 * 8819ccdd664e91c78cde3bba3c701986.gif
 *
 * 示例 2：
 *
 * 输入：source = [[1,2,3],[3,4,5]], target = [[1,3,5],[2,3,4]]
 *
 * 输出：0
 * 解释：
 * 仅需调整无人机的位置布局，便可完成图案切换。因此不需要无人机切换颜色
 *
 * 提示：
 * n == source.length == target.length
 * m == source[i].length == target[i].length
 * 1 <= n, m <=100
 * 1 <= source[i][j], target[i][j] <=10^4
 */
public class minimumSwitchingTimes {
    public static void main(String[] args) {
        int[][] source = {{1,3},{5,4}};
        int[][] target = {{3,1},{6,5}};
        System.out.println(minimumSwitchingTimes(source, target));
    }

    public static int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i=0;i<source.length;i++){
            for (int j=0;j<source[i].length;j++){
                cache.put(source[i][j], cache.getOrDefault(source[i][j], 0)+1);
            }
        }
        int res=0;
        for (int i=0;i<target.length;i++){
            for (int j=0;j<target[i].length;j++){
                if (!cache.keySet().contains(target[i][j])){
                    res++;
                }else {
                    Integer temp = cache.get(target[i][j]);
                    if (temp == 0){
                        res++;
                    }else {
                        cache.put(target[i][j], cache.get(target[i][j])-1);
                    }
                }
            }
        }
        return res;
    }
}
