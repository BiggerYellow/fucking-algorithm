package com.example.leetcode;

import java.util.HashMap;

/**
 * @author huangchunchen
 * @date 2021/1/8 10:04
 * @description
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isValidSudoku {
    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".",".",".","."},
            {"6",".",".","1","9","5",".",".","."},
        {".","9","8",".",".",".",".","6","."},
            {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                    {"7",".",".",".","2",".",".",".","6"},
                        {".","6",".",".",".",".","2","8","."},
                            {".",".",".","4","1","9",".",".","5"},
                                {".",".",".",".","8",".",".","7","9"}};
        System.out.println(isValidSudoku(board));

    }

    //1.保证每行中都没有重复的数字
    //2.保证每列中都没有重复的数字
    //3.保证3*3的子数独没有重复的数字
    //通过三个hashMap key就是数字 value就是数字的个数 最后比较三个hashMap中的数字数大于1就是false
    //求子数独的方式：(i\3)*3 + j\3
    public static boolean isValidSudoku(String[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        //初始化数组
        for (int i=0;i<9;i++){
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        //遍历二维数组
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                String num = board[i][j];
                if (num != "."){
                    int n = Integer.valueOf(num).intValue();
                    //子数独位置
                    int box_index = (i/3)*3 + j/3;

                    //往每个map中插入 存在则加1
                    rows[i].put(n, rows[i].getOrDefault(n,0)+1);
                    columns[j].put(n, columns[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n,boxes[box_index].getOrDefault(n,0)+1);

                    //最后判断该数在三个map中是否有重复
                    if (rows[i].get(n) >1 || columns[j].get(n)>1 || boxes[box_index].get(n)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
