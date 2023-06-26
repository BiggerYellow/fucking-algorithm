package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunchne.huang
 * @description https://leetcode.cn/contest/biweekly-contest-92/problems/difference-between-ones-and-zeros-in-row-and-column/
 * @date 2022-11-26 22:55:37
 */
public class onesMinusZeros {

    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,0,1},{0,0,1}};
        System.out.println(onesMinusZeros(grid));
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        Map<Integer, Integer> row1 = new HashMap<>();
        Map<Integer, Integer> col1 = new HashMap<>();
        Map<Integer, Integer> row0 = new HashMap<>();
        Map<Integer, Integer> col0 = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    row1.put(i,row1.getOrDefault(i,0)+1);
                }else{
                    row0.put(i,row0.getOrDefault(i,0)+1);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[j][i] == 1){
                    col1.put(i,col1.getOrDefault(i,0)+1);
                }else{
                    col0.put(i,col0.getOrDefault(i,0)+1);
                }
            }
        }

        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = row1.getOrDefault(i, 0) + col1.getOrDefault(j, 0) - row0.getOrDefault(i, 0) - col0.getOrDefault(j, 0);
            }
        }
        return res;
    }
}
