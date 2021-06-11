package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/2/26 8:56
 * @description
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findNumOfValidWords {
    public static void main(String[] args) {
        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(findNumOfValidWords(words, puzzles));

    }
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Set<String>> wordsMap = new HashMap<>();
        HashMap<String, Set<String>> puzzlesMap = new HashMap<>();
        for (String word : words){
            HashSet<String> set = new HashSet<>();
            for (char c:word.toCharArray()){
                set.add(String.valueOf(c));
            }
            wordsMap.put(word, set);
        }
        for (String puzzle : puzzles){
            HashSet<String> set = new HashSet<>();
            for (char c:puzzle.toCharArray()){
                set.add(String.valueOf(c));
            }
            int temp = 0;
            for (String word : words){
                if (wordsMap.get(word).contains(String.valueOf(puzzle.charAt(0))) && contanis(wordsMap.get(word), set)){
                    temp++;
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static boolean contanis(Set<String> source, Set<String> target){
        for (String s:source){
            if (!target.contains(s)){
                return false;
            }
        }
        return true;
    }
}
