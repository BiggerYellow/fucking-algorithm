package main

import "sort"

func main() {
	
}

func minPairSum(nums []int) int{
	sort.Ints(nums)
	length := len(nums)
	res := 0
	for i:=0;i<length/2;i++ {
		res = max124(res, nums[i]+nums[length-1-i])
	}
	return res
}

func max124(x int, y int) int {
	if x<y {
		return y
	}
	return x
}