package main

import "sort"

func main() {
	
}

func maxFrequency(nums []int,k int) int {
	sort.Ints(nums)
	res:=1
	count:=0
	left:=0
	for right:=1;right<len(nums);right++ {
		count+= (nums[right]-nums[right-1])*(right-left)
		for count>k {
			count -= nums[right]-nums[left]
			left+=1
		}
		res = max123(res, right-left+1)
	}
	return res
}

func max123(x int, y int) int {
	if x>y {
		return x
	}else {
		return y
	}
}