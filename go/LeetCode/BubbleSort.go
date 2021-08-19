package main

func main() {
	nums := []int{3,1,2,6,4}
	bubbleSort1(nums)
	print(nums)
}

//内部逆序
func bubbleSort(nums []int) {
	len :=len(nums)
	for i:=0;i<len-1;i++ {
		for j:=0;j<len-i-1;j++ {
			if nums[j+1]<nums[j] {
				temp:=nums[j]
				nums[j]=nums[j+1]
				nums[j+1]=temp
			}
		}
	}
}

func bubbleSort1(nums []int){
	len := len(nums)
	for i:=0; i<len;i++ {
		for j:=len-1;j>i;j-- {
			if nums[j] < nums[j-1] {
				temp:=nums[j]
				nums[j]=nums[j-1]
				nums[j-1]=temp
			}
		}
	}
}



