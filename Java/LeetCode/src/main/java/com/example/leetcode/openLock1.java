package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/6/25 0:04
 * @description
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class openLock1 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadends, "0202"));
    }

//      public static int openLock(String[] deadends, String target) {
//         Set<String> deads = new HashSet<>();
//         for (String s:deadends){
//             deads.add(s);
//         }
//         Queue<String> q = new LinkedList<>();
//         Set<String> visited = new HashSet<>();
//         int step = 0;
//         q.offer("0000");
//         while (!q.isEmpty()){
//             int size = q.size();
//             for (int i=0;i<size;i++){
//                 //获取当前节点
//                 String cur = q.poll();
//                 //是否在死亡列表中
//                 if (deads.contains(cur)){
//                     continue;
//                 }
//                 //是否走的终点
//                 if (cur.equals(target)){
//                     return step;
//                 }
//                 //将其他可能加入
//                 for (int j=0;j<4;j++){
//                     String add = addOnce(cur, j);
//                     if (!visited.contains(add)){
//                         q.offer(add);
//                         visited.add(add);
//                     }
//                     String minOnce = minOnce(cur, j);
//                     if (!visited.contains(minOnce)){
//                         q.offer(minOnce);
//                         visited.add(minOnce);
//                     }
//                 }
//             }
//             step++;
//         }
//         return -1;
//     }

//     //向上拨动一次
//     public static String addOnce(String num, int index){
//         char[] chars = num.toCharArray();
//         if (chars[index] == '9'){
//             chars[index] = '0';
//         }else {
//             chars[index] +=1;
//         }
//         return new String(chars);
//     }
//
//     //向下拨动一次
//     public static String minOnce(String num, int index){
//         char[] chars = num.toCharArray();
//         if (chars[index] == '0'){
//             chars[index] = '9';
//         }else {
//             chars[index] -=1;
//         }
//         return new String(chars);
//     }


    //广度优先遍历
    public static int openLock(String[] deadends, String target) {
        List<String> dead = new ArrayList<>();
        for (String s:deadends){
            dead.add(s);
        }
        List<String> visit = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        int step=0;
        queue.offer("0000");
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String cur = queue.poll();
                if (dead.contains(cur)){
                    continue;
                }
                if (target.equals(cur)){
                    return step;
                }
                for (int j=0;j<4;j++){
                    String tempAdd = addOnce(cur, j);
                    if (!visit.contains(tempAdd)){
                        queue.offer(tempAdd);
                        visit.add(tempAdd);
                    }
                    String tempMin = minOnce(cur, j);
                    if(!visit.contains(tempMin)){
                        queue.offer(tempMin);
                        visit.add(tempMin);
                    }
                }
            }
            step++;
        }
        return -1;
    }
//
    public static String addOnce(String num, int index){
        char[] chars = num.toCharArray();
        if (chars[index] == '9'){
            chars[index] = '0';
        }else {
            chars[index] +=1;
        }
        return new String(chars);
    }

    public static String minOnce(String num, int index){
        char[] chars = num.toCharArray();
        if (chars[index] == '0'){
            chars[index] = '9';
        }else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

    }
