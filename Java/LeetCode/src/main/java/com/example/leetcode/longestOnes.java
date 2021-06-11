package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/2/19 9:04
 * @description
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestOnes {
    public static void main(String[] args) {
        int[] A = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(A, 2));
    }

    public static int longestOnes(int[] A, int K) {
        int res=0;
        int count=0;
        int left=0;
        int right=0;
        while (right<A.length){
            //当A[right]为0时，将count++
            if (A[right] == 0){
                count++;
            }
            //当count > K时，表明需要移动左指针
            if (count>K){
                //遇到1时直接移动左指针
                while (A[left] == 1){
                    left++;
                }
                left++;
                //为0时还要将count--
                count--;
            }
            //记录最大值
            res = Math.max(right-left+1, res);
            //移动右指针
            right++;
        }
        return res;
    }
}
