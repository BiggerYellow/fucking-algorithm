package main

func main() {
	
}

func stoneGame(piles []int) bool  {
	lenght := len(piles)
	dp := make([][]int, lenght)
	for i:=0;i<lenght;i++ {
		dp[i] = make([]int, lenght)
	}
	for i:=0;i<lenght;i++ {
		dp[i][i] = piles[i]
	}

	for i:=lenght-1;i>=0;i-- {
		for j:=i+1;j<lenght;j++ {
			dp[i][j] = max22(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1]);
		}
	}
	return dp[0][lenght-1]>0
}

func max22(x int, y int) int {
	if x>y {
		return x
	}
	return y
}
