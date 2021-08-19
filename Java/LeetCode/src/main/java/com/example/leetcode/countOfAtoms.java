package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2021/7/5 9:02
 * @description
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2:
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * 示例 3:
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countOfAtoms {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("Ca", 2);
        map.put("Bb", 3);
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1,o2) ->{
            if ((o1.getKey().toCharArray()[0]-'A') - (o2.getKey().toCharArray()[0]-'A') >0){
                return 1;
            }
            return -1;
        });
        queue.addAll(map.entrySet());
        System.out.println(queue);
    }

    //思路 栈+优先队列
    public static String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();

        char[] chars = formula.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            char temp = chars[0];
            if (isUpperCase(temp)){
                sb.append(temp);
                while (i+1<chars.length){
                    if (isUpperCase(chars[i+1]) || chars[i+1] == '('){
                        if (stack.isEmpty()){
                            String s = sb.toString();
                            if (Character.isDigit(s.charAt(s.length()-1))){
                                map.put(s.substring(0, s.length()-2), Integer.valueOf(s.charAt(s.length()-1)));
                            }else {
                                map.put(s, 1);
                            }
                        }else {
                            stack.push(sb.toString());
                        }

                        sb.delete(0,sb.length());
                        continue;
                    }else if (islowerCase(chars[i+1])){
                        sb.append(chars[i+1]);
                        i++;
                    }else if (Character.isDigit(chars[i+1])){
                        sb.append(chars[i+1]);
                        i++;
                    }
                }
            }else if (temp == '('){
                stack.push("(");
            }else if (temp == ')'){
                int number = 1;
                if (i+1<chars.length && Character.isDigit(chars[i+1])){
                    number = Integer.valueOf(chars[i+1]);
                    i++;
                }
                while (stack.peek() != "("){
                    String pop = stack.pop();
                }
            }
        }
        return null;
    }


    public static boolean isUpperCase(Character c){
        return c-'A' >=65 && c-'A'<=90;
    }

    public static boolean islowerCase(Character c){
        return c-'a' >=97 && c-'a'<=122;
    }
}
