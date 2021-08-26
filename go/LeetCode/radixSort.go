package main

func main() {
	nums := []int{34,12,6,45,97,75,123,634}
	radixSort(nums,3)
	print(nums)
}

func radixSort(nums []int, d int)  {
	k := 0
	n := 1
	m := 1
	len := len(nums)
	temp := make([][]int, 10)
	for i := range temp{
		temp[i] = make([]int, len)
	}
	
	order := make([]int, 10)

	for m<=d {
		for i:=0;i<len;i++ {
			lsd := (nums[i]/n)%10
			temp[lsd][order[lsd]] = nums[i]
			order[lsd]++
		}

		for i:=0;i<10;i++ {
			if order[i] != 0 {
				for j:=0;j<order[i];j++ {
					nums[k] = temp[i][j]
					k++
				}
			}
			order[i] = 0
		}
		m++
		k=0
		n=n*10
	}
}
