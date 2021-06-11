package main

import "fmt"

func main() {
	nums := []int{4,14,2}
	fmt.Print(totalHammingDistance(nums))
}

func totalHammingDistance(nums []int) int {
	n:=len(nums)
	res:=0
	for i:=0;i<31;i++ {
		temp:=0
		for _,v := range nums{
			temp+=(v>>i)&1
		}
		res+=temp*(n-temp)
	}
	return res
}
