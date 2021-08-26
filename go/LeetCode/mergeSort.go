package main

func main() {
	nums := []int{5,1,3,4,9,6}
	mergeSort(nums)
	print(nums)

}

//自顶向下归并排序
func mergeSort(nums []int){
	temp :=make([]int, len(nums))

	var merge func(nums []int, lo int, mid int, hi int)
	merge = func(nums []int, lo int, mid int, hi int) {
		i:=lo
		j:=mid+1
		for k:=lo;k<=hi;k++ {
			temp[k] = nums[k]
		}
		for k:=lo;k<=hi;k++{
			if i>mid {
				nums[k] = temp[j]
				j++
			}else if j>hi {
				nums[k] = temp[i]
				i++
			}else if temp[j]<temp[i] {
				nums[k] = temp[j]
				j++
			}else {
				nums[k] = temp[i]
				i++
			}
		}
	}

	var sort func(nums []int, lo int, hi int)
	sort = func(nums []int, lo int, hi int) {
		if hi<=lo {
			return
		}
		mid := lo+(hi-lo)/2
		sort(nums, lo, mid)
		sort(nums, mid+1, hi)
		merge(nums, lo, mid, hi)
	}

	sort(nums, 0, len(nums)-1)
}
