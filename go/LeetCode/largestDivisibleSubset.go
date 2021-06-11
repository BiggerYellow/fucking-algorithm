package main

import (
	"fmt"
	"sort"
)

func main() {
	nums := []int{3,4,16,8}
	fmt.Print(largestDivisibleSubset(nums))
}

func largestDivisibleSubset(nums []int) []int {
	sort.Ints(nums)
	dp:=make([]int, len(nums))
	prev:=make([]int, len(nums))
	for i,_ := range dp{
		dp[i] = 1
	}
	for i,_ := range prev{
		prev[i] = -1
	}
	max := 1
	maxIndex := 0
	for i:=1;i<len(nums);i++ {
		for j:=0;j<i;j++ {
			if nums[i]%nums[j]==0 && dp[i]<dp[j]+1{
				dp[i] = dp[j]+1
				prev[i] = j
			}
			if dp[i] > max {
				max = dp[i]
				maxIndex = i
			}
		}
	}

	res := []int{}
	for maxIndex != -1 {
		res = append(res, nums[maxIndex])
		maxIndex = prev[maxIndex]
	}
	return res
}
