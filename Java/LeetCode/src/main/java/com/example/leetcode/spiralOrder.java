package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/3/15 9:02
 * @description
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        //定义四个边界 上下左右
        int up = 0, down = n-1, left = 0, right = m-1;
        while (true){
            //首先按照从左到右遍历 结束则将up++ 如果up > down 则表明遍历结束
            for (int i=left;i<=right;i++){
                res.add(matrix[up][i]);
            }
            if (++up > down) break;
            //然后按照从上到下遍历 结束则将right-- 如果 right < left 则表明遍历结束
            for (int i=up;i<=down;i++){
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            //然后按照从右到左遍历 结束则将down-- 如果 down < up 则表明遍历结束
            for (int i=right;i>=left;i--){
                res.add(matrix[down][i]);
            }
            if (--down < up) break;
            //然后按照从下到上遍历 结束则将left++ 如果 left > right 则表明遍历结束
            for (int i=down;i>=up;i--){
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }

}
