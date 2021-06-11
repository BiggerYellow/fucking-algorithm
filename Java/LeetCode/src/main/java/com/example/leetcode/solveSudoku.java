package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/1/14 11:22
 * @description
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solveSudoku {

    public static void main(String[] args) {

    }

    //第一个为列的位置i  第二个为当前的值  有值为true
    public static boolean[][] line = new boolean[9][9];
    //第一个为行的位置j  第二个为当前的值  有值为true
    public static boolean[][] column = new boolean[9][9];
    //第一个为九宫格的位置i/3  第二个为九宫格的位置j/3  第三个为当前的值  有值为true
    public static boolean[][][] block = new boolean[3][3][9];
    //当数据处理完不用再进行递归
    public static boolean vaild = false;
    //需要处理的位置
    public static List<int[]> nums = new ArrayList<>();


    public static void solveSudoku(char[][] board) {
        //初始化数组  遇到'.'就加入到nums  否则就设置line、column、block指定位置为true
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j] == '.'){
                    nums.add(new int[]{i, j});
                }else {
                    int num = board[i][j] - '0' - 1;
                    line[i][num] = column[j][num] = block[i/3][j/3][num] = true;
                }
            }
        }
        //递归执行
        dfs(board, 0);
    }

    public static void dfs(char[][] board, int lo){
        //当处理次数和要处理的数据相同时结束
        if (lo == nums.size()){
            vaild = true;
            return;
        }
        //获取要处理的数据
        int[] ints = nums.get(lo);
        int i=ints[0], j = ints[1];
        //遍历数字1到9
        for (int digit=0;digit<9 && !vaild;digit++){
            //当line、column和block位置都为false才需要处理
            if (!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                //设置line、column和block位置为true
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                //将值赋值到board数组中
                board[i][j] = (char) (digit + '0' + 1);
                //递归
                dfs(board, lo+1);
                //撤销选择
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false;
            }
        }
    }
}
