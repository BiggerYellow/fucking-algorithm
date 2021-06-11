package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/5/11 9:10
 * @description
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class decode1 {
    public static void main(String[] args) {
        int[] encoded = new int[]{6,5,4,6};
        int[] decode = decode(encoded);
        System.out.println(decode);
    }

    //因为perm是前 n 个正整数的排列，且 n 是个 奇数 
    //perm = [A,B,C,D,E]  encoded = [AB,BC,CD,DE]
    //根据perm可以得到ABCDE  根据encoded的BC和DE可以得到 BCDE
    //将ABCDE与BCDE做异或运算可以得到 A的值 再根据给出的规律运算即可
    public static int[] decode(int[] encoded) {
        int n = encoded.length;
        int[] array = new int[n+1];
        int arr = 0;
        for (int i=1;i<=n+1;i++){
            arr ^= i;
        }
        int en = 0;
        for (int i=1;i<encoded.length;i+=2){
            en^= encoded[i];
        }

        int start = arr ^ en;
        array[0] = start;
        for (int i=1;i<=encoded.length;i++){
            array[i] = array[i-1] ^ encoded[i-1];
        }
        return array;
    }

    public static List<List<Integer>> res = new ArrayList<>();

    public static void dfs(int n, List<Integer> temp){
        if (temp.size() == n+1){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=1;i<=n+1;i++){
            if (temp.contains(i)){
                continue;
            }
            temp.add(i);
            dfs(n, temp);
            temp.remove(temp.size()-1);
        }
    }
}
