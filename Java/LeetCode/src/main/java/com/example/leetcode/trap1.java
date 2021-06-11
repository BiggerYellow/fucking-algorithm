package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/4/2 9:17
 * @description
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class trap1 {
    public static void main(String[] args) {
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = new int[]{2,0,2};
//        int[] height = new int[]{};
        System.out.println(trap2(height));
    }

    //暴力法 遍历数组 然后从当前索引分别向前向后搜索 找到两个最大值 然后在取两个中的最小值减去当前索引的高度
    public static int trap(int[] height) {
        int res=0;
        for (int i=1;i<height.length;i++){
            //向前搜索
            int maxleft = 0;
            for (int m=i;m>=0;m--){
                maxleft = Math.max(maxleft, height[m]);
            }
            //向后搜索最大值
            int maxRight = 0;
            for (int n=i;n<height.length;n++){
                maxRight = Math.max(maxRight, height[n]);
            }
            if (Math.min(maxleft, maxRight) > height[i]){
                res += Math.min(maxleft, maxRight) - height[i];
            }
        }
        return res;
    }

    //根据暴力法可知 是通过当前位置的左边最大值和右边最大值的最小值 减去当前位置
    //动态规划dp方程可以理解为 创建left和right的最大值数组 然后在遍历原数组 取两个dp数组中的最小值减去当前高度
    public static int trap1(int[] height) {
        if (height.length == 0) return 0;
        int res=0;
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        //左边最大值处理
        left[0] = height[0];
        for (int i=1;i<len;i++){
            left[i] = Math.max(height[i], left[i-1]);
        }
        //右边最大值处理
        right[len-1] = height[len-1];
        for (int i=len-2;i>=0;i--){
            right[i] = Math.max(height[i], right[i+1]);
        }

        for (int i=1;i<len-1;i++){
            res+=(Math.min(left[i], right[i])) - height[i];
        }
        return res;
    }

    //双指针解法  即每次取判断左指针和左边最大值的差值 或 右指针和右边最大值的差值
    //定义左右指针和左右两边的最大值
    public static int trap2(int[] height) {
        if (height.length == 0) return 0;
        int res=0;
        //定义左右指针
        int left=0;
        int right=height.length-1;
        //定义左右边的最大值
        int leftMax=0;
        int rightMax=0;
        //当左指针大于右指针时退出
        while (left<right){
            //哪边高度低就处理哪边
            if (height[left] < height[right]){
                //如果当前左指针高度大于左边最大值 则更新左边最大值 否则求差值
                if (height[left] > leftMax){
                    leftMax = height[left];
                }else {
                    res += leftMax - height[left];
                }
                left++;
            }else {
                //如果当前右指针高度大于右边最大值 则更新右边最大值 否则求差值
                if (height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    res += rightMax-height[right];
                }
                right--;
            }
        }
        return res;
    }
}
