package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/17 10:10
 * @description
 */
public class quickSort {
    public static void main(String[] args) {
        int[] nums = {1,3,2,7,5};
//        int[] nums = { 62577,-220,-8737,-22,-6,59956,5363,-16699,0,-10603,64,-24528,-4818,96,5747,2638,-223,37663,-390,35778,-4977,-3834,-56074,7,-76,601,-1712,-48874,31,3,-9417,-33152,775,9396,60947,-1919,683,-37092,-524,-8,1458,80,-8,1,7,-355,9,397,-30,-21019,-565,8762,-4,531,-211,-23702,3,3399,-67,64542,39546,52500,-6263,4,-16,-1,861,5134,8,63701,40202,43349,-4283,-3,-22721,-6,42754,-726,118,51,539,790,-9972,41752,0,31,-23957,-714,-446,4,-61087,84,-140,6,53,-48496,9,-15357,402,5541,4,53936,6,3,37591,7,30,-7197,-26607,202,140,-4,-7410,2031,-715,4,-60981,365,-23620,-41,4,-2482,-59,5,-911,52,50068,38,61,664,0,-868,8681,-8,8,29,412};
        quickSort1(nums, 0, nums.length-1);
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
        int base = nums[left];
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
