package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/11/17 9:46
 * @description
 */
public class Palindrome {
    public static void main(String[] args) {
        int x = -111;
        System.out.println(isPalindrome(x));
    }

    private static boolean isPalindrome(int x){
        if (x < 0 || (x%10 == 0 && x!=0)) return false;

        int revernumber = 0;
        while (x > revernumber){
            revernumber = revernumber*10 + x%10;
            x/=10;
        }
        return x==revernumber || x==revernumber/10;
    }
}
