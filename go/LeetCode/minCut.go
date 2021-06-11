package main

import (
	"fmt"
	"math"
)

func main() {
	s:="ss"
	fmt.Println(minCut(s))
}


func minCut(s string) int {
	length := len(s)
	dp:=make([][]bool, length)
	for i:= range dp{
		dp[i] = make([]bool, length)
		for j:=range dp[i]{
			dp[i][j] = true
		}
	}

	for i:=length-1;i>=0;i-- {
		for j:=i+1; j<length;j++ {
			dp[i][j] = s[i]==s[j] && dp[i+1][j-1]
		}
	}

	f:= make([]int, length)
	for i:= range f{
		if dp[0][i] {
			continue
		}
		f[i] = math.MaxInt64
		for j:=0;j<i;j++ {
			if dp[j+1][i] && f[j]+1 < f[i] {
				f[i] = f[j]+1
			}
		}
	}
	return f[length-1]
}


