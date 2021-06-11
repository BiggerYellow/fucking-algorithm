package com.example.labaladong;

/**
 * @author huangchunchen
 * @date 2021/5/13 13:20
 * @description
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,4,4,4,6,8,11,14,23};
        System.out.println(binarySearchRight(array, 3));
    }

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (array[mid] == target){
                return mid;
            }else if (array[mid] < target){
                left = mid + 1;
            }else if (array[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchLeft(int[] array, int target){
        int left = 0;
        int right = array.length;
        while (left < right){
            int mid = left + (right-left)/2;
            if (array[mid] == target){
                right = mid;
            }else if (array[mid] < target){
                left = mid +1;
            }else if (array[mid] > target){
                right = mid;
            }
        }
        if (left == array.length) return -1;
        return array[left] == target? left : -1;
    }

    public static int binarySearchRight(int[] array, int target){
        int left =0;
        int right = array.length;
        while (left<right){
            int mid = left + (right-left)/2;
            if (array[mid] == target){
                left = mid+1;
            }else if (array[mid] < target){
                left = mid+1;
            }else if (array[mid] > target){
                right = mid;
            }
        }
        if (left == 0) return -1;
        return array[left-1] == target? left-1:-1;
    }
}
