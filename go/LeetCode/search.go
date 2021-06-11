package main

import "fmt"

func main() {
	nums :=[]int{2,5,6,0,0,1,2}
	fmt.Print(search(nums, 0))
}

func search(nums []int, target int) bool {
	len := len(nums)
	if len==0 {
		return false
	}
	if len==1 && nums[0]==target {
		return true
	}
	start :=0
	end := len-1
	for start<=end {
		mid := (start+end)/2
		if nums[mid] == target {
			return true
		}
		if nums[start] == nums[end] {
			start++
			continue
		}
		if nums[start] <= nums[mid] {
			if nums[start] <= target && nums[mid] > target {
				end = mid-1
			}else {
				start = mid+1
			}
		}else {
			if nums[mid] <= target && nums[len-1] >target {
				start = mid+1
			}else {
				end = mid-1
			}
		}
	}
	return false
}