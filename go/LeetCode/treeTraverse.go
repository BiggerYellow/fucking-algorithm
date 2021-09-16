package main

type TreeNode struct {
	Val int
	Left,Right *TreeNode
}

func main() {
	node1 := &TreeNode{1, nil,nil}
	node2 := &TreeNode{2,nil,nil}
	node3 := &TreeNode{3,nil,nil}
	node4 := &TreeNode{4,nil,nil}
	node5 := &TreeNode{5,nil,nil}
	node6 := &TreeNode{6,nil,nil}
	node7 := &TreeNode{7,nil,nil}
	node1.Left = node2
	node1.Right = node3
	node2.Left = node4
	node2.Right = node5
	node3.Left = node6
	node3.Right = node7
	res:=BFS(node1)
	print(res)

}

func traverse(node *TreeNode) []int {
	res := []int{}
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node != nil {
			//1.先序遍历
			res = append(res, node.Val)
			dfs(node.Left)
			//2.中序遍历
			res = append(res, node.Val)
			dfs(node.Right)
			//3.后序遍历
			res = append(res, node.Val)
		}
	}
	dfs(node)
	return res
}

func BFS(node *TreeNode) []int {
	res := make([]int, 0)
	queue := make([]*TreeNode , 0)
	queue = append(queue, node)
	for len(queue)!=0 {
		temp := queue[0]
		res = append(res, temp.Val)
		if temp.Left!=nil {
			queue = append(queue, temp.Left)
		}
		if temp.Right!=nil {
			queue = append(queue, temp.Right)
		}
		queue = queue[1:]
	}
	return res
}

