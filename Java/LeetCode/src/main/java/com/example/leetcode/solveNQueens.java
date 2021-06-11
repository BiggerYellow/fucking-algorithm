package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/5/11 10:41
 * @description
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 * 提示：
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solveNQueens {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }

    //回溯算法
    //1.先初始化棋盘
    //2.定义回溯框架  入参track 代表每行的放置位置   row代表当前哪行
    //      当处理的行数row 等于 track的数量 代表已经执行完了 添加到res结果中
    //      取出track中当前行的列数
    //      遍历列数 判断当前位置是否可以放置皇后 不可以继续遍历 可以直接设置
    //          再次调用回溯并把row+1
    //          撤销刚刚的选择

    //判断是否可以防止皇后逻辑：只需要判断当前列、当前位置左上方、当前位置的右上方是否可以防止即可
    public static List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        List<StringBuilder> track = new ArrayList<>();
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<n;j++){
                sb.append('.');
            }
            track.add(sb);
        }
        dfs(track,0);
        return res;
    }

    public static List<List<String>> res = new ArrayList<>();

    public static void dfs(List<StringBuilder> track, int row){
        //如果每一行都防止了皇后  记录结果
        if (track.size() == row){
            List<String> temp = new ArrayList<>();
            for (int i=0;i<track.size();i++){
                temp.add(track.get(i).toString());
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        int n = track.get(row).length();
        for (int col=0;col<n;col++){
            if (!isValid(track, row, col)){
                continue;
            }
            track.get(row).setCharAt(col,'Q');
            dfs(track, row+1);
            track.get(row).setCharAt(col,'.');
        }
    }

    //检验是否可以防止皇后
    public static boolean isValid(List<StringBuilder> track, int row, int col){
        int n = track.size();
        //检查列是否有冲突
        for (int i=0;i<n;i++){
            if (track.get(i).charAt(col) == 'Q')
                return false;
        }
        //检查右上方
        for (int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        //检查左上方
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (track.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }
}
