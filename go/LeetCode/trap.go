package main

import (
	"fmt"
	"math"
)

/**
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
 */
func main() {
	height:=[]int{0,1,0,2,1,0,1,3,2,1,2,1}
	//height:=[]int{2,0,2}
	//height:=[]int{}
	fmt.Print(trap2(height))
}

//暴力
func trap(height []int) (res int) {
	for i:=1;i<len(height);i++{
		leftMax :=0
		for m:=i;m>=0;m-- {
			leftMax = int(math.Max(float64(leftMax), float64(height[m])))
		}
		rightMax :=0
		for m:=i;m<len(height);m++ {
			rightMax = int(math.Max(float64(rightMax), float64(height[m])))
		}
		res+= int(math.Min(float64(rightMax), float64(leftMax))) - height[i]
	}
	return res
}

//动态
func trap1(height []int) (res int)  {
	if len(height) == 0 {
		return 0
	}
	left := make([]int, len(height))
	right:= make([]int, len(height))

	left[0] = height[0]
	for i:=1;i<len(height);i++{
		left[i] = int(math.Max(float64(height[i]), float64(left[i-1])))
	}
	right[len(height)-1] = height[len(height)-1]
	for i:=len(height)-2;i>=0;i-- {
		right[i] = int(math.Max(float64(height[i]),float64(right[i+1])))
	}

	for i,v :=range height{
		res+=int(math.Min(float64(left[i]), float64(right[i]))) - v
	}
	return res
}

//双指针
func trap2(height []int) (res int)  {
	if len(height) == 0 {
		return 0
	}
	left:=0
	right:=len(height)-1
	leftMax:=0
	rightMax:=0
	for left<right {
		if height[left] < height[right] {
			if leftMax > height[left] {
				res += leftMax - height[left]
			}else {
				leftMax = height[left]
			}
			left++
		}else {
			if rightMax > height[right] {
				res += rightMax - height[right]
			}else {
				rightMax = height[right]
			}
			right--
		}
	}
	return res
}
