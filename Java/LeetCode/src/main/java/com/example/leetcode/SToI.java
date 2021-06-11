package com.example.leetcode;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huangchunchen
 * @date 2020/11/11 9:55
 * @description
 */
public class SToI {
    public static void main(String[] args) {
        String s = "-1";
        System.out.println(pattern(s));
    }

    private static int myAtoi(String s){
        String replace = s.replace(" ", "");
        long n = 0;
        boolean minusFlag = false;
        boolean addFlag = false;
        for (char c:replace.toCharArray()){
            if (String.valueOf(c).equals("-")){
                minusFlag = true;
            }else if (String.valueOf(c).equals("+")){
                addFlag = true;
            }else if (!Character.isDigit(c)){
                return (int)n == n? (int)n : minusFlag ?Integer.MIN_VALUE :Integer.MAX_VALUE;
            }else if(Character.isDigit(c)){
                n = n*10 + Integer.valueOf(String.valueOf(c)).intValue();
            }
        }

        if (minusFlag && addFlag) return 0;
        if (minusFlag) n = -n;
        if ((int)n == n){
            return (int)n;
        }else {
            if (minusFlag){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
//        int minValue = (int)n == n? (int)n : String.valueOf(n).equals("-") ? Integer.MIN_VALUE :Integer.MAX_VALUE;
//        System.out.println(Integer.MIN_VALUE);
//        return minValue;
    }

    private static int pattern(String s){
        Pattern pattern = Pattern.compile("\\s*([+-]?\\d+)");
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()){
            return 0;
        }
        BigInteger ans = new BigInteger(matcher.group(1));
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0){
            return Integer.MIN_VALUE;
        }
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0){
            return Integer.MAX_VALUE;
        }
        return ans.intValue();
    }
}
