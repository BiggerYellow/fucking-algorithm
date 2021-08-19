package main

func main() {
	
}

func search1(nums []int, target int) int {
	i:=0
	j:=len(nums)-1
	for i<=j {
		mid:=i+(j-i)/2
		if nums[mid] <= target {
			i = mid+1
		}else {
			j=mid-1
		}
	}
	right:=i
	if j>=0 && nums[j] != target {
		return 0
	}
	i=0
	j=len(nums)-1
	for i<j {
		mid:=i+(j-i)/2
		if nums[mid]<target {
			i=mid+1
		}else {
			j=mid-1
		}
	}
	left:=j
	return right-left-1
}