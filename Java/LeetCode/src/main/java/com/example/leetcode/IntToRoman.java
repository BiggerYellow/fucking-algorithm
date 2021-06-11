package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/12/2 19:59
 * @description
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num){
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roma = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<13){
            while (num >= number[i]){
                sb.append(roma[i]);
                num -= number[i];
            }
            i++;
        }
        return sb.toString();
    }
}
