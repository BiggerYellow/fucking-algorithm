package main

func main() {
	nums := []int{1,3,4,6,7,9}
	print(binarySearch(nums,4))
}

func binarySearch(nums []int, target int) int {
	left:=0
	right:=len(nums)-1
	for left<=right {
		mid :=left+(right-left)/2
		if nums[mid]==target {
			return mid
		}else if nums[mid]>target {
			right = mid-1
		}else {
			left = mid+1
		}
	}
	return -1
}
