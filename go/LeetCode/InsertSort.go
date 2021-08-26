package main

func main() {
	nums := []int{5,1,3,8,2}
	insertSort(nums)
	print(nums)
}

func insertSort(nums []int)  {
	len := len(nums)
	for i:=1;i<len;i++ {
		for j:=i;j>0 && nums[j]< nums[j-1];j-- {
			swap2(nums, j, j-1)
		}
	}
}

func swap2(nums []int, i, j int)  {
	temp := nums[i]
	nums[i] = nums[j]
	nums[j] = temp
}
