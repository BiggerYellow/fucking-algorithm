package com.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author huangchunchen
 * @date 2021/3/4 9:17
 * @description
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxEnvelopes {
    public static void main(String[] args) {
        System.out.println(Long.valueOf("61290988135226627260"));
        int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        int i = maxEnvelopes1(envelopes);
        System.out.println(i);
    }

    //最长严格递增子序列
    //首先先将数组envelopes按w升序和h降序排列，然后求出h列的最长严格递增子序列即可
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });

        //定义dp数组
        int[] dp = new int[envelopes.length];
        //默认每个位置都是存在至少1个子序列
        Arrays.fill(dp,1);
        int res = 1;
        for (int i=1;i<envelopes.length;i++){
            for (int j=0;j<i;j++){
                //当位置j对应的高度小于位置i对应的高度时  比较当前dp[i]和dp[j]+1的最大值  并赋值给dp[i]
                if (envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            //每次迭代完找出最大值
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    //二分查找+动态规划
    //可以使用二分查找找到排序后的高度数组中的最长严格子序列
    public static int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });

        int[] height = new int[envelopes.length];
        for (int i=0;i<envelopes.length;i++){
            height[i] = envelopes[i][1];
        }
        return lis(height);
    }

    //最长严格子序列算法  二分查找法
    public static int lis(int[] height){
        //初始右指针位置 也代表结果长度
        int res=0;
        //定义dp数组
        int[] dp = new int[height.length];
        //遍历高度数组
        for (int i=0;i<height.length;i++){
            //当前要比较的值
            int num = height[i];
            //定义左右指针
            int left=0;
            int right = res;
            while (left<right){
                int mid = left + (right-left)/2;
                if (dp[mid] >= num){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            //当当前left指针等于上一次的结果右指针时  将res++
            if (left == res) res++;
            //将当前比较的值赋值到dp数组左指针位置
            dp[left] = num;
        }
        return res;
    }
}
