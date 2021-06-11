package main

import "fmt"

func main() {
	arr := []int{4,8,2,10}
	queries := [][]int{{2,3},{1,3},{0,0},{0,3}}
	fmt.Print(xorQueries(arr, queries))
}

func xorQueries(arr []int, queries [][]int) []int {
	n:= len(arr)
	dp := make([]int, n)
	dp[0] = arr[0]
	for i:=1;i<n;i++ {
		dp[i] = dp[i-1] ^ arr[i]
	}

	res := make([]int, len(queries))
	for i,v := range queries{
		if v[0] == 0 {
			res[i] = dp[v[1]]
		}else {
			res[i] = dp[v[0]-1] ^ dp[v[1]]
		}
	}
	return res
}
