package main

import "fmt"

func main() {
	nums := []int{3,4,5,1,2}
	fmt.Print(findMin1(nums))
	
}

func findMin(nums []int) (res int)  {
	start :=0
	end := len(nums)-1
	for start<=end {
		mid := (start+end)/2
		if nums[mid] < nums[end] {
			end = mid
		}else {
			start = mid+1
		}
	}
	return nums[end]
}

func findMin1(nums []int) int {
	start :=0
	end := len(nums)-1
	for start<=end {
		mid := (start+end)/2
		if nums[start] <= nums[mid] && nums[mid] <= nums[end] {
			break
		}
		if nums[start] <= nums[mid] {
			start = mid+1
		}else {
			end = mid-1
		}
		if nums[start] >= nums[mid] && nums[mid] <= nums[end] {
			start = mid
			break
		}
	}
	return nums[start]
}
