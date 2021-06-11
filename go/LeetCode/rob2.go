package main

func main() {
	
}

func rob3(root *TreeNode) int {
	res := dfs(root)
	return max(res[0], res[1])
}

func dfs(root *TreeNode) []int{
	if root == nil {
		return make([]int,2)
	}
	temp := make([]int, 2)
	left := dfs(root.Left)
	right := dfs(root.Right)

	temp[0] = max(left[0], left[1]) + max(right[0], right[1])
	temp[1] = left[0] + right[0] + root.Val
	return temp
}

func max1(x int, y int) int {
	if x>y {
		return x
	}else {
		return y
	}
}



