package main

import "fmt"

func main() {
	//s := "9,3,4,#,#,1,#,#,2,#,6,#,#"
	//s := "9,#,#,1"
	s := "9,#,92,#,#"
	fmt.Print(isValidSerialization1(s))
}
func isValidSerialization(preorder string) bool {
	stack :=[]int{1}

	for i:=0;i<len(preorder);{
		if len(stack) == 0 {
			return false
		}
		if preorder[i]==',' {
			i++
		}else if preorder[i]=='#' {
			temp :=stack[len(stack)-1]-1
			if temp!=0 {
				stack[len(stack)-1]  = temp
			}else {
				stack = stack[:len(stack)-1]
			}
			i++
		}else {
			// 读一个数字
			for i < len(preorder) && preorder[i] != ',' {
				i++
			}
			temp :=stack[len(stack)-1]-1
			if temp!=0 {
				stack[len(stack)-1]  = temp
			}else {
				stack = stack[:len(stack)-1]
			}
			stack = append(stack,2)
		}

	}
	return len(stack)==0
}

func isValidSerialization1(preorder string) bool {
	n := len(preorder)
	slots := 1
	for i:=0;i<n;{
		if slots == 0 {
			return false
		}
		if preorder[i] == ',' {
			i++
		}else if preorder[i] == '#' {
			i++
			slots--
		}else {
			for i<n && preorder[i] != ',' {
				i++
			}
			slots++
		}
	}
	return slots==0
}
