package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/7/7 9:40
 * @description
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countPairs {
    public static void main(String[] args) {
//        int[] deliciousness = {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
        int[] deliciousness = {1,3,5,7,9};

        System.out.println(countPairs(deliciousness));
    }

    //map  key:当前值  value:出现次数
    public static int countPairs(int[] deliciousness) {
        int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num:deliciousness){
            max = Math.max(max, num);
        }
        int res=0;
        for (int num:deliciousness){
            for (int i=1;i<=max*2;i<<=1){
                int count = map.getOrDefault(i-num, 0);
                res = (res+count)%MOD;
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return res;
    }
}
