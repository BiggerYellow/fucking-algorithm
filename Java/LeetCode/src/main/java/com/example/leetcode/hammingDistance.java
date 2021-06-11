package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/5/27 9:14
 * @description
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 2   (0 0 1 0)
 * 3   (0 0 1 1)
 * 4   (0 1 0 0)
 * 5   (0 1 0 1)
 * 6   (0 1 1 0)
 * 7   (0 1 1 1)
 * 8   (1 0 0 0)
 * 9   (1 0 0 1)
 * 10  (1 0 1 0)
 *        ↑   ↑
 * 1 4 (0 1 0 1) ^ & |
 * 1 2 ()
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class hammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance1(1,4));
    }

    //使用异或 得到不同的位置为1  然后求得新数有多少个1即可
    //使用 n&(n-1) 去除最后的1
    public static int hammingDistance(int x, int y) {
        int temp = x^y;
        int res=0;
        while (temp!=0){
            temp &= (temp-1);
            res++;
        }
        return res;
    }

    //和1 & 操作看是否等于1  为1则res++
    //在将异或后的数 右移一位
    public static int hammingDistance1(int x, int y) {
        int temp = x^y;
        int res=0;
        while (temp !=0){
            res += temp&1;
            temp >>=1;
        }
        return res;
    }
    }
