package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/28 9:15
 * @description
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate1(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }

    //借用中间数组
    //规律：nums[i][j] = nums[j][n-i-1]
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                temp[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }

    //水平翻转代替旋转
    //1.先水平翻转  nums[i][j] = nums[n-i-1][j]
    //2.然后主对角线翻转 nums[i][j] = nums[j][i]
    public static void rotate1(int[][] matrix){
        int n = matrix.length;
        for (int i=0;i<n/2;i++){
            for (int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
