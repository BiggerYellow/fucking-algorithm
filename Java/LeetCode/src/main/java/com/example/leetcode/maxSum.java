package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/10/2 11:07
 * @description:
 * 6193. 沙漏的最大总和 显示英文描述
 * 通过的用户数30
 * 尝试过的用户数62
 * 用户总通过次数30
 * 用户总提交次数63
 * 题目难度Medium
 * 给你一个大小为 m x n 的整数矩阵 grid 。
 *
 * 按以下形式将矩阵的一部分定义为一个 沙漏 ：
 *
 *
 * 返回沙漏中元素的 最大 总和。
 *
 * 注意：沙漏无法旋转且必须整个包含在矩阵中。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
 * 输出：30
 * 解释：上图中的单元格表示元素总和最大的沙漏：6 + 2 + 1 + 2 + 9 + 2 + 8 = 30 。
 * 示例 2：
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：35
 * 解释：上图中的单元格表示元素总和最大的沙漏：1 + 2 + 3 + 5 + 7 + 8 + 9 = 35 。
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 3 <= m, n <= 150
 * 0 <= grid[i][j] <= 106
 */
public class maxSum {
    public static void main(String[] args) {
//        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        String s = "11";
        System.out.println(maxSum(grid));
    }

    public static int maxSum(int[][] grid) {
        int res = Integer.MIN_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n-2];
        for(int i =0;i<m;i++){
            int tempx = 0;
            for(int j=0;j<n;j++){
                if(j<2){
                    tempx += grid[i][j];
                }else if(j == 2){
                    tempx += grid[i][j];
                    cache[i][j-2] = tempx;
                }else{
                    tempx += grid[i][j];
                    tempx -= grid[i][j-3];
                    cache[i][j-2] = tempx;
                }
            }
        }

        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                res = Math.max(res, cache[i][j] + cache[i+2][j] + grid[i+1][j+1]);
            }
        }
        return res;
    }
}
