package main

func main() {
	nums := []int{5,1,2,9,6}
	selectSort(nums)
	print(nums)
}

func selectSort(nums []int)  {
	len := len(nums)
	for i:=0;i<len;i++ {
		min:=i
		for j:=i+1;j<len;j++ {
			if nums[min]>nums[j] {
				min = j
			}
		}
		swap1(nums, min, i)
	}
}

func swap1(nums []int, i int, j int){
	temp := nums[i]
	nums[i] = nums[j]
	nums[j] = temp
}
