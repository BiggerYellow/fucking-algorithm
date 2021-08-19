package main

func main() {
	s:="bbbab"
	print(longestPalindromeSubseq(s))
}

func longestPalindromeSubseq(s string) int {
	length := len(s)
	dp := make([][]int, length)
	for i := range dp{
		dp[i] = make([]int, length)
	}
	for i,_ := range dp {
		dp[i][i] = 1
	}
	for i:=length-1;i>=0;i-- {
		for j:=i+1;j<length;j++ {
			if s[i] == s[j] {
				dp[i][j] = dp[i+1][j-1]+2
			}else {
				dp[i][j] = max121(dp[i+1][j], dp[i][j-1])
			}
		}
	}
	return dp[0][length-1]
}

func max121(x int, y int) int {
	if x>y {
		return x
	}
	return y
}


