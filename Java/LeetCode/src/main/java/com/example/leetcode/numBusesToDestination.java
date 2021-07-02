package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/6/28 9:06
 * @description
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 *  1,2,7
 *  3,6,7
 *
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *      7,12
 *      4,5,15
 *      6
 *      15,19
 *      9,12,13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numBusesToDestination {
    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        System.out.println(numBusesToDestination(routes, 1, 6));
    }

    //BFS
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target){
            return 0;
        }

        //map存放每个站点走过的公交车  即每个站点的邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<routes.length;i++){
            for (int sta:routes[i]){
                List<Integer> list = map.getOrDefault(sta, new ArrayList<>());
                list.add(i);
                map.put(sta, list);
            }
        }

        //队列存放需要遍历的车站
        //先根据车站找到左右的公交车,查看公交车是否遍历过
        //再看该公交车走过的站点是否包含target站点,包含直接返回,不包含直接将该站点入栈
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visit = new ArrayList<>();
        queue.offer(source);
        int res=0;
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i=0;i<size;i++){
                List<Integer> buss = map.get(queue.poll());
                for (Integer bus:buss){
                    if (visit.contains(bus)){
                        continue;
                    }
                    visit.add(bus);
                    for (Integer r:routes[bus]){
                        if (r == target){
                            return res;
                        }
                        queue.offer(r);
                    }
                }
            }
        }
        return -1;
    }
}
