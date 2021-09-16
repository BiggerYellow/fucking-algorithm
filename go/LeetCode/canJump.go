package main

func main() {
	
}

func canJump(nums []int) bool {
	max :=0
	for i:=0;i<len(nums);i++ {
		if i>max {
			return false
		}
		max = max111(max, i+nums[i])
	}
	return true
}

func max111(x int, y int) int {
	if x>y {
		return x
	}else {
		return y
	}
}