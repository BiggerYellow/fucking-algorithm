package main

import "math"

func main() {
	
}

func rob1(nums []int) int {
	n:=len(nums)
	if n==1 {
		return nums[0]
	}
	dp :=make([]int, n)
	dp[0] = nums[0]
	dp[1] = int(math.Max(float64(nums[0]), float64(nums[1])))
	for i:=2;i<n;i++ {
		dp[i] = int(math.Max(float64(dp[i-2]+nums[i]), float64(dp[i-1])))
	}
	return dp[n-1]
}
