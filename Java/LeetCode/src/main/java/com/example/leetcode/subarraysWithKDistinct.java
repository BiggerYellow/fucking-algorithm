package com.example.leetcode;

import java.util.HashMap;

/**
 * @author huangchunchen
 * @date 2021/2/9 8:55
 * @description
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class subarraysWithKDistinct {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,1,2,3};
//        int[] A = new int[]{1,2};
//        int[] A = new int[]{1,2,1,3,4};
//        int[] A = new int[]{2,1,2,1,2};
        System.out.println(subarraysWithKDistinct2(A,2));

    }

    public static int subarraysWithKDistinct(int[] A, int K) {
        int length = A.length;
        int res = 0;
        int right=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int left =0;left<length-K+1;left++){
            right = left;
            map.clear();
            while (right<=length-1){
                map.put(A[right], map.getOrDefault(A[right],0)+1);
                if (map.keySet().size() == K){
                    res++;
                    right++;
                }else if (map.keySet().size() < K){
                    right++;

                }else {
                    map.clear();
                    left++;
                    right = left;
                }
            }
        }
        return res;
    }


    public static int subarraysWithKDistinct1(int[] A, int K) {
        int length = A.length;
        int res = 0;
        int right=0;
        int left=0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (left < length-K+1 && right<=length-1){
            map.put(A[right], map.getOrDefault(A[right],0)+1);
            if (map.keySet().size() == K){
                res++;
                right++;
                if (right==length){
                    map.clear();
                    left++;
                    right = left;
                }
            }else if (map.keySet().size() < K){
                right++;
            }else {
                map.clear();
                left++;
                right = left;
            }
        }
        return res;
    }

    //双指针法
    //转换为最多存在K个不同整数的子区间的个数 减去 最多存在K-1个不同整数子区间的个数
    public static int subarraysWithKDistinct2(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K-1);
    }

    //获取最多存在K个不同整数的子区间的个数
    public static int atMostKDistinct(int[] A, int K){
        int length = A.length;
        int[] temp = new int[A.length+1];
        //左右指针
        int left = 0;
        int right = 0;
        int count=0;
        int res=0;
        //右指针要小于数组长度
        while (right < length){
            //当目标数组右指针的值在临时数组中的值为0时表明满足条件 count++
            if (temp[A[right]] == 0){
                count++;
            }
            //将临时数组中对应目标数组右指针的值加1
            temp[A[right]]++;
            //右指针移动一格
            right++;
            //当count大于K时  左指针操作
            while (count > K){
                //将临时数组中目标数组对应左指针的值的位置减一
                temp[A[left]]--;
                //临时数组的值等于0时 count--
                if (temp[A[left]] == 0){
                    count--;
                }
                //左指针前进一位
                left++;
            }
            //求区间大小
            res+= right -left;
        }
        return res;
    }

}
