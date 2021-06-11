package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/3/2 9:19
 * @description
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 0, 4, 3));
    }

    public static int[][] sum;
//    //将二维数组转换为每一个行上的值都是前缀和的新二维数组
//    public NumMatrix(int[][] matrix) {
//        //当二维数组列数大于0时才生效
//        if (matrix.length > 0){
//            //避免讨论第一列的情况 将数组列长+1
//            sum = new int[matrix.length][matrix[0].length+1];
//            for (int i=0;i<matrix.length;i++){
//                for (int j=0;j<matrix[i].length;j++){
//                    //每一行的数据都是前缀和
//                    sum[i][j+1] = matrix[i][j] + sum[i][j];
//                }
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int res=0;
//        //直接遍历行从row1到row2的前缀和  列从col1到col2+1
//        for (int i=row1;i<=row2;i++){
//            res += (sum[i][col2+1] - sum[i][col1]);
//        }
//        return res;


    public NumMatrix(int[][] matrix){
        if (matrix.length > 0){
            sum = new int[matrix.length+1][matrix[0].length+1];
            for (int i=0;i<matrix.length;i++){
                for (int j=0;j<matrix[i].length;j++){
                    sum[i+1][j+1] = sum[i][j+1]+sum[i+1][j]-sum[i][j]+matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[col1][row1];
    }
}
