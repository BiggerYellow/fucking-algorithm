package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/6/12 10:54
 * @description:
 */
public class calculateTax {
    public static void main(String[] args) {
        int[][] brackets = {{3,50},{7,10},{12,25}};
        int income = 10;
        System.out.println(calculateTax(brackets, income));
    }

    public static double calculateTax(int[][] brackets, int income) {
        double res = 0d;
        if (income <= brackets[0][0]){
            res += income * brackets[0][1]/100d;
            return res;
        }
        res += brackets[0][0] * brackets[0][1]/100d;
        for(int i=1;i<brackets.length;i++){
            if(income <= brackets[i][0]){
                res+= (income-brackets[i-1][0])*brackets[i][1]/100d;
                break;
            }else{
                res+=(brackets[i][0] - brackets[i-1][0])*brackets[i][1]/100d;
            }
        }
        return res;
    }
}
