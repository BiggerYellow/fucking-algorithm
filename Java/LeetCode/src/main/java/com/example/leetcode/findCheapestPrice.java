package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * @author huangchunchen
 * @date 2021/8/24 14:03
 * @description
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 */
public class findCheapestPrice {
    public static void main(String[] args) {
//        5
//                [[1,2,10],[2,0,7],[1,3,8],[4,0,10],[3,4,2],[4,2,10],[0,3,3],[3,1,6],[2,4,5]]
//        0
//        4
//        1

        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
//        int[][] flights = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
//        int[][] flights = {{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};


//        System.out.println(findCheapestPrice(3, flights, 0 ,2,0));
//        System.out.println(findCheapestPrice(3, flights, 0 ,2,0));
    }

    public static int res= Integer.MAX_VALUE;
    public static int k1;
    public static int dst1;
    public static List<String> cache = new ArrayList<>();

//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        k1 = k;
//        dst1 = dst;
//        Map<Integer, Integer>[] flightMaps = new Map[n];
//        for (int i=0;i<n;i++){
//            flightMaps[i] =  new HashMap<>();
//        }
//
//        for (int[] flight:flights){
//            flightMaps[flight[0]].put(flight[1], flight[2]);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(src);
//        int count=0;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i=0;i<size;i++){
//                Integer poll = queue.poll();
//                    for (Map.Entry<Integer, Integer> map:flightMaps[poll].entrySet()){
//                        if (map.getValue() == dst){
//                            res
//                        }
//                    }
//                }
//            }
//
//        return Objects.equals(res, Integer.MAX_VALUE)? -1:res;
//    }


}
