package com.example.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/8/18 9:21
 * @description
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：3
 * 示例 3：
 *
 * 输入：n = 10101
 * 输出：183236316
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class checkRecord {
    public static void main(String[] args) {
        System.out.println(checkRecord2(10101));
    }

    static int MOD = 1000000007;


    public static int checkRecord(int n) {
        return dfs(0,n,0,0);
    }

    //day记录天数 每过一天day++
    //absent记录缺席数  late记录连续的迟到天数
    //每天就只有三种情况:要么迟到、要么缺席、要么到场
    //1.到场 - day++, absent不变, late置为0
    //2.缺席 - day++, absent置为1, late置为0    前提条件absent小于1,因为不能超过2天缺席
    //3.迟到 - day++, absent不变, late++        前提条件是late小于3,因为不能连续3天迟到
    public static int dfs(int day, int n, int absent, int late){
        if (day >=n){
            return 1;
        }
        int res=0;
        res = (res+dfs(day+1, n, absent, 0))%MOD;
        if (absent<1){
            res = (res+dfs(day+1, n, 1,0))%MOD;
        }
        if (late<2){
            res = (res+dfs(day+1, n, absent, late+1))%MOD;
        }
        return res;
    }


    public static int checkRecord1(int n) {
        int[][][] cache = new int[n][2][3];
        return dfs1(0,n,0,0, cache);
    }

    //day记录天数 每过一天day++
    //absent记录缺席数  late记录连续的迟到天数
    //每天就只有三种情况:要么迟到、要么缺席、要么到场
    //1.到场 - day++, absent不变, late置为0
    //2.缺席 - day++, absent置为1, late置为0    前提条件absent小于1,因为不能超过2天缺席
    //3.迟到 - day++, absent不变, late++        前提条件是late小于3,因为不能连续3天迟到
    public static int dfs1(int day, int n, int absent, int late, int[][][] cache){
        if (day >=n){
            return 1;
        }
        if (cache[day][absent][late] != 0){
            return cache[day][absent][late];
        }
        int res=0;
        res = (res+dfs1(day+1, n, absent, 0, cache))%MOD;
        if (absent<1){
            res = (res+dfs1(day+1, n, 1,0,cache))%MOD;
        }
        if (late<2){
            res = (res+dfs1(day+1, n, absent, late+1,cache))%MOD;
        }
        cache[day][absent][late]=res;
        return res;
    }


    //dp[i][j][k] 代表前i天中缺席j次、连续迟到k次的可获得出勤奖励的次数
    //转移方程: 由动态方程可知有三个状态 其中i最多为n,j最多为2,k最多为3,所以我们需要三层循环,每次都分三种情况, 最后将三种情况都累加起来即可
    //         当出勤记录为'P'时: dp[i][j][0] += dp[i-1][j][k]  0<=j<=1, 0<=k<=2    --当天出勤为到场时,那么今天就需要将迟到late置为0,absent不变 其值为 累加前一天day-1且absent从0到1且late从0到2的所有值
    //         当出勤记录为'A'时: dp[i][1][0] += dp[i-1][0][k]  0<=k<=2             --当天出勤为缺勤时,那么今天就要将late置为0,absent置为1 其值为 累加前一天day-1且abent为0且late从0到2的所有值
    //         当出勤记录为'L'时: dp[i][j][k] += dp[i-1][j][k-1] 0<=j<=1,1<=k<=2    --当天出勤为迟到时,那么今天的late和absent都不变,其值为 累加前一天day-1且absent从0到1且late从0到1的所有值
    //初始化: dp[0][0][0]=1
    //结果: 累加所有dp[n][0..1][0..2]
    public static int checkRecord2(int n) {
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0]=1;
        for (int i=1;i<=n;i++){
            //P
            for (int j=0;j<=1;j++){
                for (int k=0;k<=2;k++){
                    dp[i][j][0] = (dp[i][j][0]+dp[i-1][j][k])%MOD;
                }
            }
            //A
            for (int k=0;k<=2;k++){
                dp[i][1][0] = (dp[i][1][0]+dp[i-1][0][k])%MOD;
            }
            //L
            for (int j=0;j<=1;j++){
                for (int k=1;k<=2;k++){
                    dp[i][j][k] = (dp[i][j][k]+dp[i-1][j][k-1])%MOD;
                }
            }
        }

        int res=0;
        for (int j=0;j<=1;j++){
            for (int k=0;k<=2;k++){
                res = (res + dp[n][j][k])%MOD;
            }
        }
        return res;
    }


}
