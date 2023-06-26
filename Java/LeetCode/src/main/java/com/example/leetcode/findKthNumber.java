package com.example.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/5/18 1:06
 * @description:
 * 668. 乘法表中第k小的数
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 *
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 *
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 *
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 注意：
 *
 * m 和 n 的范围在 [1, 30000] 之间。
 * k 的范围在 [1, m * n] 之间。
 */
public class findKthNumber {
    public static void main(String[] args) {
//        System.out.println(findKthNumber(3,3,5));
        String s = "123";
        System.out.println(s.indexOf('4'));
    }

    public static int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m*n;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            // 乘法表中小于等于x的元素个数
            int count = 0;
            for(int i=1;i<=m && i<=mid;i++){
                count+=Math.min(n,mid/i);
            }
            if(count >= k){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }
}
