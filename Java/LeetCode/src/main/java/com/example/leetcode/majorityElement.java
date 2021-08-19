package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/7/9 9:05
 * @description
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。 
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9,5,9,5,5,5};
        System.out.println(majorityElement1(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        int count;
        if (nums.length %2 ==1){
            count = nums.length/2 + 1;
        }else {
            count = nums.length/2;
        }
        for (int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.getOrDefault(num, 0) >=count){
                res = num;
            }
        }
        return res;
    }

    //摩尔投票
    //采用两两消除的方法  因为要求的值出现次数肯定是大于剩下其他数的出现次数之和的
    //定义候选者 candidate 和 出现次数 count
    //1.当count为0时 将当前num赋值给candidate
    //2.当num等于candidate时 将count++ 否则 count--
    //最后还需要确认最后的candidate是否为最终的结果  再次遍历nums判断candidate的出现次数
    public static int majorityElement1(int[] nums){
        int candidate = -1;
        int count=0;
        for (int num:nums){
            if (count==0){
                candidate = num;
            }
            if (candidate == num){
                count++;
            }else {
                count--;
            }
        }

        count =0;
        for (int num:nums){
            if (num == candidate){
                count++;
            }
        }
        return count*2 >= nums.length? candidate:-1;
    }
}
