package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/6/28 10:22
 * @description
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 *
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 *
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
 * 输出："7772"
 * 解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要求的数字，但 "7772" 是较大的数字。
 *  数字     成本
 *   1  ->   4
 *   2  ->   3
 *   3  ->   2
 *   4  ->   5
 *   5  ->   6
 *   6  ->   7
 *   7  ->   2
 *   8  ->   5
 *   9  ->   5
 * 示例 2：
 *
 * 输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
 * 输出："85"
 * 解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
 * 示例 3：
 *
 * 输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
 * 输出："0"
 * 解释：总成本是 target 的条件下，无法生成任何整数。
 * 示例 4：
 *
 * 输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
 * 输出："32211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class largestNumber1 {
    public static void main(String[] args) {

    }
    //dp[j] 使用总成本为j的最大价值
    //动态方程:  j<cost[i]  dp[j] = [j]
    //          j>=cost[i] dp[j] = max(dp[j], dp[j-cost[i]+1)
    //再根据贪心获取最大值
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;
        for (int i=1;i<=9;i++){
            int temp = cost[i-1];
            for (int j=temp;j<=target;j++){
                dp[j] = Math.max(dp[j], dp[j-temp]+1);
            }
        }
        if (dp[target] < 0) return "0";
        String res="";
        for (int i=9,j=target;i>=1;i--){
            int temp =cost[i-1];
            while (j >=temp && dp[j]==dp[j-temp]+1){
                res+=String.valueOf(i);
                j-=temp;
            }
        }
        return res;
    }
}
