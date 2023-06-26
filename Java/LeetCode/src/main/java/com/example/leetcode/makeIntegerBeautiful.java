package com.example.leetcode;

import java.util.*;

/**
 * @author :huangchunchen
 * @date :Created in 2022/10/30 11:37
 * @description: https://leetcode.cn/contest/weekly-contest-317/problems/minimum-addition-to-make-integer-beautiful/
 */
public class makeIntegerBeautiful {
    public static void main(String[] args) {
        System.out.println(makeIntegerBeautiful(1L,1));
    }

    public static long makeIntegerBeautiful(long n, int target) {
        long res = 0L;
        if(n == target){
            return 0;
        }else{
            Deque<Long> cache = new ArrayDeque<>();
            long sum = 0;
            while(n != 0){
                long temp =  n%10;
                sum+=temp;
                cache.addFirst(temp);
                n/=10;
            }
            if(sum <= target){
                return 0;
            }

            long num = 1L;
            while(sum > target){
                sum = sum - cache.peekLast() + 1;
                res += (10-cache.pollLast()) * num;
                // cache.set(index+1, cache.get(index+1)+1);
                if (!cache.isEmpty()){
                    cache.addLast(cache.pollLast()+1);
                }
                num*=10;
            }
        }
        return res;
    }
}
