package main

import "fmt"

//type TreeNode struct {
//	Val int
//	Left *TreeNode
//	Right *TreeNode
//}

func main() {
	node1 := &TreeNode{}
	node1.Val = 5
	node2 := &TreeNode{}
	node2.Val = 1
	node3 := &TreeNode{}
	node3.Val = 7

	node1.Left  = node2
	node1.Right  = node3

	fmt.Print(increasingBST(node1))
}

func increasingBST(root *TreeNode) *TreeNode {
	dummy :=&TreeNode{}
	res := dummy

	var BST func(*TreeNode)
	BST = func(node *TreeNode) {
		if node != nil {
			BST(node.Left)
			res.Right = node
			node.Left = nil
			res = node
			BST(node.Right)
		}
	}
	BST(root)
	return dummy.Right
}
