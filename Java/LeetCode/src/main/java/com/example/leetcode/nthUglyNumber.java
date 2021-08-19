package com.example.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author huangchunchen
 * @date 2021/8/9 22:34
 * @description
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class nthUglyNumber {
    public static void main(String[] args) {

    }

    public int nthUglyNumber(int n) {
        int[] nums = {2,3,5};
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        visited.add(1l);
        priorityQueue.offer(1l);
        int res=0;
        for (int i=0;i<n;i++){
            long poll = priorityQueue.poll();
            res = (int) poll;
            for (int num:nums){
                long next = num*poll;
                if (visited.add(next)){
                    priorityQueue.offer(next);
                }
            }
        }
        return res;
    }
}
