package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/9/12 11:29
 * @description
 * 用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
 *
 * 如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
 *
 * 计算并返回 rectangles 中有多少对 可互换 矩形。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rectangles = [[4,8],[3,6],[10,20],[15,30]]
 * 输出：6
 * 解释：下面按下标（从 0 开始）列出可互换矩形的配对情况：
 * - 矩形 0 和矩形 1 ：4/8 == 3/6
 * - 矩形 0 和矩形 2 ：4/8 == 10/20
 * - 矩形 0 和矩形 3 ：4/8 == 15/30
 * - 矩形 1 和矩形 2 ：3/6 == 10/20
 * - 矩形 1 和矩形 3 ：3/6 == 15/30
 * - 矩形 2 和矩形 3 ：10/20 == 15/30
 * 示例 2：
 *
 * 输入：rectangles = [[4,5],[7,8]]
 * 输出：0
 * 解释：不存在成对的可互换矩形。
 *
 *
 * 提示：
 *
 * n == rectangles.length
 * 1 <= n <= 105
 * rectangles[i].length == 2
 * 1 <= widthi, heighti <= 105
 */
public class interchangeableRectangles {
    public static void main(String[] args) {
        int[][] rectangles = {{4,8},{3,6},{10,20},{15,30}};
        System.out.println(interchangeableRectangles(rectangles));
    }

    public static int res=0;

    public static long interchangeableRectangles(int[][] rectangles) {
        double[] cache = new double[rectangles.length];
        for (int i=0;i<rectangles.length;i++){
            for (int j=0;j<2;j++){
                cache[i] = (double)rectangles[i][0]/rectangles[i][1];
            }
        }

        int[] dp = new int[cache.length];

        dp[0]=0;
        for (int i=1;i<dp.length;i++){
            int temp = 0;
            for (int j=0;j<i;j++){
                if (cache[j]==cache[i]){
                    temp++;
                }
            }
            dp[i] = dp[i-1]+temp;
        }
        return dp[cache.length-1];
//
//        List<Double> track = new ArrayList<>();
//        dfs(cache, track, 0);
//        return res;
    }

    public static void dfs(double[] cache, List<Double> track, int index){
        if (track.size() == 2 && track.get(0).equals(track.get(1))){
            res++;
            return;
        }
        for (int i=index;i<cache.length;i++){
            if (track.size()<2){
                track.add(cache[i]);
                dfs(cache, track, index+=1);
                track.remove(track.size()-1);
            }
        }
    }
}
