package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/8/2 11:26
 * @description
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class networkDelayTime {
    public static void main(String[] args) {
//        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//        int[][] times = {{1,2,1}};
        int[][] times = {{1,2,1},{2,1,3}};
        System.out.println(networkDelayTime(times, 2,2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<String, Integer> time = new HashMap<>();
        Map<Integer, List<Integer>> next = new HashMap<>();
        for (int[] temp:times){
            time.put(temp[0]+"_"+temp[1], temp[2]);
            List<Integer> list = next.getOrDefault(temp[0], new ArrayList<>());
            list.add(temp[1]);
            next.put(temp[0], list);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        if (!next.keySet().contains(k)){
            return -1;
        }
        int res=0;
        int count = 0;
        queue.offer(k);
        while (!queue.isEmpty()){
            for (int i=0;i<queue.size();i++){
                Integer temp = queue.poll();
                visited.add(temp);
                List<Integer> list = next.get(temp);
                if (Objects.nonNull(list)){
                    for (Integer num:list){
                        if (!visited.contains(num)){
                            queue.offer(num);
                            count+=time.get(temp+"_"+num);
                            res = Math.max(count, res);
                            if (!next.keySet().contains(num)){
                                count-=time.get(temp+"_"+num);
                            }
                        }
                    }
                }
            }
        }
        if (visited.size() != n){
            return -1;
        }
        return res;
    }
}
