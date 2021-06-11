package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/3/16 9:13
 * @description
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class generateMatrix {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(ints);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //定义四个顶点
        int left = 0,right = n-1,up = 0,down = n-1;
        //定义初始值
        int num=0;
        while (true){
            //首先从一行开始从左向右遍历 结束后将up++并与down进行判断
            for (int i=left;i<=right;i++){
                res[up][i] = ++num;
            }
            if (++up > down) break;
            //然后从最后一列开始从上向下遍历 结束后将right--并与left进行比较
            for (int i=up;i<=down;i++){
                res[i][right] = ++num;
            }
            if (--right < left) break;
            //然后从最后一行从右往左遍历 结束后将down--并与up比较
            for (int i=right;i>=left;i--){
                res[down][i] = ++num;
            }
            if (--down < up) break;
            //最后从第一列开始从下往上遍历 结束后将left++并与right比较
            for (int i=down;i>=up;i--){
                res[i][left] = ++num;
            }
            if (++left > right)break;
        }
        return res;
    }
}
