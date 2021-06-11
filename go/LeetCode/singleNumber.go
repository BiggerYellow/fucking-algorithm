package main

import "fmt"

func main() {
	nums := []int{1,1,1,3}
	fmt.Print(singleNumber1(nums))
}

func singleNumber(nums []int) int {
	count := make(map[int]int)

	for _,k :=range nums{
		count[k]++
	}

	res := 0
	for k,v :=range count{
		if v == 1 {
			res = k
			break
		}
	}
	return res
}

func singleNumber1(nums []int) int32 {
	res := int32(0)
	for i:=0;i<32;i++{
		total := int32(0)
		for _,num := range nums{
			total += (int32(num) >> i) &1
		}
		if total%3 == 1 {
			res |= 1<<i
		}
	}
	return res
}
