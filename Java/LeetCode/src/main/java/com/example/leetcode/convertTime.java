package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/3 11:01
 * @description:
 */
public class convertTime {
    public static void main(String[] args) {
        System.out.println(convertTime("09:41","10:34"));
    }


    public static int convertTime(String current, String correct) {
        int h = Integer.valueOf(correct.substring(0,2)) - Integer.valueOf(current.substring(0,2));
        int m = Integer.valueOf(correct.substring(3,5)) - Integer.valueOf(current.substring(3,5));

        int total = h*60 + m;

        int res = 0;
        res+=total/60;
        total%=60;
        res+= total/15;
        total%=15;
        res+=total/5;
        total%=5;
        res+=total;
        return res;
    }
}
