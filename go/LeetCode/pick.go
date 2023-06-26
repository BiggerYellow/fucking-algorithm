package main

import "math/rand"

type Solution []int

func Constructor1(nums []int) Solution {
	return nums
}

func (nums Solution) Pick(target int) (res int) {
	count:=0
	for i, num := range nums{
		if num == target {
			count++
			if rand.Intn(count) == 0 {
				res = i
			}
		}
	}
	return
}

func SelectK(nums []int, k int) (res []int) {
	for i:=0;i<k;i++{
		res[i] = nums[i]
	}
	count:=k
	i:=k
	for i<len(nums) {
		count++
		j := rand.Intn(count)
		if j < k{
			res[j] = nums[i]
		}
	}
	return res
}