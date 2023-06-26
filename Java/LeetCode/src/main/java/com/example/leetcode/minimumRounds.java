package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/17 11:06
 * @description:
 * 6071. 完成所有任务需要的最少轮数 显示英文描述
 * 通过的用户数1982
 * 尝试过的用户数2286
 * 用户总通过次数1984
 * 用户总提交次数2857
 * 题目难度Medium
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
 *
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
 * 输出：4
 * 解释：要想完成所有任务，一个可能的计划是：
 * - 第一轮，完成难度级别为 2 的 3 个任务。
 * - 第二轮，完成难度级别为 3 的 2 个任务。
 * - 第三轮，完成难度级别为 4 的 3 个任务。
 * - 第四轮，完成难度级别为 4 的 2 个任务。
 * 可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
 * 示例 2：
 *
 * 输入：tasks = [2,3,3]
 * 输出：-1
 * 解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
 *
 *
 * 提示：
 *
 * 1 <= tasks.length <= 105
 * 1 <= tasks[i] <= 109
 */
public class minimumRounds {
    public static void main(String[] args) {
        int[] tasks = {5,5,5,5};
        System.out.println(minimumRounds(tasks));
    }

    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cache = new HashMap<>();
        for(int task:tasks){
            cache.put(task, cache.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for(int value:cache.values()){
            int size = value/3;
            int temp = 0;
            for(int i=size;i>=0;i--){
                int diff = value - i*3;
                if(diff %2 == 0){
                    temp +=i;
                    temp += diff/2;
                    res+=temp;
                    break;
                }
                if(i == 0){
                    return -1;
                }
            }
        }
        return res;
    }
}
