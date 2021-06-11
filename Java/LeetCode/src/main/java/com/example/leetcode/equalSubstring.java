package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/2/5 9:04
 * @description
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class equalSubstring {
    public static void main(String[] args) {
        String s = "krpgjbjjznpzdfy";
        String t = "nxargkbydxmsgby";
        System.out.println(equalSubstring(s, t, 14));
    }

    //双指针法
    //将每个位置上的差值转换为数组 本题可以理解成 在一个数组中找到连续的不大于maxCost的最长子串
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int[] array = new int[charsS.length];
        //存放差值的数组
        for (int i=0;i<charsS.length;i++){
            array[i] = Math.abs((charsS[i] - 'a') - (charsT[i] - 'a'));
        }

        int maxLength = 0;
        int left = 0;
        int right =0;
        int tempSum=0;
        //直到右指针到尾部结束
        while (right < array.length){
            //将数组的值累加 即右指针向右移动
            tempSum += array[right];
            //当临时总和大于maxCost时  再减去左指针的值并将左指针向右移动一格
            while (tempSum > maxCost){
                tempSum -= array[left];
                left++;
            }
            //依赖每次移动的最大值
            maxLength = Math.max(maxLength, right - left+1);
            right++;
        }
        return maxLength;
    }
}
