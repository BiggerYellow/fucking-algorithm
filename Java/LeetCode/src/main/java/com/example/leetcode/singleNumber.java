package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author huangchunchen
 * @date 2021/4/30 10:13
 * @description
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class singleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,2};
        System.out.println(singleNumber1(nums));
    }

    //借用map
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer num:nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        int res=0;
        for (Map.Entry entry:count.entrySet()){
            if ((int)entry.getValue() == 1){
                res = (int)entry.getKey();
            }
        }
        return res;
    }

    //位运算 int是32位的 如果一个位置出现3次  32位上指定的位置取余3肯定是0  那所有的数的32位相加后取余3 为1 的就是多余的数
    public static int singleNumber1(int[] nums){
        int res=0;
        for (int i=0;i<32;i++){
            int total=0;
            for (int num:nums){
                total+= ((num>>i)&1);
            }
            if (total%3 == 1){
                res |= (1<<i);
            }
        }
        return res;
    }

}
