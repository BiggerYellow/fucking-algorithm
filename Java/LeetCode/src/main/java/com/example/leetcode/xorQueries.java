package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/5/12 9:09
 * @description
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 *
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class xorQueries {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,3,4,8};
        int[] arr = new int[]{4,8,2,10};
//        int[][] queries = new int[][]{{0,1},{1,2},{0,3},{3,3}};
        int[][] queries = new int[][]{{2,3},{1,3},{0,0},{0,3}};
        int[] ints = xorQueries(arr, queries);
        System.out.println(ints);
    }

    //动态规划
    //dp[i] 代表arr从0到i的异或结果
    //转移方程：dp[i] = dp[i-1] ^ arr[i]  i>=1
    //计算结果：当从0开始时直接取dp[queries[i][1]]
    //          当从非0开始取 dp[queries[i][0]-1] ^ dp[queries[i][1]]
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i=1;i<n;i++){
            dp[i] = dp[i-1]^arr[i];
        }

        int[] res = new int[queries.length];
        for (int i=0;i<queries.length;i++){
            if (queries[i][0] == 0){
                res[i] = dp[queries[i][1]];
            }else {
                res[i] = dp[queries[i][0]-1] ^ dp[queries[i][1]];
            }
        }
        return res;
    }
}
