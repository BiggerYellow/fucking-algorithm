package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2020/12/8 15:14
 * @description
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class threeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0,-1,1};
//        int[] nums = new int[]{-1,0,1,0};
//        int[] nums = new int[]{3,0,-2,-1,1,2};
        System.out.println(threeSum2(nums));
    }

    //暴力破解法
    public static List<List<Integer>> threeSum(int[] nums){
        //排序
        sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        //处理多个0
        int zeroNum = 0;
        //处理重复数据 相邻位置一样
        int tempNum = 0;
        //处理0重复
        boolean zeroFlag = false;
        //遍历数组中的值
        for (int i=0;i<nums.length;i++){
            //排序后若nums[i]>0则往后都是大于0的  tempNum!=nums[i]保证去重
            if (nums[i]<0 && tempNum!=nums[i]){
                tempNum = nums[i];
                //从i+1往后双重遍历
                for (int j=i+1;j<nums.length;j++){
                    for (int z=j+1;z<nums.length;z++){
                        //如果nums[i] + nums[j] + nums[z]==0表明存在
                        if (nums[i] + nums[j] + nums[z] == 0){
                            List<Integer> temp = new ArrayList<Integer>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[z]);
                            list.add(temp);
                        }
                    }
                }
            }else if (nums[i] == 0){//如果当前nums[i]为0单独处理
                zeroNum++;
                if (zeroNum % 3==0 && zeroFlag){
                    zeroFlag = true;
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(0);
                    temp.add(0);
                    temp.add(0);
                    list.add(temp);
                }
            }
        }
        return list;
    }

    public static int[] sort(int[] nums){
        int temp;
        for (int i=0;i<nums.length-1;i++){
            for (int j=nums.length-1;j>i;j--){
                if (nums[j-1] > nums[j]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    //双指针法
    public static List<List<Integer>> threeSum2(int[] nums){
        ArrayList<List<Integer>> list = new ArrayList<>();
        //排序
        sort(nums);
        int len = nums.length;
        //遍历所有的值
        for (int i =0;i<nums.length;i++){
            //如果nums[i]>0 则直接返回
            if (nums[i] >0 ) return list;
            //如果相邻元素一样则跳过
            if (i>0 && nums[i-1]==nums[i]) continue;
            //记录开始位置和结束位置
            int L=i+1, R=len-1;
            //最左使用小于最右
            while (L<R){
                int temp = nums[i] + nums[L] + nums[R];
                //如果三值相加等于0
                if (temp == 0){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[L]);
                    integers.add(nums[R]);
                    list.add(integers);
                    //若左值等于左+1的值 直接跳过
                    while (L<R && nums[L+1]==nums[L]) L++;
                    //若右值等于右-1的值 直接跳过
                    while (L<R && nums[R-1]==nums[R]) R--;
                    //对应位置左移右移 寻找其他解
                    L++;
                    R--;
                }else if (temp < 0){//如果和小于0  则将向左移动
                    L++;
                }else {//如果和大于0 则将向右移动
                    R--;
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (nums[i] >0) return res;
            if (i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = nums.length-1;
            while (left<right){
                if (nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(new ArrayList<>(temp));
                    while (left<right && nums[left+1] == nums[left]) left++;
                    while (left<right && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
