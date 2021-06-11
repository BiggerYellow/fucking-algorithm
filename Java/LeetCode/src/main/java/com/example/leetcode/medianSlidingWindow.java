package com.example.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author huangchunchen
 * @date 2021/2/3 9:38
 * @description
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *  
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class medianSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
//        int[] nums = new int[]{1,4,2,3};
//        int[] nums = new int[]{7,0,3,9,9,9,1,7,2,3};
        double[] doubles = medianSlidingWindow(nums, 3);
        System.out.println(doubles);

    }

    //暴力破解法  超时
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int left = 0, right =k-1;
        double[] temp = new double[k];

        while (right < nums.length){
            int tempLeft = left;
            for (int i=0;i<k;i++){
                temp[i] = nums[tempLeft++];
            }

            Arrays.sort(temp);

            if (k%2 == 1){
                res[left] = temp[k/2];
            }else {
                res[left] =  (temp[k/2] + temp[(k/2)-1])/2;
            }
            left++;
            right++;
        }
        return res;
    }

    // 滑动窗口解法
    // 中位数是有序序列最中间的数
    // 大根堆 - 维护了窗口中较小部分的一部分值
    static PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> {return Integer.compare(b,a);});
    // 小根堆 - 维护了窗口中较大的一部分值
    static PriorityQueue<Integer> large = new PriorityQueue<>();
    public static double[] medianSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        // 保存结果
        double[] res = new double[n - k + 1];
        int idx = 0;

        // 定义窗口大小[left, right], 固定大小为k
        int left = 0, right = 0;
        for (right = 0; right < n; right++) {

            // 添加元素
            insert(nums, right);
            // 平衡small和large中元素个数
            balanceHeap();

            // 计算中位数
            if (right - left + 1 == k) {
                // 根据small和large的元素个数来计算中位数
                if (large.size() == small.size())
                    // 注意溢出
                    res[idx++] = small.peek() / 2.0 + large.peek() / 2.0;
                else
                    res[idx++] = small.peek();
                // 扩大窗口, 与此同时需要去small或large中删除对应元素
                // priorityQueue支持删除堆中任何元素
                if (nums[left] <= small.peek())
                    small.remove(nums[left]);
                else
                    large.remove(nums[left]);
                // 重新平衡small和large
                balanceHeap();
                left++;
            }

        }

        return res;

    }

    // 优先队列插入操作
    public static void insert (int[] nums, int k) {
        // 若small为空或者small栈顶元素大于nums[k], 则存放到small中
        // 否相存放到large中
        if (small.size() == 0 || small.peek() >= nums[k])
            small.add(nums[k]);
        else
            large.add(nums[k]);
    }

    // 根据元素个数规则平衡small和large
    public static void balanceHeap () {
        // small中元素个数大于large个数2个
        if (small.size() > large.size() + 1)
            large.add(small.poll());
            // large中个数大于small个数一个
        else if (large.size() > small.size())
            small.add(large.poll());
    }


}
