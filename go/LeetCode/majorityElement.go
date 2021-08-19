package main

func main() {
	
}

func majorityElement(nums []int) int {
	candidate := -1
	count := 0
	for _,v := range nums{
		if count == 0 {
			candidate = v
		}
		if v == candidate {
			count++
		}else {
			count--
		}
	}

	count=0
	for _,v := range nums{
		if v==candidate {
			count++
		}
	}
	if count*2 >= len(nums) {
		return candidate
	}else {
		return -1
	}
}
