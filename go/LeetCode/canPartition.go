package main

import "fmt"

func main() {
	nums := []int{1,5,11,5}
	fmt.Print(canPartition(nums))
}

func canPartition(nums []int) bool {
	sum:=0
	for _,v :=range nums{
		sum+=v
	}
	if sum%2==1 {
		return false
	}
	cap:=sum/2
	dp :=make([][]bool, len(nums))
	for i:=range dp{
		dp[i] = make([]bool, cap+1)
	}
	if nums[0]<=cap {
		dp[0][nums[0]]=true
	}
	for i:=1;i<len(nums);i++ {
		for j:=0;j<=cap;j++ {
			dp[i][j]=dp[i-1][j]
			if nums[i] < j {
				dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
			}
			if nums[i] == j {
				dp[i][j]=true
			}
		}
	}
	return dp[len(nums)-1][cap]
}

func canPartition1(nums []int) bool {
	sum:=0
	for _,v :=range nums{
		sum+=v
	}
	if sum%2==1 {
		return false
	}
	cap:=sum/2
	dp := make([]bool, cap+1)
	if nums[0] <=cap {
		dp[nums[0]]=true
	}

	for i:=1;i<len(nums);i++ {
		for j:=cap;j>=nums[i];j-- {
			if nums[i]<j {
				dp[j] = dp[j] || dp[j-nums[i]]
			}
			if nums[i]==j {
				dp[j] = true
			}
		}
	}
	return dp[cap]
}