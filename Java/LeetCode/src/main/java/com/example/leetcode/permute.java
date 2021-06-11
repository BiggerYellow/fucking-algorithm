package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/1/27 13:09
 * @description
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * dfs(路径,选择列表){
 *     if 条件满足
 *     result.add(路径)
 *     return
 *
 *     for 选择 in 选择列表
 *          做选择
 *          dfs(路径, 选择列表)
 *          撤销选择
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        dfs(list, nums);
        return res;
    }

    public static void dfs(List<Integer> list, int[] nums){
        //当list集合数量等于输入数组大小 表明搜索结束
        if (nums.length == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        //遍历选择列表
        for (int i=0;i<nums.length;i++){
            //如果list中已经包含当前元素则跳过,否则加入list中做选择
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            //递归执行
            dfs(list, nums);
            //执行结束撤销选择
            list.remove(list.size()-1);
        }
    }
}
