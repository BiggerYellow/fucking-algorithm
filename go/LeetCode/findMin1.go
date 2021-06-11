package main

func main() {
	
}
func findMix(nums []int) int {
	start := 0
	end := len(nums)-1
	for start<end {
		mid := (start+end)/2
		if nums[mid] < nums[end]{
			end = mid
		}else if nums[mid] == nums[end] {
			end--
		}else {
			start = mid+1
		}
	}
	return nums[end]
}
