package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/5/28 9:19
 * @description
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 0100
 * 1110
 * 0010
 *
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 *
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class totalHammingDistance {
    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance1(nums));
    }

    public static int totalHammingDistance2(int[] nums) {
        int res=0;
        int n = nums.length;
        //2^32 所以到31为止
        for (int i=0;i<31;i++){
            //临时变量 记录第i位 有多少个1
            int temp=0;
            //遍历nums
            for (int num:nums){
                //累加第i位1的数量
                temp += (num>>i)&1;
            }
            //结果加上 第i位 1的个数 乘以 第i位0的个数
            res+=temp*(n-temp);
        }
        return res;
    }



    public static int res = 0;

    public static int totalHammingDistance1(int[] nums) {
        List<Integer> track = new ArrayList<>();
        dfs(track, nums, 0);
        return res;
    }

    public static void dfs(List<Integer> track, int[] nums, int start){
        if (track.size() == 2){
            res += hammingDistance(track.get(0), track.get(1));
            return;
        }
        for (int i=start;i<nums.length;i++){
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            dfs(track, nums, i+1);
            track.remove(track.size()-1);
        }
    }

    public static int hammingDistance(int x, int y){
        int temp = x^y;
        int res=0;
        while (temp!=0){
            temp&=(temp-1);
            res++;
        }
        return res;
    }


    public static int totalHammingDistance(int[] nums) {
        int res = 0;
        int n =nums.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                res += hammingDistance(nums[i], nums[j]);
            }
        }
        return res;
    }


}
