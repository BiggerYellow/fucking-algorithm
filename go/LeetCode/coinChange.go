package main

func main() {
	
}

func coinChange(coins []int, amount int) int {
	max:=amount+1
	dp := make([]int, amount+1)
	for i,_ :=range dp{
		dp[i] = max
	}
	dp[0]=0
	for _,v := range coins {
		for j:=v;j<=amount;j++ {
			dp[j] = min(dp[j], dp[j-v]+1)
		}
	}
	if dp[amount]==max {
		return -1
	}else {
		return dp[amount]
	}
}
