package main

import (
	"fmt"
	"sort"
)

func main() {
	nums :=[]int{1,2,2}
	fmt.Print(subsetsWithDup(nums))
}

func subsetsWithDup(nums []int) (ans [][]int) {
	sort.Ints(nums)
	t:=[]int{}

	var dfs func(bool, int)
	dfs = func(choosePre bool, cur int) {
		if cur==len(nums) {
			ans = append(ans, append([]int(nil),t...))
			return
		}
		dfs(false,cur+1)
		if !choosePre && cur >0 && nums[cur-1] == nums[cur] {
			return
		}
		t=append(t, nums[cur])
		dfs(true, cur+1)
		t=t[:len(t)-1]
	}
	dfs(false, 0)
	return
}
