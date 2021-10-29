package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/10/8 11:39
 * @description
 * "101111"
 * "10"
 */
public class addBinary {
    public static void main(String[] args) {
        String a = "101111", b = "10";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA=a.length()-1;
        int indexB=b.length()-1;

        int temp=0;
        while(indexA >= 0 && indexB >=0){
            int sum = a.charAt(indexA)-'0' + b.charAt(indexB)-'0' + temp;
            if(sum==0){
                sb.append(0);
                temp=0;
            }else if(sum == 1){
                sb.append(1);
                temp=0;
            }else if(sum ==2){
                sb.append(0);
                temp=1;
            }else if(sum==3){
                sb.append(1);
                temp=1;
            }
            indexA--;
            indexB--;
        }

        while(indexA >=0){
            int sum = a.charAt(indexA)-'0' + temp;
            if(sum==0){
                sb.append(0);
                temp=0;
            }else if(sum == 1){
                sb.append(1);
                temp=0;
            }else if(sum ==2){
                sb.append(0);
                temp=1;
            }
            indexA--;
        }

        while(indexB >=0){
            int sum = b.charAt(indexB)-'0' + temp;
            if(sum==0){
                sb.append(0);
                temp=0;
            }else if(sum == 1){
                sb.append(1);
                temp=0;
            }else if(sum ==2){
                sb.append(0);
                temp=1;
            }
            indexB--;
        }
        if (temp == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
