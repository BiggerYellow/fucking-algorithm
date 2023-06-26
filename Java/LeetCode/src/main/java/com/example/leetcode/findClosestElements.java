package com.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/8/25 19:44
 * @description:
 * 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr 按 升序 排列
 * -104 <= arr[i], x <= 104
 */
public class findClosestElements {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,2,3,6,7,8,9};
//        int[] arr = {1,3};
        System.out.println(findClosestElements(arr, 9, 4));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length-1;
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] == x){
                right = mid;
                break;
            }else if(arr[mid] < x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        List<Integer> res = new ArrayList<>();
        int start = right;
        int end = right+1;
        while (res.size() != k){
            if (end > len){
                res.add(arr[start--]);
            }else if (start<0){
                res.add(arr[end++]);
            }else {
                int diff1 = Math.abs(arr[start] - x);
                int diff2 = Math.abs(arr[end] - x);
                if (diff1 == diff2 || diff1 < diff2){
                    res.add(arr[start--]);
                }else {
                    res.add(arr[end++]);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
