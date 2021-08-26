package com.example.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/8/22 10:42
 * @description
 * 给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。
 * 请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = ["01","10"]
 * 输出："11"
 * 解释："11" 没有出现在 nums 中。"00" 也是正确答案。
 * 示例 2：
 *
 * 输入：nums = ["00","01"]
 * 输出："11"
 * 解释："11" 没有出现在 nums 中。"10" 也是正确答案。
 * 示例 3：
 *
 * 输入：nums = ["111","011","001"]
 * 输出："101"
 * 解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] 为 '0' 或 '1'
 */
public class findDifferentBinaryString {
    public static void main(String[] args) {
        String[]  nums = {"111","011","001"};
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String res ;

    public static String findDifferentBinaryString(String[] nums) {
        List<String> list = Arrays.asList(nums);
        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, len, list);
        return res;
    }

    public static void dfs(StringBuilder sb, int track, int len, List<String> list){
        if (track == len && !list.contains(sb.toString())){
            res = sb.toString();
            return;
        }
        for (int i=0;i<=1;i++){
            if (track == len && list.contains(sb.toString())){
                continue;
            }
            sb.append(i);
            dfs(sb, track+1, len, list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
