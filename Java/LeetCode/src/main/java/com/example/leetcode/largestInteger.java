package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/10 11:13
 * @description:
 * 6037. 按奇偶性交换后的最大数字 显示英文描述
 * 通过的用户数4145
 * 尝试过的用户数4648
 * 用户总通过次数4176
 * 用户总提交次数6780
 * 题目难度Easy
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 *
 * 返回交换 任意 次之后 num 的 最大 可能值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 1234
 * 输出：3412
 * 解释：交换数字 3 和数字 1 ，结果得到 3214 。
 * 交换数字 2 和数字 4 ，结果得到 3412 。
 * 注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
 * 注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
 * 示例 2：
 *
 * 输入：num = 65875
 * 输出：87655
 * 解释：交换数字 8 和数字 6 ，结果得到 85675 。
 * 交换数字 5 和数字 7 ，结果得到 87655 。
 * 注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
 *
 *
 * 提示：
 *
 * 1 <= num <= 109
 */
public class largestInteger {
    public static void main(String[] args) {
        System.out.println(largestInteger(65875));
    }

    public static int largestInteger(int num) {
        List<Integer> temp = new ArrayList<>();
        while (num != 0){
            temp.add(num%10);
            num/=10;
        }
        int[] cache = new int[temp.size()];
        for (int i=temp.size()-1;i>=0;i--){
            cache[temp.size()-1-i] = temp.get(i);
        }
        for (int i=0;i<cache.length;i++){
            for (int j=i+1;j<cache.length;j++){
                if (cache[i] % 2 == cache[j] % 2 && cache[i] < cache[j]){
                    int t = cache[i];
                    cache[i] = cache[j];
                    cache[j] = t;
                }
            }
        }
        int res = 0 ;
        int n = 1;
        for (int i=cache.length-1;i>=0;i--){
            res+=cache[i]*n;
            n*=10;
        }
        return res;
    }
}
