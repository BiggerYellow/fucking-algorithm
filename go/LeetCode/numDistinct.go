package main

import "fmt"

func main() {
	s:="babgbag"
	t:="bag"
	fmt.Print(numDistinct1(s,t))
}

func numDistinct(s string, t string) int {
	dp := make([][]int, len(s)+1)
	for i:= range dp{
		dp[i] = make([]int,len(t)+1)
	}
	for i:=0;i<=len(s);i++ {
		dp[i][len(t)] = 1
	}
	for i:=len(s)-1;i>=0;i-- {
		for j:=len(t)-1;j>=0;j-- {
			if s[i] == t[j] {
				dp[i][j] = dp[i+1][j+1] + dp[i+1][j]
			}else {
				dp[i][j] = dp[i+1][j]
			}
		}
	}
	return dp[0][0]
}

func numDistinct1(s string, t string) int {
	dp:=make([][]int, len(t)+1)
	for i:=range dp{
		dp[i] = make([]int, len(s)+1)
	}
	for j:=0;j<len(s)+1;j++ {
		dp[0][j] = 1
	}
	for i:=1;i<len(t)+1;i++ {
		for j:=1;j<len(s)+1;j++ {
			if t[i-1] == s[j-1] {
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
			}else {
				dp[i][j] = dp[i][j-1]
			}
		}
	}
	return dp[len(t)][len(s)]
}

