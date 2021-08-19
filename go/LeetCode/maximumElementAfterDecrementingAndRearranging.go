package main

import (
	"sort"
)

func main() {
	
}

func maximumElementAfterDecrementingAndRearranging(arr []int) int {
	length := len(arr)
	sort.Ints(arr)
	arr[0]=1
	for i:=1;i<length;i++{
		if arr[i]-arr[i-1]>0{
			arr[i] = arr[i-1]+1
		}
	}
	return arr[length-1]
}