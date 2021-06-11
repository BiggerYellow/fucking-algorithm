package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/4/29 9:46
 * @description
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 示例 1：
 *
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 * 示例 2：
 *
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class canCross {
    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(canCross1(stones));
    }

    //动态规划
    //dp[i][k] 代表当前位置i通过步长k跳过来的
    //dp[i][k] = dp[j][k-1] | dp[j][k] | dp[j][k+1]
    public static boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[0][0] = true;
        //优化 当第i个石子与第i-1个石子相差超过i时，直接返回失败
        for (int i=1;i<stones.length;i++){
            if (stones[i] - stones[i-1] > i){
                return false;
            }
        }
        for (int i=1;i<stones.length;i++){
            for (int j=i-1;j>=0;j--){
                //上一步的步长
                int k = stones[i]-stones[j];
                // 上一步的步长一定不能大于j
                if (k > j+1){
                    break;
                }
                dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                if (i == stones.length-1 && dp[i][k]){
                    return true;
                }
            }
        }
        return false;
    }

    //dfs
    //每次跳跃有三种情况 要么k-1,k,k+1
    //如果能跳到最后表明可以跳过
    public static Map<Integer, Integer> map = new HashMap<>();
    public static Map<String, Boolean> cache = new HashMap<>();

    public static boolean canCross1(int[] stones) {
        //便于快速找到下标
        for (int i=0;i<stones.length;i++){
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) return false;
        return dfs(stones, 0 ,0);
    }

    //深度优先遍历
    public static boolean dfs(int[] stones, int i, int k){
        String key = i+"_"+k;
        //判断当前位置加步长是否已经走过
        if (cache.containsKey(key)) return cache.get(key);
        //递归结束条件 当前位置 i = 数组长度
        if (i == stones.length-1) return true;
        //遍历三种步长
        for (int j=-1;j<=1;j++){
            //步长为0 直接跳过
            if (j+k==0) continue;
            //得到下一步的数值
            int next = stones[i] + j + k;
            //若下一步的值在map中 继续往下执行
            if (map.containsKey(next)){
                Boolean flag = dfs(stones, map.get(next), j+k);
                cache.put(key, flag);
                if (flag){
                    return true;
                }
            }
        }
        cache.put(key, false);
        return false;
    }


}
