package com.example.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/30 23:30
 * @description:
 * 6053. 统计网格图中没有被保卫的格子数 显示英文描述
 * 通过的用户数465
 * 尝试过的用户数664
 * 用户总通过次数471
 * 用户总提交次数822
 * 题目难度Medium
 * 给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i] = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
 *
 * 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
 *
 * 请你返回空格子中，有多少个格子是 没被保卫 的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * 输出：7
 * 解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
 * 总共有 7 个没有被保卫的格子，所以我们返回 7 。
 * 示例 2：
 *
 *
 *
 * 输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * 输出：4
 * 解释：上图中，没有被保卫的格子用绿色表示。
 * 总共有 4 个没有被保卫的格子，所以我们返回 4 。
 *
 *
 * 提示：
 *
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * 1 <= guards.length, walls.length <= 5 * 104
 * 2 <= guards.length + walls.length <= m * n
 * guards[i].length == walls[j].length == 2
 * 0 <= rowi, rowj < m
 * 0 <= coli, colj < n
 * guards 和 walls 中所有位置 互不相同 。
 */
public class countUnguarded {
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}}, walls = {{0,1},{2,2},{1,4}};
        System.out.println(countUnguarded(m,n,guards,walls));
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] table = new char[m][n];
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] guard:guards){
            table[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall:walls){
            table[wall[0]][wall[1]] = 'W';
        }
        int count = guards.length + walls.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int[] direction:directions){
            for (int[] guard:guards){
                queue.offer(guard);
                while (!queue.isEmpty()){
                    int[] poll = queue.poll();
                    int tempx = poll[0] + direction[0];
                    int tempy = poll[1] + direction[1];
                    if (tempx < 0 || tempx > m-1 || tempy < 0 || tempy > n-1 || table[tempx][tempy] == 'W'){
                        break;
                    }
                    if (table[tempx][tempy] != 'G'){
                        count++;
                    }
                    table[tempx][tempy] = 'G';
                    queue.offer(new int[]{tempx, tempy});
                }
            }
        }
//        int res = 0;
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//                if (table[i][j] != 'G' && table[i][j] != 'W'){
//                    res++;
//                }
//            }
//        }
//        return res;
        return m*n - count;
    }
}
