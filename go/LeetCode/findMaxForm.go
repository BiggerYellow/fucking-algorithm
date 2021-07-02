package main

import "strings"

func main() {
	
}

func findMaxForm(strs []string, m int, n int) int {
	length:=len(strs)
	dp:=make([][][]int, length+1)
	for i:= range dp{
		dp[i] = make([][]int,m+1)
		for j := range dp[i]{
			dp[i][j] = make([]int, n+1)
		}
	}

	for i:=1;i<=length;i++ {
		str:=strs[i-1]
		count0:=strings.Count(str, "0")
		count1:=strings.Count(str, "1")

		for j:=0;j<=m;j++ {
			for k:=0;k<=n;k++ {
				dp[i][j][k] = dp[i-1][j][k]
				if j>=count0 && k>=count1 {
					dp[i][j][k] = max(dp[i-1][j][k], dp[i-1][j-count0][k-count1]+1)
				}
			}
		}
	}
	return dp[length][m][n]
}

func max11(x int, y int) int {
	if x>=y {
		return x
	}else {
		return y
	}
}

func findMaxForm1(strs []string, m int, n int) int {
	dp:=make([][]int, m+1)
	for i:= range dp {
		dp[i] = make([]int, n+1)
	}

	for _,v := range strs{
		count0:=strings.Count(v, "0")
		count1:=strings.Count(v, "1")

		for j:=m;j>=count0;j-- {
			for k:=n;k>=count1;k-- {
				dp[j][k] = max(dp[j][k], dp[j-count0][k-count1] + 1)
			}
		}
	}
	return dp[m][n]
}