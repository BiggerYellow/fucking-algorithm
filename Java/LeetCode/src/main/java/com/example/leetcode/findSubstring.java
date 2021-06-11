package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2020/12/29 13:55
 * @description
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class findSubstring {
    public static void main(String[] args) {
        String s ="barfoothefoobarman";
//        String s ="wordgoodgoodgoodbestword";

        String[] str = new String[]{"foo","bar"};
//        String[] str = new String[]{"word","good","best"};
//        String[] str = new String[]{"word","good","best","good"};
//        String[] str = new String[]{"word","good","best","word"};


        List<Integer> substring = findSubstring1(s, str);
        System.out.println(substring);

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        //获取字符数组的全排列情况
        allPermutation(words, 0, arrayList);
        ArrayList<Integer> res = new ArrayList<>();
        for (String target:arrayList){
            res.addAll(getIndex(s,target));
        }
        ArrayList<Integer> integers = new ArrayList<>();
        //去重
        for (Integer num:res){
            if (!integers.contains(num)){
                integers.add(num);
            }
        }
        return integers;
    }

    //获取符合的索引位置
    private static List<Integer> getIndex(String source, String target){
        ArrayList<Integer> list = new ArrayList<>();
        if (source.length() < target.length()) return list;
        for (int i=0;i<source.length()-target.length()+1;i++){
            if (source.substring(i, i+target.length()).equals(target)){
                list.add(i);
            }
        }
        return list;
    }

    //获取全排列组合情况
    public static void allPermutation(String[] c, int start, ArrayList<String> listStr) {
        if(start == c.length-1)
            listStr.add(getString(c));
        else{
            for(int i = start; i <= c.length-1; i++)
            {
                swap(c, i, start);//相当于: 固定第 i 个字符
                allPermutation(c, start+1, listStr);//求出这种情形下的所有排列
                swap(c, start, i);//复位
            }
        }
    }

    private static void swap(String[] c, int i, int j){
        String tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    private static String getString(String[] c){
        StringBuilder sb = new StringBuilder();
        for (String s:c){
            sb.append(s);
        }
        return sb.toString();
    }

    //使用hashMap比较
    public static List<Integer> findSubstring1(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (words.length == 0 ) return res;
        //每个元素的长度
        int wordLen = words[0].length();
        //数组总长度
        int allLen = wordLen*words.length;
        //目标字符串长度
        int sLen = s.length();
        //数组字符串出现的次数
        HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word:words){
            Integer num = wordsMap.get(word);
            if (num == null){
                wordsMap.put(word, 1);
            }else {
                wordsMap.put(word, num+1);
            }
        }
        //遍历目标字符串 直到总长度减去数组总长度
        for (int i=0;i<sLen-allLen+1;i++){
            HashMap<String, Integer> resMap = new HashMap<String, Integer>();
            int j=i;
            int sum = i+allLen;
            //从开始每隔数组中每个单词的长度截取 并防止在另一个hashMap中
            while (j<sum){
                String substring = s.substring(j, j + wordLen);
                Integer num = resMap.get(substring);
                if (num == null){
                    resMap.put(substring, 1);
                }else {
                    resMap.put(substring, num+1);
                }
                j+=wordLen;
            }
            //比较两个hashMap 一致则将当前 索引i 添加到结果集合中
            if (isEqual(wordsMap, resMap)){
                res.add(i);
            }
        }
        return res;
    }

    public static boolean isEqual(HashMap<String, Integer> wordsMap, HashMap<String, Integer> resMap){
        Set<Map.Entry<String, Integer>> entries = wordsMap.entrySet();
        for (Map.Entry<String, Integer> entry:entries){
            Integer sum = resMap.get(entry.getKey());
            if (sum == null || !sum.equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }

}
