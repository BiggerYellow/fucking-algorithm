package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2020/12/15 9:27
 * @description
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class fourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
//        int[] nums = new int[]{-1,-5,-5,-3,2,5,0,4};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //数组排序
        sort(nums);
        int N = nums.length;
        //第一层i遍历
        for (int i=0;i<N-3;i++){
            //第一层遍历的数字去重 相同则跳过
            if (i>0 && nums[i-1]==nums[i]) continue;
            //剪枝操作 当在确定第一个数之后，如果 nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，说明此时剩下的三个数无论取什么值，四数之和一定大于 target，因此退出第一重循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //剪枝操作 当确定第一个数之和，如果nums[i]+nums[N-3]+nums[N-2]+nums[N-1] < target，说明剩下的无论取什么值都是小于target直接进入下一轮循环
            if (nums[i] + nums[N - 3] + nums[N - 2] + nums[N - 1] < target) {
                continue;
            }
            //第二层遍历 j=i+1
            for (int j=i+1;j<N-2;j++){
                //第二层遍历的相邻数字相同则跳过
                if (j-i>1 && nums[j-1]==nums[j]) continue;
                //剪枝操作 当确定前两个数后，如果nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，说明剩下的无论取什么值都是大于target的，直接退出第二重循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //剪枝操作 当确定前两个数后，如果nums[i]+nums[j]+nums[N-2]+nums[N-1]<target，说明剩下的无论取什么值都是小于target的，直接进入下一轮二重循环
                if (nums[i] + nums[j] + nums[N - 2] + nums[N - 1] < target) {
                    continue;
                }

                //定义左右两个指针
                int L=j+1;
                int R=N-1;
                //L<R恒成立
                while (L<R){
                    //统计四数之和
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    //当总和小于目标值 L++
                    if (target > sum){
                        L++;
                    }else if (target < sum){//当总和大于目标值 R--
                        R--;
                    }else {
                        //当目标值等于总和 即是求的和
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[L]);
                        integers.add(nums[R]);
                        res.add(integers);
                        //当num[L]和num[L+1]相等时 即重复数据 跳过
                        while (L<R && nums[L+1]==nums[L]) L++;
                        //当num[R]和num[R+1]相等时 即重复数据 跳过
                        while (L<R && nums[R-1]==nums[R]) R--;
                        //两边指针移动
                        L++;
                        R--;
                    }
                }
            }
        }
        return res;
    }

    public static void sort(int[] nums){
        int temp;
        for (int i=0;i<nums.length-1;i++){
            for (int j=nums.length-1;j>i;j--){
                if (nums[j-1]>nums[j]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
