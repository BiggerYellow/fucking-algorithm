package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/10/24 8:42
 * @description:
 */
public class gcd {
    public static void main(String[] args) {
        System.out.println(0 % 2);
        System.out.println(gcd(0,2));
        System.out.println(1%4);

        int[] nums = {9,3,1,2,6,3};
        System.out.println(subberyGCD(nums, 3));
    }

    public static int subberyGCD(int[] nums, int k){
        int len = nums.length;
        int res = 0;
        for (int i=0;i<len;i++){
            int temp = 0;
            for(int j=i;j<len;j++){
                temp = gcd(temp, nums[j]);
                if(temp == k){
                    res++;
                }
            }
        }
        return res;
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
