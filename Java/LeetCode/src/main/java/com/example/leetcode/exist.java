package com.example.leetcode;


/**
 * @author huangchunchen
 * @date 2021/10/28 10:26
 * @description
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],
 *               ["S","F","C","S"],
 *               ["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],
 *               ["S","F","C","S"],
 *               ["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],
 *               ["S","F","C","S"],
 *               ["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class exist {
    public static void main(String[] args) {

//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        char[][] board = {{'a','a'}};
//        String word = "aaa";
//        char[][] board = {{'C','A','A'},
//                          {'A','A','A'},
//                          {'B','C','D'}};
//
//        String word = "AAB";
//        char[][] board ={{'A','B','C','E'},
//                         {'S','F','C','S'},
//                         {'A','D','E','E'}};
//        String word ="SEE";
        char[][] board ={{'A','B','C','E'},
                         {'S','F','E','S'},
                         {'A','D','E','E'}};
        String word ="ABCEFSADEESE";

        System.out.println(exist(board, word));
    }

    static boolean[][] visited;
    static char[] chars;
    static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        chars = word.toCharArray();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                    boolean res = dfs(board, i,j,0);
                    if (res){
                        return res;
                    }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,int x, int y,int len){
        if (board[x][y] != chars[len]){
            return false;
        }else if (len == chars.length-1){
            return true;
        }
        visited[x][y] = true;
        boolean result = false;
        for (int[] direction:directions){
            int tempx = x+direction[0];
            int tempy = y+direction[1];
            if ((tempx>=0 && tempx<board.length) && (tempy>=0 && tempy<board[0].length)){
                if (!visited[tempx][tempy]){
                    boolean flag = dfs(board, tempx, tempy, len+1);
                    if (flag){
                        result= true;
                        break;
                    }
                }
            }
        }
        visited[x][y] = false;
        return result;
    }
}
