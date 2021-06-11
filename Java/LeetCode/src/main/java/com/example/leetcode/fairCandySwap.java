package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author huangchunchen
 * @date 2021/2/1 9:29
 * @description
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 *
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class fairCandySwap {
    public static void main(String[] args) {

        int[] A = new int[]{35,17,4,24,10};
        int[] B = new int[]{63,21};
        int[] res = fairCandySwap1(A, B);
        System.out.println(res);

    }

    //公式为 sumA-A[i]+B[j] == sumB-B[j]+A[i]
    //双层遍历直到找到等于上述公式的值
    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        if (sumA == sumB){
            res[0] = res[1] =0;
        }

        for (int i=0;i<A.length;i++){
            for (int j=0;j<B.length;j++){
                if (sumA - A[i] + B[j] == sumB - B[j] + A[i]){
                    res[0] = A[i];
                    res[1] = B[j];
                }
            }
        }

        return res;
    }

    //由sumA-A[i]+B[j] = sumB-B[j]+A[i]转换得
    //A[i] = B[j] + (sumA-sumB)/2
    //B[i] = A[j] + (sumB-sumA)/2
    //借用集合判断即可
    public static int[] fairCandySwap1(int[] A, int[] B){
        int[] res = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        List<Integer> listA = new ArrayList<>();
        for (int a: A){
            listA.add(a);
        }
        int temp = (sumA-sumB)/2;
        for (int b:B){
            if (listA.contains(temp + b)){
                res[0] = b+temp;
                res[1] = b;
                break;
            }
        }
        return res;
    }
}
