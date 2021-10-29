package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/10/15 11:04
 * @description
 */
public class subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> res= new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>(track));
        dfs(nums, track, 0);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> track, int index){
        if(track.size() <= nums.length && !res.contains(track)){
            res.add(new ArrayList<Integer>(track));
        }
        for(int i=index;i<nums.length;i++){
            track.add(nums[i]);
            dfs(nums, track, i+1);
            track.remove(track.size()-1);
        }
    }
}
