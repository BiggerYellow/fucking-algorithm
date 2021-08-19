package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author huangchunchen
 * @date 2021/7/3 9:50
 * @description
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class frequencySort {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort1(s));

    }

    //优先级队列 先根据出现次数排序,再根据大小排序
    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c:chars){
            Integer count = map.getOrDefault(c, 0);
            map.put(c,count+1);
        }
        //直接根据频率排序
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1,o2) ->{
         if (o1.getValue()<o2.getValue()){
             return 1;
         }
         return -1;
        });
        queue.addAll(map.entrySet());
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }



    //使用二维数组  i存在字母出现的位置  j存放频率
    public static String frequencySort1(String s) {
        int[][] arr = new int[128][2];
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            arr[chars[i]][0] = chars[i];
            arr[chars[i]][1] ++;
        }
        //如果频率相同 根据字符正序排序
        //如果频率不同 根据频率逆序排序
        Arrays.sort(arr, (o1,o2) ->{
            if (o1[1] != o2[1]){
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<128;i++){
            int count = arr[i][1];
            while (count-->0){
                sb.append((char)arr[i][0]);
            }
        }
        return sb.toString();
    }

    }
