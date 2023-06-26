package com.example.leetcode;

import java.util.Random;

/**
 * @author :huangchunchen
 * @date :Created in 2022/6/17 9:56
 * @description:
 */
public class randomSelectKNum {

    public int[] selectK(int[] nums, int k){
        Random random = new Random();
        int[] res = new int[k];
        int len = nums.length;
        for(int i=0;i<k;i++){
            res[i] = nums[i];
        }
        int count = k;
        int i = k;
        while(i < len){
            int j = random.nextInt(++count);
            if(j<k){
                res[j] = nums[i];
            }
            i++;
        }
        return res;
    }
}
