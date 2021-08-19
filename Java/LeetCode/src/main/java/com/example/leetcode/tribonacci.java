package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/8/8 10:20
 * @description
 */
public class tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        int[] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        for(int i=3;i<=n;i++){
            arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
        }
        return arr[n];
    }
}
