package com.example.leetcode;

/**
 * @author chunchen.huang
 * @description https://leetcode.cn/problems/maximum-swap/
 * 670. 最大交换
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 * @date 2024-01-22 19:32:56
 */
public class maximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
    }

    public static int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int maxIdx = arr.length-1;
        int p = -1, q=0;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] > arr[maxIdx]){
                maxIdx=i;
            }else if(arr[i] < arr[maxIdx]){
                p=i;
                q=maxIdx;
            }
        }
        if (p == -1){
            return num;
        }
        char temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
        return Integer.parseInt(new String(arr));
    }


}
