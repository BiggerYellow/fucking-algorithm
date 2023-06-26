package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :huangchunchen
 * @date :Created in 2022/11/9 9:16
 * @description:
 */
public class orderOfLargestPlusSign {
    public static void main(String[] args) {
        int[][] mines = {{4, 2}};
        System.out.println(orderOfLargestPlusSign(5, mines));

    }

    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] cache = new int[n][n];
        for(int[] mine:mines){
            cache[mine[0]][mine[1]] = -1;
        }

        int res = 0;
        int[][] directions = {{1,0}, {-1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(cache[i][j] != -1){
                    queue.offer(new int[]{i, j});
                    int count = 1;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for(int k=0;k<size;k++){
                            for(int[] direction:directions){
                                int[] temp = queue.poll();
                                int tempx = direction[0]+temp[0];
                                int tempy = direction[1]+temp[1];
                                if(tempx < 0 ||tempx >= n || tempy < 0 || tempy >=n || cache[tempx][tempy] == -1){
                                    queue.clear();
                                    break;
                                }
                                queue.offer(new int[]{tempx, tempy});
                            }
                        }
                        count++;
                        if(size != 1){
                            res = Math.max(count, res);
                        }
                    }
                }
            }
        }
        return res;
    }
}
