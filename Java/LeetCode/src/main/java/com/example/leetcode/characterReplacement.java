package com.example.leetcode;

import java.util.HashMap;

/**
 * @author huangchunchen
 * @date 2021/2/2 8:58
 * @description
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class characterReplacement {
    public static void main(String[] args) {
//        String s = "BRJRRKNRBFOOKDEEGODTGMHNABMTHFNPTFRHRSEKKTFEQIKSIAJJMSDSLNSCNRNJFNFSIQDNMHDRIJIACLCJKATTFHDASGLRQSFN";
//        String s = "ABCDE";
//        String s = "ABBB";
//        String s = "BAAAB";
        String s = "AABABBA";
        System.out.println(characterReplacement(s,1));
    }

    //滑动窗口
    public static int characterReplacement(String s, int k) {
        //定义左右指针
        int left =0, rihgt =0;
        //定义结果
        int res=0;
        //定义一个字符的最大统计值
        int maxCount=0;
        //定义存放26个字母出现次数的数组
        int[] array = new int[26];
        //将入参s转换为字符数组
        char[] chars = s.toCharArray();
        //当right指针达到数组最右侧时结束
        while (rihgt < chars.length){
            //找到当前字符在数组中的位置并计数加1
            array[chars[rihgt]-'A']++;
            //更新字符出现的最多次数
            maxCount = Math.max(maxCount, array[chars[rihgt]-'A']);
            //右指针++  即窗口扩张
            rihgt++;

            //当窗口长度 大于 字符出现最多次数+可替换的k次 时，移动左指针
            if (rihgt-left > maxCount + k){
                //把left对应的字符出现次数减1
                array[chars[left]-'A']--;
                //left指针往前移动  即窗口滑动
                left++;
            }
            //取最大统计值
            res = Math.max(res, rihgt - left);
        }
        return res;
    }


}
