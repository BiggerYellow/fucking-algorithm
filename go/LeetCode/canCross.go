package main

import "fmt"

func main() {
	stones := []int{0,1,3,5,6,8,12,17}
	fmt.Print(canCross1(stones))
	
}

func canCross(stones []int) bool {
	dp := make([][]bool, len(stones))
	for i := range dp {
		dp[i] = make([]bool, len(stones))
	}
	dp[0][0] = true
	for i:=1;i<len(stones);i++ {
		if stones[i] - stones[i-1] > i {
			return false
		}
	}

	for i:=1;i<len(stones);i++ {
		for j:=i-1;j>=0;j-- {
			k := stones[i] - stones[j]
			if k > j+1 {
				break
			}
			dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1]
			if i == len(stones)-1 && dp[i][k] {
				return true
			}
		}
	}
	return false
}

func canCross1(stones []int) bool{
	cache := make(map[string]bool)
	nums := make(map[int]int)
	for i,v := range stones{
		nums[v] = i
	}
	if nums[1] == 0 {
		return false
	}
	var dfs func([]int, int, int) bool
	dfs = func(stones []int, i int, k int) bool {
		key := string(i)+"_"+string(k)
		if cache[key] {
			return cache[key]
		}
		for j:=-1;j<=1;j++ {
			if j+k ==0 {
				continue
			}
			next := nums[i] + j + k
			if nums[next] != 0 {
				flag := dfs(stones, nums[next], j+k)
				cache[key] = flag
				if flag {
					return true
				}
			}
		}
		cache[key] = false
		return false
	}
	return dfs(stones, 0, 0)
}
