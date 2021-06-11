package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/5/12 10:12
 * @description
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class totalNQueens {
    public static void main(String[] args) {
        int i = totalNQueens(4);
        System.out.println(i);
    }

//    public static List<List<String>> res = new ArrayList<>();
    public static int res = 0;

    public static int totalNQueens(int n) {
        //初始化棋盘
        List<StringBuilder> track = new ArrayList<>();
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<n;j++){
                sb.append('.');
            }
            track.add(sb);
        }
        dfs(track, 0);
        return res;
    }

    public static void dfs(List<StringBuilder> track, int row){
        if (track.size() == row){
            res++;
            return;
        }
        int length = track.get(row).length();
        for (int col=0;col<length;col++){
            if (!isValid(track, row, col)){
                continue;
            }
            track.get(row).setCharAt(col, 'Q');
            dfs(track, row+1);
            track.get(row).setCharAt(col, '.');
        }
    }

    public static boolean isValid(List<StringBuilder> track, int row, int col){
        //同一列是否有皇后
        for (int i=row;i>=0;i--){
            if (track.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        //左上方是否有皇后
        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        //右上方是否有皇后
        for (int i=row-1,j=col+1;i>=0 && j<track.size();i--,j++){
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }


}
