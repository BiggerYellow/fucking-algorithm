package com.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huangchunchen
 * @date 2021/2/18 9:15
 * @description
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 *
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 *
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minKBitFlips {
    public static void main(String[] args) {
//        int[] A = new int[]{0,1,0};
//        int[] A = new int[]{1,1,0};
        int[] A = new int[]{0,0,0,1,0,1,1,0};
        System.out.println(minKBitFlips1(A, 3));
    }

    public static int minKBitFlips(int[] A, int K) {
        int left=0;
        int res = 0;
        while (left+K-1<A.length){
            if (A[left]==0){
                for (int i=left;i<left+K;i++){
                    if (A[i] == 0){
                        A[i] = 1;
                    }else {
                        A[i] = 0;
                    }
                }
                res++;
            }
            left++;
        }
        for (int i=A.length-K;i<A.length;i++){
            if (A[i] == 0){
                return -1;
            }
        }
        return res;
    }

    public static int minKBitFlips1(int[] A, int K) {
        int res = 0;
        //队列替代滑动窗口
        Deque<Integer> queue = new LinkedList<>();
        //遍历数组
        for (int i=0;i<A.length;i++){
            //当滑动窗口中的元素代表的位置加上K-1大于i时 移除头部
            if (queue.size()>0 && i> queue.peek()+K-1){
                queue.removeFirst();
            }
            //当queue.size %2 ==A[i]时表明需要翻转
            //1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            //2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (queue.size()%2 == A[i]){
                //当剩余元素不足K时直接返回-1
                if (i+K > A.length) return -1;
                //将元素添加进滑动窗口并res++
                queue.add(i);
                res++;
            }
        }
        return res;
    }
}
