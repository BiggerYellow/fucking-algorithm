package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/8/10 9:30
 * @description
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numberOfArithmeticSlices {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices1(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len <=2) return 0;
        int[] diff = new int[len-1];
        for (int i=1;i<len;i++){
            diff[i-1] = nums[i] - nums[i-1];
        }

        int res=0;
        int pre=diff[0];
        int length=1;
        for (int i=1;i<len-1;i++){
            if (diff[i] == pre){
                length++;
            }else {
                res+=count(length);
                pre = diff[i];
                length=1;
            }
        }
        return res+=count(length);
    }

    public static int count(int n){
        if (n==1) return 0;
        if (n%2==1){
            return n*(n/2);
        }else {
            return n*n/2-n/2;
        }
    }


    public static int numberOfArithmeticSlices1(int[] nums) {
        int len = nums.length;
        if (len==1)return 0;
        int diff =nums[0]-nums[1];
        int count=0;
        int res=0;
        for (int i=2;i<len;i++){
            if (nums[i-1]-nums[i]==diff){
                count++;
            }else {
                diff = nums[i-1]-nums[i];
                count=0;
            }
            res+=count;
        }
        return res;
    }

}
