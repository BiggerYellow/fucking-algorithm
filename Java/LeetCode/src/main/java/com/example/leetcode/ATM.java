package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/16 23:34
 * @description:
 * 6062. 设计一个 ATM 机器 显示英文描述
 * 通过的用户数677
 * 尝试过的用户数933
 * 用户总通过次数682
 * 用户总提交次数1685
 * 题目难度Medium
 * 一个 ATM 机器，存有 5 种面值的钞票：20 ，50 ，100 ，200 和 500 美元。初始时，ATM 机是空的。用户可以用它存或者取任意数目的钱。
 *
 * 取款时，机器会优先取 较大 数额的钱。
 *
 * 比方说，你想取 $300 ，并且机器里有 2 张 $50 的钞票，1 张 $100 的钞票和1 张 $200 的钞票，那么机器会取出 $100 和 $200 的钞票。
 * 但是，如果你想取 $600 ，机器里有 3 张 $200 的钞票和1 张 $500 的钞票，那么取款请求会被拒绝，因为机器会先取出 $500 的钞票，然后无法取出剩余的 $100 。注意，因为有 $500 钞票的存在，机器 不能 取 $200 的钞票。
 * 请你实现 ATM 类：
 *
 * ATM() 初始化 ATM 对象。
 * void deposit(int[] banknotesCount) 分别存入 $20 ，$50，$100，$200 和 $500 钞票的数目。
 * int[] withdraw(int amount) 返回一个长度为 5 的数组，分别表示 $20 ，$50，$100 ，$200 和 $500 钞票的数目，并且更新 ATM 机里取款后钞票的剩余数量。如果无法取出指定数额的钱，请返回 [-1] （这种情况下 不 取出任何钞票）。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"]
 * [[], [[0,0,1,2,1]], [600], [[0,1,0,1,1]], [600], [550]]
 * 输出：
 * [null, null, [0,0,1,0,1], null, [-1], [0,1,0,0,1]]
 *
 * 解释：
 * ATM atm = new ATM();
 * atm.deposit([0,0,1,2,1]); // 存入 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票。
 * atm.withdraw(600);        // 返回 [0,0,1,0,1] 。机器返回 1 张 $100 和 1 张 $500 的钞票。机器里剩余钞票的数量为 [0,0,0,2,0] 。
 * atm.deposit([0,1,0,1,1]); // 存入 1 张 $50 ，1 张 $200 和 1 张 $500 的钞票。
 *                           // 机器中剩余钞票数量为 [0,1,0,3,1] 。
 * atm.withdraw(600);        // 返回 [-1] 。机器会尝试取出 $500 的钞票，然后无法得到剩余的 $100 ，所以取款请求会被拒绝。
 *                           // 由于请求被拒绝，机器中钞票的数量不会发生改变。
 * atm.withdraw(550);        // 返回 [0,1,0,0,1] ，机器会返回 1 张 $50 的钞票和 1 张 $500 的钞票。
 *
 *
 * 提示：
 *
 * banknotesCount.length == 5
 * 0 <= banknotesCount[i] <= 109
 * 1 <= amount <= 109
 * 总共 最多有 5000 次 withdraw 和 deposit 的调用。
 * 函数 withdraw 和 deposit 至少各有 一次 调用。
 */
public class ATM {
    public Map<Integer, Integer> cache;

    public ATM() {
        cache = new HashMap<>();
    }

    public void deposit(int[] banknotesCount) {
        cache.put(500, cache.getOrDefault(500,0)+banknotesCount[0]);

        cache.put(200, cache.getOrDefault(200,0)+banknotesCount[1]);

        cache.put(100, cache.getOrDefault(100,0)+banknotesCount[2]);

        cache.put(50, cache.getOrDefault(50,0)+banknotesCount[3]);

        cache.put(20, cache.getOrDefault(20,0)+banknotesCount[4]);


    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        boolean flag = false;
        if(cache.get(500) !=0){
            if (amount - cache.get(500)*500 < 0){
                return new int[]{-1};
            }else if (amount - cache.get(500)*500 > 0){
                amount -= cache.get(500)*500;
                res[4] = cache.get(500);
                cache.put(500, 0);
                flag = true;
            }else {
                res[4] = cache.get(500);
                cache.put(500, 0);
                return res;
            }
        }
        if(cache.get(200) !=0){
            if (amount - cache.get(200)*200 < 0){
                if (!flag){
                    return new int[]{-1};
                }
            }else if (amount - cache.get(200)*200 > 0){
                amount -= cache.get(200)*200;
                res[3] = cache.get(200);
                cache.put(200, 0);
            }else {
                res[3] = cache.get(200);
                cache.put(200, 0);
                return res;
            }
        }
        if(cache.get(100) !=0){
            if (amount - cache.get(100)*100 < 0){
                if (!flag){
                    return new int[]{-1};
                }
            }else if (amount - cache.get(100)*100 > 0){
                amount -= cache.get(100)*100;
                res[2] = cache.get(100);
                cache.put(100, 0);
            }else {
                res[2] = cache.get(100);
                cache.put(100, 0);
                return res;
            }
        }
        if(cache.get(50) !=0){
            if (amount - cache.get(50)*50 < 0){
                return new int[]{-1};
            }else if (amount - cache.get(50)*50 > 0){
                amount -= cache.get(50)*50;
                res[1] = cache.get(50);
                cache.put(50, 0);
            }else {
                res[1] = cache.get(50);
                cache.put(50, 0);
                return res;
            }
        }
        if(cache.get(20) !=0){
            if (amount - cache.get(20)*20 < 0){
                return new int[]{-1};
            }else if (amount - cache.get(20)*20 > 0){
                amount -= cache.get(20)*20;
                res[0] = cache.get(20);
                cache.put(20, 0);
            }else {
                res[0] = cache.get(20);
                cache.put(20, 0);
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        int[] withdraw = atm.withdraw(600);
        atm.deposit(new int[]{0,1,0,1,1});
        int[] withdraw1 = atm.withdraw(600);
        int[] withdraw2 = atm.withdraw(550);

    }

}
