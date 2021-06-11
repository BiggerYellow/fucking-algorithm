package main

import "fmt"

func main() {
	nums := []int{1,1,1,1,1}
	//nums := []int{1}
	fmt.Println(findTargetSumWays2(nums, 3))
}


func findTargetSumWays(nums []int, target int) (count int) {
	var dfs func(int,int)
	dfs = func(index int, sum int) {
		if index == len(nums) {
			if sum == target {
				count++
			}
		}else {
			dfs(index+1, sum+nums[index])
			dfs(index+1, sum-nums[index])
		}
	}
	dfs(0,0)
	return count
}



func findTargetSumWays1(nums []int, target int) int {
	sum:=0
	for i:=0;i<len(nums);i++ {
		sum+=nums[i]
	}
	diff := sum-target
	if diff<0 || diff%2!=0 {
		return 0
	}
	mins := diff/2
	dp:=make([][]int, len(nums)+1)
	for i:= range dp{
		dp[i] = make([]int, mins+1)
	}
	dp[0][0]=1

	for i:=1;i<=len(nums);i++ {
		num := nums[i-1]
		for j:=0;j<=mins;j++ {
			dp[i][j] = dp[i-1][j]
			if j>=num {
				dp[i][j]+=dp[i-1][j-num]
			}
		}
	}
	return dp[len(nums)][mins]

}

func findTargetSumWays2(nums []int, target int) int {
	sum:=0
	for _,v := range nums{
		sum+=v
	}
	diff := sum-target
	if diff<0 || diff%2!=0 {
		return 0
	}
	mins := diff/2
	dp := make([]int, mins+1)
	dp[0]=1
	for _,v := range nums{
		for j:=mins;j>=v;j-- {
			dp[j] += dp[j-v]
		}
	}
	return dp[mins]
}
