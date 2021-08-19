package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/11 11:53
 * @description
 */
public class heapSort {
    public static void main(String[] args) {
        int[] nums = {2,5,3,7,6};
        int[] heapsort = heapsort1(nums);
        System.out.println(heapsort);
    }

    //头节点从1开始 即左节点为2*i 右节点 2*i+1
    public static int[] heapsort(int[] nums){
        int len =nums.length;
        int[] temp = new int[len+1];
        for (int i=0;i<len;i++){
            temp[i+1] = nums[i];
        }

        for (int i=len/2;i>=1;i--){
            sink(temp, i, len);
        }

        int k=len;
        while (k>1){
            swap(temp, 1, k--);
            sink(temp,1,k);
        }
        for (int i=1;i<len+1;i++){
            nums[i-1] = temp[i];
        }
        return nums;
    }

    public static void sink(int[] nums, int k, int end){
        while (2*k <= end){
            int j=2*k;
            if (j+1<=end && nums[j+1] > nums[j]){
                j++;
            }
            if (nums[j]<nums[k]){
                break;
            }
            swap(nums, j, k);
            k=j;
        }
    }


    //头节点从0开始 即左节点为2*i+1 右节点 2*i+2
    public static int[] heapsort1(int[] nums){
        int len =nums.length;

        for (int i=len/2-1;i>=0;i--){
            sink1(nums, i, len);
        }


        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=nums.length-1;j>0;j--){
            swap(nums,0,j);//将堆顶元素与末尾元素进行交换
            sink1(nums,0,j);//重新对堆进行调整
        }
//        while (len>0){
//            --len;
//            swap(nums, 0, len);
//            sink1(nums,0,len);
//        }
        return nums;
    }

    public static void sink1(int[] nums, int k, int end){
        while (2*k+1 < end){
            int j=2*k+1;
            if (j+1<end && nums[j+1] > nums[j]){
                j++;
            }
            if (nums[j]<nums[k]){
                break;
            }
            swap(nums, j, k);
            k=j;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
