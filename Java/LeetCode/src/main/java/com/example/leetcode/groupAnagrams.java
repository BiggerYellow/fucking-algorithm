package com.example.leetcode;


import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangchunchen
 * @date 2021/1/28 11:32
 * @description
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class groupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strs));
    }

    //借用MultiValueMap  value是list
    public static List<List<String>> groupAnagrams(String[] strs) {
        MultiValueMap multiValueMap = new LinkedMultiValueMap<String, String>();
        for (String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            multiValueMap.put(key, s);
        }
        List<List<String>> collect = (List<List<String>>)multiValueMap.entrySet().stream().map(entry -> {
            Map.Entry entry1 = (Map.Entry) entry;
            return entry1.getValue();
        }).collect(Collectors.toList());
        return collect;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        return new ArrayList<>(Arrays.asList(strs).stream().collect(Collectors.groupingBy(x->{
           char[] chars = x.toCharArray();
           Arrays.sort(chars);
           return new String(chars);
       })).values());
    }
}
