package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/2/8 9:05
 * @description
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxTurbulenceSize {
    public static void main(String[] args) {
        int[] arr = new int[]{9,4,2,10,7,8,8,1,9};
//        int[] arr = new int[]{4,8,12,16};
//        int[] arr = new int[]{9};
        System.out.println(maxTurbulenceSize2(arr));
    }

    //暴力破解 一次遍历
    public static int maxTurbulenceSize(int[] arr) {
        String flag =null;
        int res=1;
        int count=0;
        for (int i=0;i<arr.length-1;i++){
            //处理arr[i]和arr[i+1]相等的情况
            //重置计数器和标志位
            if (arr[i] == arr[i+1]) {
                count=0;
                flag = null;
                continue;
            }
            //当标志位位空时 比较大小并设置标志位，计数器++
            if (flag == null){
                if (arr[i] > arr[i+1]){
                    flag = ">";
                    count++;
                }else {
                    flag = "<";
                    count++;
                }

            }
            //当上一个标志位为 > 时,比较arr[i]和arr[i+1] 小于则计数器++并设置相反标志位
            //大于则重置计数器、索引前移一位，重置标志位
            else if (flag == ">"){
                if (arr[i] < arr[i+1]){
                    count++;
                    flag = "<";
                }else {
                    count=0;
                    i=i-1;
                    flag = null;
                }
            }
            //操作同上
            else if (flag == "<"){
                if (arr[i] > arr[i+1]){
                    count++;
                    flag = ">";
                }else {
                    count =0;
                    i=i-1;
                    flag = null;
                }
            }
            //每次取最大的值
            res = Math.max(res, count+1);
        }
        return res;
    }

    //双指针
    //当左右指针相同时且arr[riglt]==arr[right+1]，需要将left++和right++，否则只需要将right++
    //当左右指针不同时，根据定义
    //只有arr[right-1] > arr[right] && arr[right] < arr[right+1] 和 arr[right-1] < arr[right] && arr[right] > arr[right+1]时才能将right++  否则将left指针移动到right指针处
    public static int maxTurbulenceSize1(int[] arr) {
        int res =1;
        int left = 0, right =0;
        //遍历数组
        while (right < arr.length-1){
            //处理位置相同时是否移动
            if (right == left){
                if (arr[right] == arr[right+1]){
                    left++;
                }
                right++;

            }else {
                //当arr[right-1] > arr[right] && arr[right] < arr[right+1]时 right++
                if (arr[right-1] > arr[right] && arr[right] < arr[right+1]){
                    right++;
                }
                //当arr[right-1] < arr[right] && arr[right] > arr[right+1]时，right++
                else if (arr[right-1] < arr[right] && arr[right] > arr[right+1]){
                    right++;
                }else {
                    //都不满足条件时将left指针移动到right指针处
                    left = right;
                }
            }
            //取每次移动的最大值
            res = Math.max(res, right-left+1);
        }
        return res;
    }

    //动态规划
    //定义两个数组up存放向上递增的 down存储向下递减的
    //初始值都为1 即 up[0]=1 down[0]=1
    //当 i>0 && arr[i-1] < arr[i] 时 up[i] = down[i-1] + 1 对应的down[i]就为1
    //当 i>0 && arr[i-1] > arr[i] 时 down[i] = up[i-1] + 1 对应的up[i]就为1
    //当 i>0 && arr[i] = arr[i+1] 时 down[i] = up[i-1] = 1
    public static int maxTurbulenceSize2(int[] arr) {
        int n = arr.length;
        int res =1;
        //定义dp数组并定义初始值为1
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] =1;
        down[0] = 1;
        //遍历数组
        for (int i=1;i<n;i++){
            //当arr[i-1]<arr[i]时  up[i] = down[i-1]+1
            if (arr[i-1] < arr[i]){
                up[i] = down[i-1]+1;
                down[i]=1;
            }
            //当arr[i-1]>arr[i]时  down[i] = up[i-1]+1
            else if (arr[i-1] > arr[i]){
                down[i] = up[i-1]+1;
                up[i]=1;
            }
            //当arr[i-1]==arr[i]时  up[i] = down[i-1] = 1
            else {
                up[i]=1;
                down[i]=1;
            }
            //更新最大长度
            res = Math.max(res, Math.max(up[i], down[i]));
        }
        return res;
    }


}
