package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/6/21 9:39
 * @description
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findMaxForm {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, 5,3));
    }

    //动态规划
    //dp[i][j][k] 在区间[0,i]中存放j个0和i个1的最大子集个数
    //动态方程: 两种情况 不存放0和1 存放0和1  取两种情况的最大值
    //          1.不存在直接上一个的值  dp[i-1][j][k]
    //          2.存放则取上一个值中减去0的数量和减去1的数量 dp[i-1][j-num0][k-num1]+1
    //          综上:  dp[i][j][k]=max(dp[i-1][j][k], dp[i-1][j-num0][k-num1])
    //初始化: dp[0][0][0] =0
    //结果: dp[strs.length][m][n]
    public static int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length+1][m+1][n+1];
        for (int i=1;i<=length;i++){
            int count0 = 0, count1=0;
            for (char c:strs[i-1].toCharArray()){
                if (c=='0'){
                    count0++;
                }else {
                    count1++;
                }
            }

            for (int j=0;j<=m;j++){
                for (int k=0;k<=n;k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j>=count0&&k>=count1)
                    dp[i][j][k] = Math.max(dp[i-1][j][k], 1+dp[i-1][j-count0][k-count1]);
                }
            }
        }
        return dp[length][m][n];
    }

    //空间优化
    //滚动数组 现在dp[j][k]代表的是上一个的状态，所以需要倒序遍历
    public static int findMaxForm1(String[] strs, int m, int n) {
        int length=strs.length;
        int[][] dp =new int[m+1][n+1];
        for (String str:strs){
            int count0=0,count1=0;
            for (char c:str.toCharArray()){
                if (c=='0'){
                    count0++;
                }else {
                    count1++;
                }
            }
            for (int j=m;j>=count0;j--){
                for (int k=n;k>=count1;k--){
                    dp[j][k] = Math.max(dp[j][k], 1+dp[j-count0][k-count1]);
                }
            }
        }
        return dp[m][n];
    }

}
