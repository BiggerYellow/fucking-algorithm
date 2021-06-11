package main

import "sort"

func main() {

}

func kthLargestValue(matrix [][]int, k int) int {
	m := len(matrix)
	n := len(matrix[0])
	res := make([]int,0, m*n)
	dp := make([][]int, m+1)
	dp[0] = make([]int ,n+1)
	for i,row := range matrix{
		dp[i+1] = make([]int, n+1)
		for j,val := range row{
			dp[i+1][j+1] = dp[i+1][j] ^ dp[i][j+1] ^ dp[i][j] ^ val
			res = append(res, dp[i+1][j+1])
		}
	}
	sort.Sort(sort.Reverse(sort.IntSlice(res)))
	return res[k-1]
}