package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/1/11 17:07
 * @description
 */
public class fullPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);

    }
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums){
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }

    public static void backtrack(int[] nums, List<Integer> track){
        if (nums.length == track.size()){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size()-1);
        }
    }


}
