package main

import "math"

func main() {
	
}

//type TreeNode struct {
//	Val int
//	Left *TreeNode
//	Right *TreeNode
//}

func minDiffInBST(root *TreeNode) int {
	res, pre := math.MaxInt64, -1
	var dfs func(node *TreeNode)
	
	dfs = func(node *TreeNode) {
		if node == nil{
			return
		}
		dfs(node.Left)
		if pre != -1 && node.Val - pre < res {
			res = node.Val - pre
		}
		pre = node.Val
		dfs(node.Right)
	}
	dfs(root)
	return res
}