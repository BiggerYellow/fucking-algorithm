package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/4/8 9:11
 * @description
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 4 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * 示例 3：
 *
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findMin {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2};
//        int[] nums = new int[]{4,5,1,2,3};
//        int[] nums = new int[]{5,1,2,3,4};
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(findMin1(nums));
    }

    //二分查找 使用start和mid比较
    //找到退出条件  1.start<mid<end 即递增 结果为 nums[left]
    //             2. mid正好在结果位置 将left=mid
    // 先判断退出条件1
    // 当nums[start] < nums[mid] 舍弃mid左边
    // 当nums[start] > nums[mid] 舍弃mid右边
    // 最后判断退出条件2
    public static int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int start=0;
        int end = len-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (nums[start] <= nums[mid] && nums[mid] <= nums[end]){
                break;
            }
            if (nums[start] <= nums[mid]) {
                start = mid+1;
            }else {
                end = mid-1;
            }
            if (nums[start] >= nums[mid] && nums[mid] <= nums[end]){
                start = mid;
                break;
            }
        }
        return nums[start];
    }

    //二分法 mid与end比较
    //当nums[mid] < nums[end]时 代表可以舍弃mid右半边 使end=mid
    //当nums[mid] > nums[end]时 代表可以舍弃mid左半边 使start=mid+1
    //最后的nums[end]即是结果
    public static int findMin1(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (nums[mid] < nums[end]){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return nums[end];
    }
}
