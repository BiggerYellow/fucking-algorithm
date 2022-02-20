package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/2/20 10:51
 * @description:
 * 6012. 统计各位数字之和为偶数的整数个数 显示英文描述
 * 通过的用户数256
 * 尝试过的用户数311
 * 用户总通过次数284
 * 用户总提交次数360
 * 题目难度Easy
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 *
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 4
 * 输出：2
 * 解释：
 * 只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
 * 示例 2：
 *
 * 输入：num = 30
 * 输出：14
 * 解释：
 * 只有 14 个整数满足小于等于 4 且各位数字之和为偶数，分别是：
 * 2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
 */
public class countEven {
    public static void main(String[] args) {
        System.out.println(countEven(30));
    }

    public static int countEven(int num) {
        int res = 0;
        for(int i=1;i<=num;i++){
            if(valid(i)){
                res++;
            }
        }
        return res;
    }

    public static boolean valid(int num){
        int temp = 0;
        while(num/10 != 0){
            temp+=num%10;
            num/=10;
        }
        temp+=num;
        return temp%2==0;
    }
}
