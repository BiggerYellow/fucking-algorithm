package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2020/12/11 10:41
 * @description
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class letterCombinations {
    public static void main(String[] args) {
        String str = "23";
        System.out.println(letterCombinations(str));
    }

    public static List<String> letterCombinations(String digits){
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3",Arrays.asList("d","e","f"));
        map.put("4",Arrays.asList("g","h","i"));
        map.put("5",Arrays.asList("j","k","l"));
        map.put("6",Arrays.asList("m","n","o"));
        map.put("7",Arrays.asList("p","q","r","s"));
        map.put("8",Arrays.asList("t","u","v"));
        map.put("9",Arrays.asList("w","x","y","z"));

        List<String> res = new ArrayList<>();
        char[] chars = digits.toCharArray();
        //遍历输入的字符，并从map中获取对应的字母
        for (int i=0;i<chars.length;i++){
            List<String> list = map.get(String.valueOf(chars[i]));
            if (list != null){
                List<String> merge = merge(list, res);
                //将上一次使用过的记录清除
                if (i<=chars.length-1){
                    res.clear();
                }
                res.addAll(merge);
            }
        }
        return res;
    }

    //合并两个集合，并返回新集合
    public static List<String> merge(List<String> source, List<String> target){
        List<String> temp = new ArrayList<String>();
        if (target.size() == 0) temp.addAll(source);
        for (int i=0;i<source.size();i++){
            for (int j=0;j<target.size();j++){
                temp.add( target.get(j)+source.get(i));
            }
        }
        return temp;
    }
}
