package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/6/15 9:05
 * @description
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 *
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class peakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        System.out.println(peakIndexInMountainArray1(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i=1;i<arr.length;i++){
            if (arr[i] < arr[i-1]){
                return i-1;
            }
        }
        return 0;
    }

    //当 i<i(ans)时, arr[i]<arr[i+1]
    //当 i>i(ans)时, arr[i]>arr[i+1]
    public static int peakIndexInMountainArray1(int[] arr) {
        int n=arr.length;
        int left=1;
        int right=n-2;
        int res=0;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid] > arr[mid+1]){
                res=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return res;
    }
}
