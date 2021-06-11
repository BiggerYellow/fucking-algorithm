package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/1/13 9:17
 * @description
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class combinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        List<List<Integer>> lists = combinationSum(candidates, 8);
        System.out.println(lists);
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        combine1(candidates, list,res, target, 0);
        return res;
    }

    //回溯
    public static void combine(int[] candidates, List<Integer> list,List<List<Integer>> res, int target, int index){
        //如果索引等于入参集合长度 说明遍历完了 直接返回
        if (index == candidates.length ){
            return;
        }
        //如果target =0 表明找到相等的集合了 添加并返回
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        //index+1 递归遍历数组后面的元素
        combine(candidates,list,res, target, index+1);

        //如果target减去当前索引在数组中的值 大于等于0 进行处理
        if (target - candidates[index] >= 0){
            //添加到列表中
            list.add(candidates[index]);
            //可以重复 使用当前索引继续遍历
            combine(candidates,list,res, target - candidates[index], index);
            //撤销选择
            list.remove(list.size()-1);
        }
    }

    //回溯算法
    public static void combine1(int[] candidates, List<Integer> list,List<List<Integer>> res, int target, int index){
        //当目标值小于0 说明不相等 直接返回
        if (target < 0){
            return;
        }
        //当目标值等于0 说明相等 将list添加到res中
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        //因为数字可以重复 所以要重头开始遍历
        for (int i=index;i< candidates.length;i++){
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }
            //添加到结果
            list.add(candidates[i]);
            //递归获取下一个值
            combine1(candidates,list,res, target - candidates[i], i);
            //撤销选择
            list.remove(list.size()-1);
        }
    }
}
