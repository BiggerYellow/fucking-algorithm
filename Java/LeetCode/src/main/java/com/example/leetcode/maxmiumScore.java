package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/9/11 15:18
 * @description
 * 2. 心算挑战
 * 通过的用户数107
 * 尝试过的用户数200
 * 用户总通过次数110
 * 用户总提交次数253
 * 题目难度Easy
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
 * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 *
 * 示例 1：
 *
 * 输入：cards = [1,2,8,9], cnt = 3
 *
 * 输出：18
 *
 * 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
 *
 * 示例 2：
 *
 * 输入：cards = [3,3,1], cnt = 1
 *
 * 输出：0
 *
 * 解释：不存在获取有效得分的卡牌方案。
 *
 * 提示：
 *
 * 1 <= cnt <= cards.length <= 10^5
 * 1 <= cards[i] <= 1000
 */
public class maxmiumScore {
    public static void main(String[] args) {
        int[] cards = {1,5,7,8};
//        int[] cards = {3,3,1};
        System.out.println(maxmiumScore(cards, 2));
    }



    public static int res=0;
    public static int[] temp;

    public static int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int[] reverse = new int[cards.length];
        int index=0;
        for (int i=cards.length-1;i>=0;i--){
            reverse[index++] = cards[i];
        }
        temp = new int[cards.length];
        dfs(reverse, 0, cnt, 0);
        return res;
    }

    public static void dfs(int[] cards, int track, int count, int index){
        if (count==0 && track%2==0){
            res = Math.max(res, track);
            return;
        }
        for (int i=index;i<cards.length;i++){
            if (temp[i] !=0){
                continue;
            }
            temp[i]++;
            dfs(cards, track+=cards[i], count-=1, index);
            track-=cards[i];
            temp[i]--;
            count+=1;
        }
    }
}
