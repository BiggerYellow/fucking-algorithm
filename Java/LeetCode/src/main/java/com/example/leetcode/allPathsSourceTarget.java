package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/8/25 0:07
 * @description
 * 797. All Paths From Source to Target
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 *
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Example 3:
 *
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * Example 4:
 *
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * Example 5:
 *
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
public class allPathsSourceTarget {
    public static void main(String[] args) {
        int[][] graph = {{1,3},{2},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int end = graph.length-1;
        List<Integer> track = new ArrayList<>();
        track.add(0);
        dfs(graph, track, 0, end);
        return res;
    }

    public static void dfs(int[][] graph, List<Integer> track, int src, int end){
        if (src == end){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int gra:graph[src]){
            track.add(gra);
            dfs(graph, track, gra, end);
            track.remove(track.size()-1);
        }
    }
}
