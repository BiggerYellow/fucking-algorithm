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

	fmt.Print(rangeSumBST(node1, 3,8))
	
}

func rangeSumBST(root *TreeNode, low int, high int) int {
	res := 0
	var BST func(*TreeNode)
	BST = func(node * TreeNode){
		if node == nil{
			return
		}
		BST(node.Left)
		if(node.Val >= low && node.Val <= high){
			res+=node.Val
		}
		BST(node.Right)
	}
	BST(root)
	return res
}
