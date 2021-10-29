package com.example.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huangchunchen
 * @date 2021/10/28 9:35
 * @description
 */
public class reorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(3));
    }

    static Set<Integer> set = new HashSet<>();
    static {
        for (int i = 1; i < (int)1e9+10; i *= 2) set.add(i);
    }

    static int m;
    static int[] cache = new int[10];

    public static boolean reorderedPowerOf2(int n) {
        while (n!=0){
            cache[n%10]++;
            n/=10;
            m++;
        }
        return dfs(0,0);
    }

    public static boolean dfs(int index, int num){
        if (index == m){
            //打表
            return set.contains(num);
            //位运算
//            return isValid(num);
        }
        for (int i=0;i<10;i++){
            if (cache[i] != 0){
                cache[i]--;
                if ((i!=0 || num!=0) && dfs(index+1, num*10+i)){
                    return true;
                }
                cache[i]++;
            }
        }
        return false;
    }

    public static boolean isValid(int num){
        return (num&(num-1)) == 0;
    }
}
