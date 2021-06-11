package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func main() {
	node1 := &TreeNode{}
	node1.Val = 1
	node3 := &TreeNode{}
	node3.Val = 2
	node1.Right = node3

	node2 := &TreeNode{}
	node2.Val = 2
	node4 := &TreeNode{}
	node4.Val = 2
	node2.Right = node4

	fmt.Print(leafSimilar(node1, node2))
	
}

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {

	leaf := []int{}

	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node != nil {
			if node.Right == nil && node.Right == nil {
				leaf = append(leaf, node.Val)
			}
			if node.Left != nil {
				dfs(node.Left)
			}
			if node.Right !=nil {
				dfs(node.Right)
			}
		}
	}

	dfs(root1)
	leaf1 := append([]int{}, leaf...)
	leaf = []int{}
	dfs(root2)

	if len(leaf1) != len(leaf) {
		return false
	}
	for i, v := range leaf1 {
		if v != leaf[i] {
			return false
		}
	}
	return true
}
