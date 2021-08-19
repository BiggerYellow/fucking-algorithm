package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/8/15 16:58
 * @description
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 *
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * 示例 2：
 *
 *
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findPaths {
    public static void main(String[] args) {

    }

    static int MOD = (int)1e9+7;
    static int[][] dirs = new int[][]{{1,0},{-1,0}, {0,1}, {0,-1}};
    static int[][][] cache;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[maxMove+1][m][n];
        for (int i=0;i<=maxMove;i++){
            for (int j=0;j<m;j++){
                for (int k=0;k<n;k++){
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(startRow, startColumn, maxMove, m, n);
    }

    public static int dfs(int x, int y, int k, int m, int n){
        if (x<0||x>=m||y<0||y>=n){
            return 1;
        }
        if (k==0){
            return 0;
        }
        if (cache[k][x][y] != -1){
            return cache[k][x][y];
        }
        int res=0;
        for (int[] dir:dirs){
            int tempx = x+dir[0];
            int tempy = y+dir[1];
            res += dfs(tempx, tempy, k-1, m, n);
            res %= MOD;
        }
        cache[k][x][y] = res;
        return res;
    }
}
