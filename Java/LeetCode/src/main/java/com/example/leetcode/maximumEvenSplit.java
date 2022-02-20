package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/2/19 23:31
 * @description:
 * 5998. 拆分成最多数目的偶整数之和 显示英文描述
 * 通过的用户数2021
 * 尝试过的用户数2312
 * 用户总通过次数2047
 * 用户总提交次数3573
 * 题目难度Medium
 * 给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的偶整数之和，且拆分出来的偶整数数目 最多 。
 *
 * 比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的偶整数且和为 finalSum）：(2 + 10) ，(2 + 4 + 6) 和 (4 + 8) 。它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分出来的整数必须互不相同。
 * 请你返回一个整数数组，表示将整数拆分成 最多 数目的偶整数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返回这些整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：finalSum = 12
 * 输出：[2,4,6]
 * 解释：以下是一些符合要求的拆分：(2 + 10)，(2 + 4 + 6) 和 (4 + 8) 。
 * (2 + 4 + 6) 为最多数目的整数，数目为 3 ，所以我们返回 [2,4,6] 。
 * [2,6,4] ，[6,2,4] 等等也都是可行的解。
 * 示例 2：
 *
 * 输入：finalSum = 7
 * 输出：[]
 * 解释：没有办法将 finalSum 进行拆分。
 * 所以返回空数组。
 * 示例 3：
 *
 * 输入：finalSum = 28
 * 输出：[6,8,2,12]
 * 解释：以下是一些符合要求的拆分：(2 + 26)，(6 + 8 + 2 + 12) 和 (4 + 24) 。
 * (6 + 8 + 2 + 12) 有最多数目的整数，数目为 4 ，所以我们返回 [6,8,2,12] 。
 * [10,2,4,12] ，[6,2,4,16] 等等也都是可行的解。
 *
 *
 * 提示：
 *
 * 1 <= finalSum <= 1010
 */
public class maximumEvenSplit {
    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(12));
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1){
            return new ArrayList<>();
        }
        ArrayList<Long> res = new ArrayList<>();
        long temp = 2;
        while (finalSum>temp && !res.contains(finalSum)){
            res.add(temp);
            finalSum-=temp;
            temp+=2;
        }
        if (finalSum != 0){
            res.add(res.size()-1, res.get(res.size()-1)+finalSum);
        }
        return res;
    }


}
