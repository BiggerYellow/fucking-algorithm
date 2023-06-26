package com.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/3 11:20
 * @description:
 */
public class findWinners {
    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
//        int[][] matches = {{2,3},{1,3},{5,4},{6,4}};
        List<List<Integer>> winners = findWinners(matches);
        System.out.println(winners);

    }
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> cache1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cache2 = new HashMap<Integer, Integer>();
        Queue<Integer> win = new PriorityQueue<Integer>();
        Queue<Integer> lost = new PriorityQueue<Integer>();
        for(int[] matche:matches){
            cache2.put(matche[1], cache2.getOrDefault(matche[1], 0) - 1);
        }
        for(int[] matche:matches){
            if (!cache2.keySet().contains(matche[0]) && !win.contains(matche[0])){
                win.add(matche[0]);
            }
        }

        cache2.forEach((key, value) ->{
            if (value == -1){
                lost.add(key);
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> win1 = new ArrayList<>();
        while (!win.isEmpty()){
            win1.add(win.poll());
        }
        List<Integer> lost1 = new ArrayList<Integer>();
        while (!lost.isEmpty()){
            lost1.add(lost.poll());
        }
        res.add(win1);
        res.add(lost1);
        return res;
    }
}
