package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/21 10:50
 * @description
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class addStrings {
    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "123";
        System.out.println(addStrings(num1, num2));
    }

    //双指针
    public static String addStrings(String num1, String num2) {
     int i = num1.length()-1;
     int j = num2.length()-1;
     //是否进位标志
     int add = 0;
     StringBuilder sb = new StringBuilder();
     //当双指针都没遍历完或还有进位
     while (i>=0 || j>=0 || add!=0){
         int x = i>=0? num1.charAt(i)-'0':0;
         int y = j>=0? num2.charAt(j)-'0':0;
         int sum = x+y+add;
         sb.append(sum%10);
         add = sum/10;
         i--;
         j--;
     }
     return sb.reverse().toString();
    }
}
