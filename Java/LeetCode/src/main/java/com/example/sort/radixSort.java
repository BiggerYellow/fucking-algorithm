package com.example.sort;

/**
 * @author huangchunchen
 * @date 2021/8/25 9:21
 * @description
 */
public class radixSort {
    public static void main(String[] args) {
        int[] nums = {1,42,756,23,115,86,54};
        radixSort(nums, 3);
        System.out.println(nums);
    }

    public static void radixSort(int[] nums, int d){
        //每次排序使用的索引
        int k=0;
        //表明取的第几位数
        int n=1;
        //表明当前正在排序第几位数
        int m=1;
        int len = nums.length;

        //temp i存放0-9 j存放对应的值
        //例如 给定 nums[20] 那么 temp[0][1] = 20
        int[][] temp = new int[10][len];
        //存放0-9每个位置有多少个值 用于temp找到nums中的元素
        int[] order = new int[10];

        //m从1开始一直处理到d
        while (m<=d){
            //首轮遍历 填充temp和order
            //1. 首先先计算出最低位 lsd
            //2. 然后根据lsd的值将nums填充到temp指定的位置,并将order对应lsd位置加一
            for (int i=0;i<len;i++){
                int lsd = (nums[i]/n)%10;
                temp[lsd][order[lsd]++] = nums[i];
            }

            //经过第一轮遍历 我们已经按照lsd将数组赋值到 temp中, 接下来进行排序
            //因为数字最多就是9位,所以第二轮遍历就是从0-9
            //只要order[i]还存在元素,即order[i]!=0, 那么我们就要遍历order[i],从temp中取到对应值即temp[i][j],并赋值到原始数组nums中. 最后要把order[i]置为0即尾数为i的全都处理完毕
            for (int i=0;i<10;i++){
                if (order[i] != 0){
                    for (int j=0;j<order[i];j++){
                        nums[k++] = temp[i][j];
                    }
                }
                order[i]=0;
            }
            //最后重置 k为0,即下次排序继续从0开始
            //n=n*10 表明取下一位数 个位-十位-百位
            //m+=1 表明处理到了第几位
            k=0;
            n=n*10;
            m+=1;
        }
    }
}
