package main

func main() {
	nums:=[]int{3,1,2,7,5}
	quickSort1(nums, 0, len(nums)-1)
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

func quickSort1(nums []int, left int, right int)  {
	var swap func(nums []int, i int, j int)
	swap = func(nums []int, i int, j int) {
		temp :=nums[i]
		nums[i] = nums[j]
		nums[j] = temp
	}
	var division func(nums []int, left int, right int) int
	division = func(nums []int, left int, right int) int {
		base:=nums[left]
		i:=left+1
		j:=right
		for true {
			for base>=nums[i] {
				i++
				if i==right {
					break
				}
			}
			for base<=nums[j] {
				j--
				if j==left {
					break
				}
			}
			if i>=j {
				break
			}
			swap(nums, i, j)
		}
		swap(nums, left, j)
		return j
	}
	if right<=left {
		return
	}
	base:=division(nums, left, right)
	quickSort1(nums, left, base-1)
	quickSort1(nums, base+1, right)
}
