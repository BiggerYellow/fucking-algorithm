package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/24 9:16
 * @description
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] nums = {7,2,4,9,5,1};
        mergeSort1(nums);
        System.out.println(nums);
    }

    public static int[] temp;

    public static void mergeSort(int[] nums){
        temp = new int[nums.length];
        sort(nums, 0, nums.length-1);
    }

    public static void sort(int[] nums, int lo, int hi){
        if (hi<=lo){
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(nums, lo, mid);
        sort(nums, mid+1, hi);
        merge(nums, lo, mid, hi);
    }

    public static void merge(int[] nums, int lo, int mid, int hi){
        int i=lo, j=mid+1;
        for (int k=lo;k<=hi;k++){
            temp[k] = nums[k];
        }
        for (int k=lo;k<=hi;k++){
            if (i>mid){
                nums[k] = temp[j++];
            }
            else if (j>hi) {
                nums[k] = temp[i++];
            }else if (temp[j]<temp[i]){
                nums[k] = temp[j++];
            }else {
                nums[k] = temp[i++];
            }
        }
    }

    public static void mergeSort1(int[] nums){
        int len = nums.length;
        temp  = new int[len];
        for (int sz = 1;sz<len;sz = sz+sz){
            for (int lo=0;lo<len-sz;lo += sz+sz){
                merge(nums, lo, lo+sz-1, Math.min(lo+sz+sz-1, len-1));
            }
        }
    }
}
