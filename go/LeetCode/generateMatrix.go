package main

import "fmt"

func main() {
	fmt.Print(generateMatrix(3))
}

func generateMatrix(n int) [][]int {
	//二维动态数组 先创建二维再创建里面的一维
	res := make([][]int, n)
	for i := range res {
		res[i] = make([]int, n)
	}
	left :=0
	right := n-1
	up := 0
	down := n-1
	num :=1
	for true {
		for i:=left;i<=right;i++ {
			res[up][i] = num
			num++
		}
		up++
		if up > down {
			break
		}
		for i:=up;i<=down;i++ {
			res[i][right] = num
			num++
		}
		right--
		if right < left {
			break
		}
		for i:=right;i>=left;i-- {
			res[down][i] = num
			num++
		}
		down--
		if down < up {
			break
		}
		for i:=down;i>=up;i-- {
			res[i][left] = num
			num++
		}
		left++
		if left > right {
			break
		}
	}
	return res
}
