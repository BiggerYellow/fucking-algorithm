package main

func main() {
	nums:=[]int{3,1,2,7,5}
	quickSort(nums, 0, len(nums)-1)
	print(nums)
}

func quickSort(nums []int, left int, right int)  {
		var division func(nums []int, left int, right int) int
		division = func(nums []int, left int, right int) int {
			base := nums[left]
			for left<right {
				for left<right && nums[right]>=base {
					right--
				}
				nums[left] = nums[right]
				for left<right && nums[left]<=base {
					left++
				}
				nums[right] = nums[left]
			}
			nums[left]=base
			return left
		}

		if left<right {
			temp:=division(nums, left, right)
			quickSort(nums, left, temp-1)
			quickSort(nums, temp+1, right)
		}
}
