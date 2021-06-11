package com.example.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author huangchunchen
 * @date 2021/1/27 14:17
 * @description
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class permuteUnique {
    public static void main(String[] args) {
        int[] nums = new  int[]{1,2,3};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //数组使用记录
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(list, nums, flag);
        return res;
    }

    public static void dfs(List<Integer> list, int[] nums,boolean[] flag){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            //保证数组是顺序使用的
            if (flag[i] || (i>0 && nums[i]==nums[i-1] && !flag[i-1])){
                continue;
            }
            list.add(nums[i]);
            flag[i] = true;
            dfs(list, nums, flag);
            flag[i] = false;
            list.remove(list.size()-1);
        }
    }
}
