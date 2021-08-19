package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/13 11:06
 * @description 冒泡排序 O(n^2)
 */
public class bubble {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,4};
        bubbleSort2(nums);
        System.out.println(nums);
    }

    public static void bubbleSort(int[] nums){
        int len = nums.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len-1;j++){
                if (nums[i] > nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] num){
        int temp;
        boolean flag = true;
        for (int i = 0; i< num.length - 1; i++ ){
            for (int j = num.length -1; j>i; j--){
                if (num[j-1]> num[j]){
                    temp = num[j-1];
                    num[j-1] = num[j];
                    num[j] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static void bubbleSort2(int[] nums){
        int temp;
        for (int i = 0; i< nums.length - 1; i++ ){
            for (int j = nums.length -1; j>i; j--){
                if (nums[j-1]> nums[j]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
