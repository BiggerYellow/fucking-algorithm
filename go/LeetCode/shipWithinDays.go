package main

import "fmt"

func main() {
	weights := []int{1,2,3,4,5,6,7,8,9,10}
	fmt.Print(shipWithinDays(weights, 5))
	
}

func shipWithinDays(weights []int, D int) int {
	left, right := 0, 0
	for _,v := range weights{
		if left < v {
			left = v
		}
		right += v
	}

	for left < right {
		mid := (left+right)/2

		days :=1
		temp :=0
		for _,v := range weights{
			temp+=v
			if temp > mid {
				days+=1
				temp=v
			}
		}

		if days > D {
			left = mid+1
		}else {
			right = mid
		}
	}
	return  left
}
