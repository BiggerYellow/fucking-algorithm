package com.example.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2020/10/30 11:27
 * @description
 */
public class ZigZag {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     *  
     *
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * Example 3:
     *
     * Input: s = "A", numRows = 1
     * Output: "A"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        try {
            int i = 1/0;
        }catch (Exception e){
            System.out.println(e);
        }

        String str = "abcderty";
        int row =2;
        String[][] array = new String[row][str.length()];

        boolean flag = true;
        int k=0;
        int m=0;
        int n=0;
        for (int i=0;i<str.length();i++){
            if (str.length() > n){
                if (flag){
                    for (int j=0;j<row;j++){
                        if (str.length() > n) array[k++][m] = String.valueOf(str.charAt(n++));
                    }
                    flag = false;
                    if (k==row) k--;
                }else {
                    if (k==1) {
                        flag = true;
                        --k;
                        ++m;
                        continue;
                    }
                    if (str.length() > n) array[--k][++m] = String.valueOf(str.charAt(n++));
                }
            }
        }

        for (int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if (StringUtils.isNotEmpty(array[i][j]))
                stringBuilder.append(array[i][j]);
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println(convert(str, row));
    }

    private static String convert(String s, int rowNum){
        if (rowNum == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i=0;i<rowNum;i++){
            list.add(new StringBuilder());
        }
        int i=0,flag = -1;
        for (char c:s.toCharArray()){
            list.get(i).append(c);
            if (i==0 || rowNum-1 == i) flag = -flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list){
            res.append(sb);
        }

        return res.toString();

    }
}
