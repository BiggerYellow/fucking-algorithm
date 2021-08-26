package main

func main() {
	nums := []int{4,1,6,5,9}
	heapSort(nums)
	for _,v :=range nums{
		print(v)
	}
}

func heapSort(nums []int) []int {
	len := len(nums)
	for i:=len/2;i>=0;i-- {
		sink(nums, i, len)
	}
	for len>1 {
		len -=1
		swap(nums, 0, len)
		sink(nums, 0 ,len)
	}
	return nums
}

func sink(nums []int, k int, len int)  {
	for 2*k+1<len {
		j:=2*k+1
		for j+1<len && nums[j+1]>nums[j] {
			j++
		}
		if nums[k]> nums[j] {
			break
		}
		swap(nums, j, k)
		k=j
	}
}

func swap(nums []int, i int, j int)  {
	temp := nums[i]
	nums[i] = nums[j]
	nums[j] = temp
}
