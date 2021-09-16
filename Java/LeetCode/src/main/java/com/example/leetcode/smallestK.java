package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/9/3 0:00
 * @description
 * 面试题 17.14. Smallest K LCCI
 * Design an algorithm to find the smallest K numbers in an array.
 *
 * Example:
 *
 * Input:  arr = [1,3,5,7,2,4,6,8], k = 4
 * Output:  [1,2,3,4]
 * Note:
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class smallestK {
    public static void main(String[] args) {
        int[] nums ={1,3,5,7,-5,2,4,6,8};
//        int[] nums ={ 62577,-220,-8737,-22,-6,59956,5363,-16699,0,-10603,64,-24528,-4818,96,5747,2638,-223,37663,-390,35778,-4977,-3834,-56074,7,-76,601,-1712,-48874,31,3,-9417,-33152,775,9396,60947,-1919,683,-37092,-524,-8,1458,80,-8,1,7,-355,9,397,-30,-21019,-565,8762,-4,531,-211,-23702,3,3399,-67,64542,39546,52500,-6263,4,-16,-1,861,5134,8,63701,40202,43349,-4283,-3,-22721,-6,42754,-726,118,51,539,790,-9972,41752,0,31,-23957,-714,-446,4,-61087,84,-140,6,53,-48496,9,-15357,402,5541,4,53936,6,3,37591,7,30,-7197,-26607,202,140,-4,-7410,2031,-715,4,-60981,365,-23620,-41,4,-2482,-59,5,-911,52,50068,38,61,664,0,-868,8681,-8,8,29,412};
        int[] ints = smallestK1(nums, 4);
        System.out.println(ints);
    }

    public static int[] smallestK1(int[] arr, int k){
        int[] res = new int[k];
        for (int num:arr){
            if (res[0]< num){
                res[0] = num;
                sink(res, 0, k);
            }
        }
        return res;
    }

    public static void sink(int[] arr, int k, int end){
        while (2*k+1 < end){
            int j = 2*k+1;
            while (j+1<end && arr[j+1]>arr[j]){
                j++;
            }
            if (arr[j] < arr[k]){
                break;
            }
            swap(arr,j, k);
            k=j;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length-1);
        int[] res = new int[k];
        for (int i=0;i<k;i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void quickSort(int[] nums, int start, int end){
        if (start<end){
            int base = divison(nums, start, end);
            quickSort(nums, start, base-1);
            quickSort(nums, base+1, end);
        }
    }

    public static int divison(int[] nums, int start, int end){
        int base = nums[start];
        while (start<end){
            while (start<end && nums[end]>=base){
                end--;
            }
            nums[start] = nums[end];
            while (start<end && nums[start]<=base){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = base;
        return start;
    }


}
