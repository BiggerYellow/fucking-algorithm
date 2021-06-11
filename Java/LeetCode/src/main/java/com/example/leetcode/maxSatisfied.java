package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/2/23 10:16
 * @description
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5],
 *      grumpy =    [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxSatisfied {
    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy    = new int[]{0,1,0,1,0,1,0,1};
        System.out.println(maxSatisfied(customers, grumpy, 3));

    }

    //滑动窗口
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        //首先计算出所有的grumpy上为0对应的customers之和
        for (int i=0;i<grumpy.length;i++){
            if (grumpy[i] == 0){
                sum+=customers[i];
            }
        }
        //使用滑动窗口计算出滑动窗口内grumpy对应值为1的customers的最大值
        int max=0;
        int temp=0;
        int left=0,right=0;
        //右指针到数组末尾位置
        while (right<grumpy.length){
            //当左右指针相差 X 时 即需要将左指针向右滑动，并减去temp的值
            if (right-left == X){
                if (grumpy[left] == 1){
                    temp-=customers[left];
                }
                left++;
            }
            //当左右指针相差小于 X 时 即需要将右指针向右滑动，并加上temp的值
            if (right-left <X){
                if (grumpy[right] == 1){
                    temp+=customers[right];
                }
                right++;
            }
            max = Math.max(max, temp);

        }
        return sum + max;
    }

}
