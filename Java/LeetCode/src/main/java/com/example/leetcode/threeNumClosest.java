package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/12/10 9:32
 * @description
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class threeNumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(threeNumClosest(nums, 1));
    }

    public static int threeNumClosest(int[] nums, int target){
        sort(nums);
        int res = nums[0] + nums[1]+nums[2];
        for (int i=0;i<nums.length;i++){
            int L = i+1;
            int R = nums.length-1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(target -sum) < Math.abs(target-res)){
                    res = sum;
                }
                if (sum > target){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return res;
    }

    public static void sort(int[] nums){
        int temp=0;
        for (int i=0;i<nums.length-1;i++){
            for (int j = nums.length-1; j>i; j--){
                if (nums[j-1] >nums[j]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
