package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/17 10:10
 * @description
 */
public class quickSort {
    public static void main(String[] args) {
        int[] nums = {1,3,2,7,5,2,5};
        quick3way(nums, 0, nums.length-1);
        System.out.println(nums);
    }

    public static void quickSort(int[] nums, int left, int right){
        if (left< right){
            int base = division(nums, left, right);
            quickSort(nums, left, base-1);
            quickSort(nums, base+1, right);
        }
    }

    public static int division(int[] nums, int left, int right){
        int base = nums[left];
        while (left<right){
            while (left<right && nums[right]>=base){
                right--;
            }
            nums[left] = nums[right];
            while (left<right && nums[left]<=base){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left]=base;
        return left;
    }

    public static void quickSort1(int[] nums, int left, int right){
        if (right <= left) return;
        int base = division1(nums, left, right);
        quickSort1(nums, left, base-1);
        quickSort1(nums, base+1, right);
    }

    public static int division1(int[] nums, int left, int right){
        int i=left, j=right+1;
        int base = nums[i];
        while (true){
            while (base >= nums[++i]){
                if (i==right){
                    break;
                }
            }
            while (base <= nums[--j]){
                if (j==left){
                    break;
                }
            }
            if (i>=j){
                break;
            }
            exchange(nums, i, j);
        }
        exchange(nums, left, j);
        return j;
    }

    public static void exchange(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void quick3way(int[] nums, int lo, int hi){
        if (hi<=lo){
            return;
        }
        int lt=lo, i=lo+1,gt=hi;
        int v = nums[lo];
        while (i<=gt){
            if (nums[i]<v){
                exchange(nums, lt++,i++);
            }else if (nums[i]>v){
                exchange(nums, i, gt--);
            }else {
                i++;
            }
        }
        quick3way(nums, lo, lt-1);
        quick3way(nums,gt+1, hi);
    }
}
