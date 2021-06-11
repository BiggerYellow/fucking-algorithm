package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/12/2 9:34
 * @description
 *
 *给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] heigth = new int[]{1,8,6,2,5,4,8,3,7};
//        int[] heigth = new int[]{1,1};
//        int[] heigth = new int[]{4,3,2,1,4};
//        int[] heigth = new int[]{1,2,1};
        System.out.println(maxArea1(heigth));
    }

    public static int maxArea(int[] height){
        int max = 0;
        if (height.length == 1) return height[0];
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int minHeight = height[i] >= height[j] ? height[j]:height[i];
                int temp = (j-i)*minHeight;
                max = temp>=max?temp:max;
            }
        }
        return max;
    }

    public static int maxArea1(int[] height){
        int i=0;
        int j=height.length-1;
        int max=0;
        while (i<j){
            int area = (j-i)*Math.min(height[i], height[j]);
            max = Math.max(max, area);
            if (height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
