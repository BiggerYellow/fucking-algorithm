package main

func main() {
	
}

const INT_MAX = int(^uint(0) >> 1)

func twoEggDrop(n int) int {
	dp:=make([][]int, n+1)
	for i := range dp{
		dp[i] = make([]int, 2)
	}
	for i:=range dp{
		for j:=range dp[i]{
			dp[i][j] = INT_MAX
		}
	}

	dp[0][0]=0

	for i:=1;i<=n;i++ {
		dp[i][0]=i
	}

	for i:=1;i<=n;i++ {
		for k:=1;k<=i;k++ {
			dp[i][1] = min(dp[i][1], max(dp[k-1][0]+1, dp[i-k][1]+1))
		}
	}
	return dp[n][1]
}

func twoEggDrop1(n int) int {
	dp:=make([]int, n+1)
	for i:=range dp{
		dp[i] = INT_MAX
	}
	dp[0]=0
	for i:=1;i<=n;i++ {
		for k:=1;k<=i;k++ {
			dp[i] = min(dp[i], max(k, dp[i-k]+1))
		}
	}
	return dp[n]
}

func min(x int, y int) int {
	if x<y {
		return x
	}else {
		return y
	}
}

func max4(x int, y int) int {
	if x>=y {
		return x
	}else {
		return y
	}
}