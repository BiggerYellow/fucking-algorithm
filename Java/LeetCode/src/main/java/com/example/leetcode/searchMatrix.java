package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/3/30 9:58
 * @description
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class searchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix,3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //行
        int n = matrix.length;
        //列
        int m = matrix[0].length;

        int low = -1, high = n-1;
        while (low<high){
            int mid = (high-low+1)/2 + low;
            if (matrix[mid][0] <= target){
                low = mid;
            }else {
                high = mid-1;
            }
        }

        int low1 = 0, high1=m-1;
        while (low1<=high1){
            int mid = (high1-low1)/2 + low;
            if (matrix[low][mid] == target){
                return true;
            }else if (matrix[low][mid] > target){
                high1 = mid-1;
            }else {
                low1 = mid+1;
            }
        }
        return false;
    }


}
