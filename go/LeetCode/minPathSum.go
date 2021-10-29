package main

func main() {
	
}

func minPathSum(grid [][]int) int {
	m:=len(grid)
	n:=len(grid[0])

	dp:=make([][]int, m)
	for i := range dp{
		dp[i] = make([]int, n)
	}
	dp[0][0]= grid[0][0]
	for i:=1;i<n;i++ {
		dp[0][i] = dp[0][i-1]+grid[0][i]
	}
	for j:=1;j<m;j++ {
		dp[j][0]=dp[j-1][0]+grid[j][0]
	}

	for i:=1;i<m;i++ {
		for j:=1;j<n;j++ {
			dp[i][j] = grid[i][j] +min22(dp[i-1][j], dp[i][j-1])
		}
	}
	return dp[m-1][n-1]
}

func min22(x int, y int) int {
	if x<y {
		return x
	}
	return y
}
