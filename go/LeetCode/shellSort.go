package main

func main() {
	nums := []int{6,1,4,8,7,3}
	shellSort(nums)
	print(nums)
}

func shellSort(nums []int){
	len := len(nums)
	factor:=2
	h :=1
	for h<len/factor {
		h = h*factor+1
	}

	for h>=1 {
		for i:=h;i<len;i++ {
			for j:=i;j>=h && nums[j]<nums[j-h];j-=h {
				swap3(nums, j, j-h)
			}
		}
		h/=factor
	}
}

func swap3(nums []int, i,j int)  {
	temp := nums[i]
	nums[i] = nums[j]
	nums[j] = temp
}