package main

import (
	"fmt"
	"math"
)

func main() {
	nums := []int{4,1,2,7,5,3,1}
	fmt.Print(rob(nums))
}

func rob(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	if len(nums) == 2 {
		return int(math.Max(float64(nums[0]), float64(nums[1])))
	}
	return int(math.Max(float64(doRob(nums, 0, len(nums)-1)), float64(doRob(nums, 1,len(nums)))))
}

func doRob(nums []int, start int, end int) int {
	first := nums[start]
	second := int(math.Max(float64(nums[start]), float64(nums[start+1])))
	for i:=start+2;i<end;i++ {
		temp:=second
		second = int(math.Max(float64(first+nums[i]), float64(second)))
		first = temp
	}
	return second
}

func rob2(nums []int) int{
	n:= len(nums)
	if n==1 {
		return nums[0]
	}
	dp:=make([][]int, n)
	for i:= range dp {
		dp[i] = make([]int, 2)
	}
	dp[0][0] = 0
	dp[0][1] = nums[0]
	dp[1][0] = nums[1]
	dp[1][1] = nums[0]

	for i:=2;i<n;i++ {
		dp[i][0] = max(dp[i-2][0] + nums[i], dp[i-1][0])
		if i==n-1 {
			dp[i][1] = dp[i-1][1]
		}else {
			dp[i][1] = max(dp[i-2][1] + nums[i], dp[i-1][1])
		}
	}
	return max(dp[n-1][0], dp[n-1][1])
}


func max(x int, y int) int {
	if x>=y {
		return x
	}else {
		return y
	}
}
