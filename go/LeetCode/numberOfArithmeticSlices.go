package main

func main() {
	
}

func numberOfArithmeticSlices(nums []int) int  {
	length := len(nums)
	if length==1 {
		return 0
	}

	diff:=nums[0]-nums[1]
	count:=0
	res:=0
	for i:=2;i<length;i++ {
		if nums[i-1]-nums[i]==diff {
			count++
		}else {
			diff = nums[i-1]-nums[i]
			count=0
		}
		res+=count
	}
	return res
}
