package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/11/11 8:47
 * @description
 */
public class reverse {

    public static void main(String[] args) {
        int n = -123;
        System.out.println(re(n));
    }

    private static int re(int x){
        long n = 0;
        while (x !=0){
            n = x % 10 + n*10;
            x = x/10;
        }
        return (int) n == n? (int) n:0;
    }

    private static int reverse(int n){
        String s = String.valueOf(n);
        StringBuilder stringBuilder = new StringBuilder();
        if (String.valueOf(s.charAt(0)).equals("-")){
            stringBuilder.append("-");
            for (int i=s.length()-1;i>=1;i--){
                if (s.charAt(s.length()-1) == 0) continue;
                stringBuilder.append(s.charAt(i));
            }
        }else {
            for (int i=s.length()-1;i>=0;i--){
                if (s.charAt(s.length()-1) == 0) continue;
                stringBuilder.append(s.charAt(i));
            }
        }
        try {
            return Integer.valueOf(stringBuilder.toString()).intValue();
        }catch (Exception e){
            return 0;
        }
    }
}
