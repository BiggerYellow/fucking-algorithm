package main

import "fmt"

func main() {
	nums := []int{0,0,1,1,1,1,2,3,3}
	fmt.Print(removeDuplicates2(nums))
}
func removeDuplicates2(nums []int) (res int) {
	if len(nums) <= 2 {
		return len(nums)
	}
	slow :=2
	fast :=2
	for fast < len(nums) {
		if nums[slow-2] != nums[fast] {
			nums[slow] = nums[fast]
			slow++
		}
		fast++
	}
	return slow
}
