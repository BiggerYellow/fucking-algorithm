package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Print(numWays(3,2))
}

func numWays(steps int, arrLen int) int {
	const mod = 1e9 + 7
	maxCol := int(math.Min(float64(steps/2+1), float64((arrLen-1))))
	dp := make([]int, maxCol+1)
	dp[0] = 1
	for i:=1;i<=steps;i++ {
		temp := make([]int, maxCol+1)
		for j:=0;j<=maxCol;j++ {
			if j==0 {
				temp[j] = (dp[j] + dp[j+1]) % mod
			}else if j == maxCol {
				temp[j] = (dp[j] + dp[j-1]) % mod
			}else {
				temp[j] = (dp[j] + dp[j-1] + dp[j+1])%mod
			}
		}
		dp = temp
	}
	return dp[0]
}