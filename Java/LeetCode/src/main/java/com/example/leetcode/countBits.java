package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/3/3 9:02
 * @description
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countBits {
    public static void main(String[] args) {
        int[] ints = countBits1(7);
        System.out.println(ints);
    }

    public static int[] countBits1(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i=0;i<=num;i++){
            res[i] = count(i);
        }
        return res;
    }

    public static int count(int num){
        int res=0;
        while (num>0){
            num &= (num-1);
            res++;
        }
        return res;
    }
}
