package com.example.leetcode;

import java.util.Arrays;

/**
 * @author huangchunchen
 * @date 2021/4/12 9:17
 * @description
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class largestNumber {
    public static void main(String[] args){
//        int[] nums = new int[]{3,30,34,5,9};
//        int[] nums = new int[]{0,0};
        int[] nums = new int[]{111311, 1113};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings,(a,b) ->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<strings.length;i++){
            sb.append(strings[i]);
        }
        return sb.toString().charAt(0)=='0'?"0":sb.toString();
    }
}
