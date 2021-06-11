package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/3/31 9:05
 * @description
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * result[]
 *
 * def backtrack(路径，选择列表){
 *     if 满足条件
 *      res.add(路径)
 *      return
 *
 *      for 选择 in 选择列表
 *          做选择
 *          backtrack(路径， 选择列表)
 *          撤销选择
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class subsetsWithDup {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    //回溯算法  使用set去重
    //借用长度来判断是否要退出循环  先从指定位置一直遍历到数组末尾 在逐渐去除元素回到指定位置 在进行遍历
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> objects = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();

        dfs(objects,0, nums, res);
        return new ArrayList<>(res);
    }

    public static void dfs(List<Integer> track,int len, int[] nums, Set<List<Integer>> res){
        if (nums.length == len){
            res.add(new ArrayList<>(track));
            return;
        }
        //选择当前位置的元素往下遍历
        track.add(nums[len]);
        dfs(track,len+1, nums, res);
        //不选当前位置的元素 向下遍历
        track.remove(track.size()-1);
        dfs(track,len+1, nums, res);
    }



}
