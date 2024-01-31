package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/9/13 9:15
 * @description
 * 447. 回旋镖的数量
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 *
 * 示例 1：
 *
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：points = [[1,1]]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 */
public class numberOfBoomerangs {
    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int res=0;
        for (int[] point:points){
            Map<Integer, Integer> cache = new HashMap<>();
            for (int[] temp:points){
                int dis = (point[0]-temp[0])*(point[0]-temp[0]) + (point[1]-temp[1])*(point[1]-temp[1]);
                cache.put(dis, cache.getOrDefault(dis, 0)+1);
            }
            for (Map.Entry<Integer, Integer> entry:cache.entrySet()){
                int m = entry.getValue();
                res+=m*(m-1);
            }
        }
        return res;
    }
}
