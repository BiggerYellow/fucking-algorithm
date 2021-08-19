package com.example.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/8/19 9:47
 * @description
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels1("race car"));
    }

    public static String reverseVowels(String s) {
        List<Character> chars = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        char[] array = s.toCharArray();
        int left=0, right = s.length()-1;
        while (left<=right){
            if (chars.contains(array[left])){
                while (left<=right){
                    if (chars.contains(array[right])){
                        char temp = array[right];
                        array[right] = array[left];
                        array[left] = temp;
                        right--;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return new String(array);
    }

    public static String reverseVowels1(String s){
        List<Character> chars = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        char[] array = s.toCharArray();
        int left=0, right = s.length()-1;
        while (left<=right){
            while (left<=right && !chars.contains(array[left])){
                left++;
            }
            while (left<=right && !chars.contains(array[right])){
                right--;
            }
            if (left<=right){
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            left++;
            right--;
        }
        return new String(array);
    }
}
