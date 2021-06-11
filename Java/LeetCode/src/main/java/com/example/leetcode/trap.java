package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/20 9:10
 * @description
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class trap {

    public static void main(String[] args) {
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = new int[]{};
//        int[] height = new int[]{4,2,3};
//        int[] height = new int[]{4,2,0,3,2,5};
//        int[] height = new int[]{4,3,3,9,3,0,9,2,8,3}; //23
        System.out.println(trap1(height));
    }

    //暴力破解
    //遍历数组 从当前索引i 分别向前向后遍历取两个高度最大值  最后再取两者的最小值 减去 当前索引的高度
    public static int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i=1;i<size-1;i++){
            int maxLeft =0;
            int maxRight = 0;
            //取当前索引 i 左边的最大高度
            for (int j=i;j>=0;j--){
                maxLeft = Math.max(maxLeft, height[j]);
            }
            //取当前索引 i 右边的最大高度
            for (int j=i;j<size;j++){
                maxRight = Math.max(maxRight,height[j]);
            }
            //累加 取左右两边最小的高度减去当前索引的高度
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    //动态规划  提前存储left和right的最大值数组 一次遍历即可
    public static int trap1(int[] height) {
    int ans = 0;
    int size = height.length;
    //定义左右最大值数组
    int[] left = new int[size];
    int[] right = new int[size];
    //赋值左第一个值
    left[0] = height[0];
    //遍历数组获取每个索引 i 对应的左边最大值
    for (int i=1;i<size;i++){
        left[i] = Math.max(height[i], left[i-1]);
    }
    //赋值右最后一个值
    right[size-1] = height[size-1];
    //遍历数组获得 每个索引 i 对应的右边最大值
    for (int i=size-2;i>=0;i--){
        right[i] = Math.max(height[i],right[i+1]);
    }
    //最后遍历数组 取当前索引下左右的最小值  减去 当前索引的高度
    for (int i=1;i<size-1;i++){
        ans += Math.min(left[i],right[i]) - height[i];
    }
    return ans;
    }

    //双指针法
    public static int trap2(int[] height) {
        //定义左右指针
        int left=0;
        int right = height.length-1;
        //定义左右最大值
        int letf_max=0;
        int right_max=0;
        int ans=0;
        //循环结束条件 左指针大于等于右指针
        while (left<right){
            //当左边高度小于右边时 遍历左边 否则遍历右边
            if (height[left]<height[right]){
                //判断left是否最大高度  是则累加结果 否则 替换left_max left++
                if (height[left] >= letf_max){
                    letf_max=height[left];
                }else {
                    ans +=letf_max-height[left];
                }
                left++;
            }else {
                //判断right是否最大高度  是则累加结果 否则 替换right_max right--
                if (height[right]>=right_max){
                    right_max = height[right];
                }else {
                    ans += right_max-height[right];
                }
                right--;
            }
        }
        return ans;
    }

}
