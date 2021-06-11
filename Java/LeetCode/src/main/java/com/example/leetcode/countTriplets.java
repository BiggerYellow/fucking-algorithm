package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/5/18 9:23
 * @description
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [2,3,1,6,7]
 * 输出：4     [0,1,2,3,4,5]
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * 示例 2：
 *
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * 示例 3：
 *
 * 输入：arr = [2,3]
 * 输出：0
 * 示例 4：
 *
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * 示例 5：
 *
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countTriplets {
    public static void main(String[] args) {

    }

    //三重循环
    //因为 a = Si^Sj  b= Sj^Sk+1 且 a==b
    //所以 Si == Sk+1
    public static int countTriplets(int[] arr) {
        int[] dp = new int[arr.length+1];
        for (int i=0;i<arr.length;i++){
            dp[i+1] = dp[i] ^ arr[i];
        }
        int res =0;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                for (int k=j;k<arr.length;k++){
                    if (dp[i] == dp[k+1]){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    //二重循环
    //由上的 Si == Sk+1 时，[i+1,k]内的任意 j 都是符合要求的，对应的三元组的个数为 k-i
    public static int countTriplets1(int[] arr){
        int[] dp = new int[arr.length+1];
        for (int i=0;i<arr.length;i++){
            dp[i+1] = dp[i] ^ arr[i];
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
            for (int k=i+1;k<arr.length;k++){
                if (dp[i] == dp[k+1]){
                    res += k-i;
                }
            }
        }
        return res;
    }

    //一重循环 借用map
    public static int countTriplets2(int[] arr){
        int[] dp = new int[arr.length+1];
        for (int i=0;i<arr.length;i++){
            dp[i+1] = dp[i] ^ arr[i];
        }
        int res=0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int k=0;k<=arr.length;k++){
            List<Integer> list = map.getOrDefault(dp[k], new ArrayList<>());
            for (Integer index:list){
                int i=index+1;
                res +=k-i;
            }
            list.add(k);
            map.put(dp[k], list);
        }
        return res;
    }
}
