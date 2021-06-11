package main

import "fmt"

func main() {
	matrix := [][] int{{1,2,3},{4,5,6},{7,8,9}}
	fmt.Print(spiralOrder(matrix))
}
func spiralOrder(matrix [][]int) []int {
	res := []int{}
	n := len(matrix)
	m := len(matrix[0])
	up :=0
	down := n-1
	left := 0
	right := m-1
	for true {
		for i:=left;i<=right;i++ {
			res = append(res, matrix[up][i])
		}
		up++
		if up > down {
			break
		}
		for i:=up;i<=down;i++ {
			res = append(res, matrix[i][right])
		}
		right--
		if right < left {
			break
		}
		for i:=right;i>= left;i-- {
			res = append(res, matrix[down][i])
		}
		down--
		if down<up {
			break
		}
		for i:= down;i>=up;i-- {
			res = append(res, matrix[i][left])
		}
		left++
		if left> right {
			break
		}
	}
	return res
}