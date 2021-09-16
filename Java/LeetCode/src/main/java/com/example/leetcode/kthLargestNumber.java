package com.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangchunchen
 * @date 2021/8/29 11:13
 * @description
 * 5855. 找出数组中的第 K 大整数 显示英文描述
 * 通过的用户数1787
 * 尝试过的用户数2442
 * 用户总通过次数1795
 * 用户总提交次数4207
 * 题目难度Medium
 * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 *
 * 返回 nums 中表示第 k 大整数的字符串。
 *
 * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = ["3","6","7","10"], k = 4
 * 输出："3"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 * 其中第 4 大整数是 "3"
 * 示例 2：
 *
 * 输入：nums = ["2","21","12","1"], k = 3
 * 输出："2"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
 * 其中第 3 大整数是 "2"
 * 示例 3：
 *
 * 输入：nums = ["0","0"], k = 2
 * 输出："0"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["0","0"]
 * 其中第 2 大整数是 "0"
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * 1 <= nums[i].length <= 100
 * nums[i] 仅由数字组成
 * nums[i] 不含任何前导零
 */
public class kthLargestNumber {
    public static void main(String[] args) {
//        String[] nums = {"3","6","7","10"};
        String[] nums = {"2","21","12","1"};
        System.out.println(kthLargestNumber1(nums, 3));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()<o2.length()){
                    return -1;
                }else if (o1.length()>o2.length()){
                    return 1;
                }else {
                    int length = o1.length();
                    for (int i=length-1;i>=0;i--){
                        if (o1.charAt(i) > o2.charAt(i)){
                            return -1;
                        }
                    }
                    return 1;
                }
            }
        });
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(((o1, o2) -> {
            if (o1.length()<o2.length()){
                return -1;
            }else if (o1.length()>o2.length()){
                return 1;
            }else {
                int length = o1.length();
                for (int i=length-1;i>=0;i--){
                    if (o1.charAt(i) > o2.charAt(i)){
                        return -1;
                    }
                }
             return 1;
            }
        }));
        for (String num:nums){
            priorityQueue.offer(num);
        }
        int count = len-k;
        while (count>0){
            priorityQueue.poll();
            count--;
        }
        return priorityQueue.poll();
    }


    public static String kthLargestNumber1(String[] nums, int k) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int count = len-k;
        quickSort(nums, 0, len-1);
        return nums[count];
    }

    public static void quickSort(String[] nums, int left, int right){
        if (left< right){
            int base = division(nums, left, right);
            quickSort(nums, left, base-1);
            quickSort(nums, base+1, right);
        }
    }

    public static int division(String[] nums, int left, int right){
        String base = nums[left];
        while (left<right){
            while (left<right && compare(nums[right], base)){
                right--;
            }
            nums[left] = nums[right];
            while (left<right && !compare(nums[left], base)){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left]=base;
        return left;
    }

    public static boolean compare(String o1, String o2){
        if (o1.length()<o2.length()){
            return false;
        }else if (o1.length()>o2.length()){
            return true;
        }else {
            int length = o1.length();
            for (int i=length-1;i>=0;i--){
                if (o1.charAt(i) > o2.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }
}
