package main

func main() {
	
}

func lastStoneWeightII(stones []int) int {
	sum:=0
	for _,v :=range stones{
		sum+=v
	}
	cap:=sum/2
	dp := make([][]int, len(stones)+1)
	for i,_ := range dp{
		dp[i] = make([]int, cap+1)
	}

	for i:=1;i<=len(stones);i++ {
		for j:=0;j<=cap;j++ {
			if j>=stones[i-1] {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-stones[i-1]]+stones[i-1])
			}else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}
	return sum-dp[len(stones)][cap]*2
}

func lastStoneWeightII1(stones []int) int {
	sum:=0
	for _,v := range stones{
		sum+=v
	}
	cap:=sum/2
	dp:=make([]int, cap+1)
	for _,num := range stones{
		for j:=cap;j>=num;j-- {
			dp[j] = max(dp[j-num]+num, dp[j])
		}
	}
	return sum-dp[cap]*2
}
